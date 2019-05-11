package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class P107_Binary_Tree_Level_Order_Traversal_II {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        que.offer(root);

        while (!que.isEmpty()) {
            int curSize = que.size();

            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < curSize; i++) {
                TreeNode node = que.poll();
                if (node != null) {
                    temp.add(node.val);
                    que.offer(node.left);
                    que.offer(node.right);
                }

            }

            if (!temp.isEmpty()) {
                result.add(0, temp);
            }

        }

        return result;

    }
}
