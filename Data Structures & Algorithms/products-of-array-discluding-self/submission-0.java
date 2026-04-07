class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length; 
        int prefix[] = new int[n]; 
        int suffix[] = new int[n];
        int[] finalRes = new int[n]; 

        // calculate prefix
        for(int i=0; i<n; i++){
            if(i==0){
                prefix[i] = 1; 
            }else{
                prefix[i] = prefix[i-1] * nums[i-1];
            }
        }

        // calculate suffix
        for(int i=n-1; i>=0; i--){
            if(i==n-1){
                suffix[i] = 1; 
            }else{
                suffix[i] = suffix[i+1] * nums[i+1];
            }
        }

        for(int i=0; i<n; i++){
            finalRes[i] = prefix[i] * suffix[i];
        }

        return finalRes; 
    }
}  
