class Solution {
    int preorderIndex = 0;
    Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // Step 1: store inorder indices
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return build(preorder, 0, inorder.length - 1);
    }

    private TreeNode build(int[] preorder, int left, int right) {
        // base case
        if (left > right) return null;

        // Step 2: pick root from preorder
        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        // Step 3: find root in inorder
        int index = inorderMap.get(rootVal);

        // Step 4: build left subtree
        root.left = build(preorder, left, index - 1);

        // Step 5: build right subtree
        root.right = build(preorder, index + 1, right);

        return root;
    }
}