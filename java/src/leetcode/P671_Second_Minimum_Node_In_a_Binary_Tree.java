package leetcode;

import java.util.ArrayList;
import java.util.List;

class P671_Second_Minimum_Node_In_a_Binary_Tree {

    List<Integer> cache = new ArrayList<>();
    Integer rootVal = null;

    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        } else {
            rootVal = root.val;
            x(root.left);
            x(root.right);
            if (cache.size() == 2) {
                return Math.min(cache.get(0), cache.get(1));
            } else if (cache.size() == 1) {
                return cache.get(0);
            } else {
                return -1;
            }
        }
    }

    private void x(TreeNode node) {
        if (node != null) {
            if (cache.size() < 2) {
                if (node.val < rootVal) {
                    cache.add(node.val);
                    x(node.left);
                    x(node.right);
                }
            }
        }
    }
}
