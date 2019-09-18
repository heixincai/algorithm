package leetcode;

class P106_Construct_Binary_Tree_from_Inorder_and_Postorder_Traversal {

    // 23:09

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(0, 0, inorder.length, inorder, postorder);
    }

    public TreeNode helper(int iStart, int pStart, int length, int[] iorder, int[] porder) {
        if (iStart > iorder.length - 1 && length > 0) {
            int root = porder[pStart + length - 1];
            TreeNode node = new TreeNode(root);

            int rootIndex = 0;

            for (int i = iStart; i < iStart + length; i++) {
                if (iorder[i] == root) {
                    rootIndex = i;
                    break;
                }
            }

            node.left = helper(iStart, pStart, rootIndex - iStart, iorder, porder);
            node.right = helper(rootIndex + 1, pStart + rootIndex - iStart, length - 1 - (rootIndex - iStart), iorder, porder);

            return node;
        } else {
            return null;
        }
    }
}
