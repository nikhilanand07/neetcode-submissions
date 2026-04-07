class Solution {
    public int findMin(int[] nums) {
        int l = 0; 
        int r = nums.length - 1; 

        while(l<r){
            int mid = (l+r)/2; 

            if(nums[mid] > nums[r]){
                // left half is sorted. 
                l = mid+1; 
            }else {
                // right half is sorted.
                r = mid;
            }
        }

        return nums[l];
    }
}
