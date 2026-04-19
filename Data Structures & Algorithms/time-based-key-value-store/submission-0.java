class TimeMap {
    class Pair{
        int timeStamp; 
        String value; 

        Pair(int t, String v){
            this.timeStamp = t; 
            this.value = v; 
        }
    }

    Map<String, List<Pair>> map; 

    public TimeMap() {
        map = new HashMap<>(); 
    }
    
    public void set(String key, String value, int timestamp) {
        map.putIfAbsent(key, new ArrayList()); 
        map.get(key).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key))
            return ""; 

        List<Pair> p = map.get(key); 

        int left = 0, right = p.size()-1; 

        String res = ""; 
        while(left <= right){
            int mid = (left + right) / 2; 

            if(p.get(mid).timeStamp == timestamp)
                return p.get(mid).value;

            else if(p.get(mid).timeStamp < timestamp){
                res = p.get(mid).value; 
                left = mid+1; 
            }else{
                right = mid-1; 
            }
        }

        return res; 
    }
}

/*
    ("bar", 1), ("bar2", 3)

    2
*/
