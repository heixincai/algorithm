package leetcode;

import java.util.*;

class P429_N_ary_Tree_Level_Order_Traversal {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Deque<Node> q = new ArrayDeque<>();


        q.push(root);

        while (!q.isEmpty()) {
            int count = q.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < count; i++) {
                Node node = q.pollLast();
                level.add(node.val);
                if (node.children != null) {
                    for (Node c : node.children) {
                        q.push(c);
                    }
                }
            }

            result.add(level);
        }

        return result;
    }
}


