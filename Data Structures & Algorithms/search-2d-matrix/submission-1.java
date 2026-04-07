class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length; 
        int col = matrix[0].length; 

        for(int i=0; i<row; i++){
            if(target >= matrix[i][0] && target <= matrix[i][col-1] ){
                return search(matrix[i], target);
            }
        }

        return false;
    }

    public boolean search(int[] nums, int target) {
        
        int l = 0; 
        int r = nums.length-1;

        while(l<=r){
            int mid = (l+r)/2; 

            if(nums[mid] == target){
                return true; 
            }else if(nums[mid] > target){
                r = mid-1; 
            }else {
                l = mid+1; 
            }
        } 

        return false; 

    }
}
