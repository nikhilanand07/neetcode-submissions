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
    boolean result = true;
    public boolean isBalanced(TreeNode root) {
        balanced(root); 

        return result; 
    }

    public int balanced(TreeNode root){
        if(root == null)
            return 0; 

        int lh = balanced(root.left); 
        int rh = balanced(root.right); 

        if(Math.abs(lh - rh) > 1)
            result = false; 

        return 1 + Math.max(lh, rh);
    }
}
