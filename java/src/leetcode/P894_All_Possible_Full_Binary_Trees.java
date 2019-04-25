package leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class P894_All_Possible_Full_Binary_Trees {

    Map<Integer, List<TreeNode>> mem = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {

        if (!mem.containsKey(N)) {
            LinkedList<TreeNode> ans = new LinkedList<>();
            if (N == 1) {
                TreeNode root = new TreeNode(0);
                ans.add(root);
            } else if (N % 2 == 1) { // 必须是奇数个节点才能形成完全二叉树
                for (int x = 0; x < N; x++) {
                    int y = N - 1 - x;
                    for (TreeNode left: allPossibleFBT(x)) {
                        for (TreeNode right: allPossibleFBT(y)) {
                            TreeNode root = new TreeNode(0);
                            root.left = left;
                            root.right = right;
                            ans.add(root);
                        }
                    }
                }
            }
            mem.put(N, ans);
        }

        return mem.get(N);

    }

}