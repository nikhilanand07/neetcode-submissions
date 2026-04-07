class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet(); 

        int n = nums.length; 

        Map<Integer, Integer> map = new HashMap(); 
        for(int i=0; i<n; i++){
            map.put(nums[i], i);
        }



        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                
                int complement = - ( nums[i] + nums[j]);
                if(map.containsKey(complement) && map.get(complement) != i && map.get(complement) != j){
                    List<Integer> list = Arrays.asList(nums[i], nums[j], complement);
                    Collections.sort(list); 
                    set.add(list);
                }
                   
            }
        }

        List<List<Integer>> result = new ArrayList(); 

        for(List<Integer> list : set){
            result.add(list);
        }

        return result;
    }
}
