class Pair{
    private int key; 
    private int value =0; 

    Pair(int key, int value){
        this.key = key; 
        this.value = value; 
    }

    public int getValue(int key){
        return this.value; 
    }

    public void setValue(int key, int value){
        this.value = value; 
    }
}

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> map = new HashMap(); 

       for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
       }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        // PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.offer(new int[]{entry.getKey(), entry.getValue()});

            if(pq.size() > k){
                pq.poll(); 
            }
        }

        int[] res = new int[k]; 
        for(int i=0; i<k; i++){
            res[i] = pq.poll()[0]; 
        }

        return res; 
    }
}
