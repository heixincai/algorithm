package leetcode;

import java.util.HashSet;
import java.util.Set;

class P653_Two_Sum_IV___Input_is_a_BST {

    Set<Integer> sets = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        if (sets.contains(k - root.val)) {
            return true;
        }

        sets.add(root.val);

        return findTarget(root.left, k) || findTarget(root.right, k);
    }
}
