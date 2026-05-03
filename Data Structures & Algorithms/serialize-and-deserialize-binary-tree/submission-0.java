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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder(); 
        dfs(root, sb); 
        return sb.toString(); 
    }

    public void dfs(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,"); 
            return; 
        }

        sb.append(root.val).append(",");
        dfs(root.left, sb); 
        dfs(root.right, sb); 
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");

        int[] idx = new int[1];

        return buildTree(arr, idx);
    }

    private TreeNode buildTree(String[] arr, int[] idx){
        if(arr[idx[0]].equals("null")){
            idx[0]++; 
            return null; 
        }

        TreeNode root = new TreeNode(Integer.parseInt(arr[idx[0]++])); 
        root.left = buildTree(arr, idx); 
        root.right = buildTree(arr, idx); 

        return root; 
    }
}
