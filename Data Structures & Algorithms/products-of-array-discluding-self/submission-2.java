class Solution {
    public int[] productExceptSelf(int[] nums) {
        // count how many zeros are there. If there is only one zero then only the index where zero 
        // exist will have the product. Except that all indexes will have 0; If there are more than 
        // one zero then all the indexes will have zero. 

        int countZero = 0; 
        int product = 1; 
        for(int n : nums){
            if(n == 0){
                countZero++; 
            }else{
                product *= n;
            }
        }

        int res[] = new int[nums.length];
        if(countZero == 0){
            for(int i=0; i<nums.length; i++){
                res[i] = product / nums[i];
            }
        }else if(countZero == 1){
            for(int i=0; i<nums.length; i++){
               res[i] =  nums[i] == 0 ? product : 0;
            }
        }else{
            for(int i=0; i<nums.length; i++){
                res[i] = 0;
            }
        }

        return res; 
    }
}  
