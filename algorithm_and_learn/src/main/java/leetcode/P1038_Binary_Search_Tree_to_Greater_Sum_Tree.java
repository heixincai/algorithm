package leetcode;

class P1038_Binary_Search_Tree_to_Greater_Sum_Tree {

    int pre = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root != null) {
            bstToGst(root.right);
            pre = root.val = root.val + pre;
            bstToGst(root.left);
        }
        return root;
    }
}
