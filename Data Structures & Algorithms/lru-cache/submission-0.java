class LRUCache {
    private int maxCap;
    private Map<Integer, Integer> cache;
    public LRUCache(int capacity) {
        maxCap = capacity;
        cache = new LinkedHashMap<>(maxCap, 1.0f, true);
    }
    
    public int get(int key) {
        return cache.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            cache.put(key, value);
            return;
        }

        if(cache.size() >= maxCap){
            Map.Entry<Integer, Integer> eldest = cache.entrySet().iterator().next();
            cache.remove(eldest.getKey());
        }

        cache.put(key, value);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */


 /*
 Using in built DS - LinkedHashMap

 cache = new LinkedHashMap<>(maxCap, 1.0f, true);
 1. initial size
 2. load factor  -> so resizing will happen after 100% full, default is 0.75f which indicates when map is 75% full (lets say size is 5, then 0.75 * 5 = 4 -> after 4 insertions map is resized)
 3. access order -> true indicates maintain access order 
 put (1,2,3)
 get (1)

 access order true -> final map : 2 3 1
 access order false -> final map : 1 2 3 (maintains insertion order)


TC : Initialization O(1), get O(1), put O(1) : O(1)
SC : O(capacity)


LinkedHashMap internally uses HashMap for O(1) access and a doubly linked list for maintaining insertion/access order.
*/