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

        List<int[]> arr = new ArrayList(); 
       for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            arr.add(new int[]{entry.getKey(), entry.getValue()});
       }

       Collections.sort(arr, (a,b)-> b[1] - a[1]);

       int[] res = new int[k]; 

       for(int i=0; i<k; i++){
            res[i] = arr.get(i)[0];
       }

       return res; 
    }
}
