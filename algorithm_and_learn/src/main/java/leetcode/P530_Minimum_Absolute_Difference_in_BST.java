package leetcode;

class P530_Minimum_Absolute_Difference_in_BST {

    // prev要初始化了才能比较，所以一开始没有，要第一个值赋值给了prev，才能进行比较
    Integer prev = null;
    int min = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {

        if (root == null) {
            return min;
        }

        getMinimumDifference(root.left);

        if (prev != null) {
            min = Math.min(min, root.val - prev);
        }
        prev = root.val;

        getMinimumDifference(root.right);

        return min;
    }
}
