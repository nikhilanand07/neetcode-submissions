class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
       
       List<List<Integer>> res = new ArrayList(); 
       Arrays.sort(nums); 

       
       for(int i=0; i<nums.length-2; i++){

            if(i>0 && nums[i] == nums[i-1]){
                continue; // skip duplicates
            }

            int l = i+1; 
            int r = nums.length-1; 

            int target = - nums[i];

            while(l<r){
                int sum = nums[l] + nums[r];

                if(sum == target){
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    // skip left duplicates    
                    while(l<r && nums[l] == nums[l+1]){
                        l++;
                    } 

                    // skip right duplicates

                    while(l<r && nums[r] == nums[r-1]){
                        r--;
                    }
                    l++; 
                    r--;
                }else if(sum > target){
                    r--;
                }else{
                    l++;
                }
            }
       }

       return res; 
       
    }
}
