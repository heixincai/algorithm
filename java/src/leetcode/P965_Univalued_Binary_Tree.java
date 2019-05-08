package leetcode;

class P965_Univalued_Binary_Tree {
    public boolean isUnivalTree(TreeNode root) {
        return x(root, root.val);
    }

    public boolean x(TreeNode node, int value) {
        if (node.val == value) {
            if (node.left != null && node.right != null) {
                return x(node.left, value) && x(node.right, value);
            } else if (node.left != null) {
                return x(node.left, value);
            } else if (node.right != null) {
                return x(node.right, value);
            } else {
                return true;
            }
        } else {
            return false;
        }
    }
}
