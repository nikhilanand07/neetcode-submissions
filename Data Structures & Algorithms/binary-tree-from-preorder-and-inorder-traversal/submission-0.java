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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0)
            return null; 

        int rootVal = preorder[0]; // first element always root
        TreeNode root = new TreeNode(rootVal); 

        int idx = 0; 
        for(int ele : inorder){
            if(ele == rootVal){
                break; 
            }

            idx++; 
        }

        // split inorder 
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, idx); 
        int[] rightInorder = Arrays.copyOfRange(inorder, idx+1, inorder.length); 

        // split preorder 
        int[] leftPre = Arrays.copyOfRange(preorder, 1, 1+leftInorder.length);
        int[] rightPre = Arrays.copyOfRange(preorder, 1+leftInorder.length, preorder.length); 

        root.left = buildTree(leftPre, leftInorder); 
        root.right = buildTree(rightPre, rightInorder); 

        return root; 
    }
}
