package leetcode;

import java.util.HashMap;
import java.util.Map;

class P993_Cousins_in_Binary_Tree {

    // 使用两个map来记录，深度相同，但是parent不一样

    Map<Integer, TreeNode> parents = new HashMap<>();
    Map<Integer, Integer> depth = new HashMap<>();

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, null);

        return parents.get(x) != parents.get(y) && depth.get(x) == depth.get(y);
    }

    public void dfs(TreeNode root, TreeNode parent) {
        if (root == null) {
            return;
        }
        parents.put(root.val, parent);
        depth.put(root.val, parent == null ? 0 : depth.get(parent.val) + 1);
        dfs(root.left, root);
        dfs(root.right, root);
    }

}
