class Pair{
    int key; 
    int value =0; 

    Pair(int key, int value){
        this.key = key; 
        this.value = value; 
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       
        Map<Integer, Pair> map = new HashMap(); 

        for(int n : nums){
            map.putIfAbsent(n, new Pair(n, 0)); 
            map.get(n).value++; 
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.value - b.value);

        for(Pair p : map.values()){
            pq.add(p);

            if(pq.size() > k){
                pq.poll(); 
            }
        }

        int[] res = new int[k]; 

        for(int i=0; i<k; i++){
            res[i] = pq.poll().key; 
        }

        return res; 
        
    }
}
