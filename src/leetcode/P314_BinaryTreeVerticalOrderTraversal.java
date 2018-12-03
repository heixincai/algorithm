package leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by krosshuang on 2018/11/18.
 */
public class P314_BinaryTreeVerticalOrderTraversal {

    public static class Pair {
        public int level = 0;
        public TreeNode treeNode;

        public Pair(int l, TreeNode tn) {
            level = l;
            treeNode = tn;
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        
        List<List<Integer>> positive = new ArrayList<>();
        List<List<Integer>> negative = new ArrayList<>();

        if (root == null) {
            return positive;
        }

        Queue<Pair> queue = new ArrayDeque<>();

        queue.add(new Pair(0, root));

        while (!queue.isEmpty()) {
            int size = queue.size();

            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();

                if (pair.level >= 0) {
                    if (positive.size() <= pair.level) {
                        positive.add(new ArrayList<>());
                    }
                    positive.get(pair.level).add(pair.treeNode.val);
                } else {
                    int index = Math.abs(pair.level) - 1;
                    if (negative.size() <= index) {
                        negative.add(new ArrayList<>());
                    }
                    negative.get(index).add(pair.treeNode.val);
                }

                temp.add(pair.treeNode.val);
                if (pair.treeNode.left != null) {
                    queue.add(new Pair(pair.level - 1, pair.treeNode.left));
                }
                if (pair.treeNode.right != null) {
                    queue.add(new Pair(pair.level + 1, pair.treeNode.right));
                }
            }
        }

        for (List<Integer> list : negative) {
            positive.add(0, list);
        }

        return positive;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    
    
}
