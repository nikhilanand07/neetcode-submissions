/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int maxSum = Integer.MIN_VALUE; 
    public int maxPathSum(TreeNode root) {
        dfs(root); 
        return maxSum;        
    }

    public int dfs(TreeNode root){
        if(root == null)
            return 0; 

        int left = dfs(root.left); 
        int right = dfs(root.right); 

        left = Math.max(0, left); 
        right = Math.max(0, right); 

        int currPath = left + right + root.val; 

        maxSum = Math.max(maxSum, currPath); 

        return Math.max(left, right) + root.val; 
    }
}

/*
- Each node exactly visited once
TC - O(n)

SC - O(n) - worst case - in case of skewed tree. [ taken by rec stack ]

*/
