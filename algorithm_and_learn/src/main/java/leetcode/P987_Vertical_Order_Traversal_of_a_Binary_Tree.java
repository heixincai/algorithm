package leetcode;

import java.util.*;

class P987_Vertical_Order_Traversal_of_a_Binary_Tree {

    int min = 0;
    int max = 0;

    Map<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        helper(root, 0, 0);

        List<List<Integer>> result = new ArrayList();
        for (int i = min; i <= max; i++) {
            Collections.sort(map.get(i));
            List<Integer> re = new ArrayList<>();
            for (int x : map.get(i)) {
                re.add(x % 10000);
            }
            result.add(re);
        }
        return result;
    }

    public void helper(TreeNode node, int v, int d) {
        if (node != null) {
            min = Math.min(v, min);
            max = Math.max(v, max);

            if (!map.containsKey(v)) {
                map.put(v, new ArrayList());
            }

            map.get(v).add(10000 * d + node.val);

            helper(node.left, v - 1, d + 1);
            helper(node.right, v + 1, d + 1);

        }
    }
}
