package leetcode;

class P105_Construct_Binary_Tree_from_Preorder_and_Inorder_Traversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        TreeNode node = new TreeNode(preorder[0]);
        int rootIndex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == preorder[0]) {
                rootIndex = i;
                break;
            }
        }
        if (rootIndex > 0) {
            int[] left_preorder = new int[rootIndex];
            int[] left_inorder = new int[rootIndex];
            System.arraycopy(preorder, 1, left_preorder, 0, rootIndex);
            System.arraycopy(inorder, 0, left_inorder, 0, rootIndex);

            node.left = buildTree(left_preorder, left_inorder);
        } else {
            node.left = null;
        }

        if (preorder.length - rootIndex - 1 > 0) {
            int[] right_preorder = new int[preorder.length - rootIndex - 1];
            int[] right_inorder = new int[preorder.length - rootIndex - 1];
            System.arraycopy(preorder, 1 + rootIndex, right_preorder, 0, preorder.length - rootIndex - 1);
            System.arraycopy(inorder, 1 + rootIndex, right_inorder, 0, preorder.length - rootIndex - 1);

            node.right = buildTree(right_preorder, right_inorder);
        } else {
            node.right = null;
        }


        return node;
    }
}
