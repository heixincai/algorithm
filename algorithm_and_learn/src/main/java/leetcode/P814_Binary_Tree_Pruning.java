package leetcode;

class P814_Binary_Tree_Pruning {

    public TreeNode pruneTree(TreeNode root) {
        noOne(root);
        return root;
    }

    public boolean noOne(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            boolean leftNoOne = noOne(root.left);
            boolean rightNoOne = noOne(root.right);

            if (leftNoOne) {
                root.left = null;
            }
            if (rightNoOne) {
                root.right = null;
            }
            if (root.val != 1 && leftNoOne && rightNoOne) {
                return true;
            } else {
                return false;
            }
        }
    }

}
