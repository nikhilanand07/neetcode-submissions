class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        int product = 1; 

        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];

        // calculating prefix
        prefix[0] = 1; 
        for(int i=1; i<nums.length; i++){
            prefix[i] = prefix[i-1] * nums[i-1];
        }

        // calculating suffix 
        suffix[nums.length-1] = 1; 
        for(int i=nums.length-2; i>=0; i--){
            suffix[i] = suffix[i+1] * nums[i+1];
        }

        int[] res = new int[nums.length];

        for(int i=0; i<nums.length; i++){
            res[i] = prefix[i] * suffix[i];
        }

        return res; 
    }  
}


// prefix = [1, 1, 2, 8]
// suffix = [48,24,6,1]

// result = [prefix * suffix]



