class Solution {
    public int trap(int[] height) {
        int n = height.length; 
        int[] leftMax = new int[n];
        int[] rightMax = new int[n]; 

        // calculating left max 
        leftMax[0] = height[0]; 
        for(int i=1; i<n; i++){
            leftMax[i] = Math.max(leftMax[i-1], height[i]); 
        }

        // calculating right max 
        rightMax[n-1] = height[n-1];
        for(int i= n-2; i>=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        } 

        int maxArea = 0; 

        for(int i=0; i<n; i++){
            int area = Math.min(leftMax[i], rightMax[i]) - height[i];
            if(area > 0){
                maxArea += area;
            }
        }

        return maxArea;

    }
}
