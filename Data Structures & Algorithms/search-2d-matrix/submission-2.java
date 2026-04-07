class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length; 
        int col = matrix[0].length; 

        int left = 0; 
        int right = row-1; 
        while(left <= right){
            int mid = (left + right)/2; 

            if(matrix[mid][0] <= target && matrix[mid][col-1] >= target){
                boolean res = search(matrix[mid], target);
                System.out.println(res);
                return search(matrix[mid], target);
            }else if(matrix[mid][0] >= target){
                right = mid-1; 
            }else {
                left = mid+1;
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
