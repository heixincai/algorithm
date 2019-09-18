package leetcode;

class P1022_Sum_of_Root_To_Leaf_Binary_Numbers {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public static int dfs(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }
        val = val * 2 + node.val;
        return node.left == node.right ? val : dfs(node.left, val) + dfs(node.right, val);
    }

}
