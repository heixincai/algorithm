package leetcode;

import sun.reflect.generics.tree.Tree;

/**
 * Created by krosshuang on 2019/3/27.
 */
public class P701_Insert_into_a_Binary_Search_Tree {

    public TreeNode insertIntoBST(TreeNode root, int val) {
        insert(root, val);
        return root;
    }

    public static void insert(TreeNode node, int val) {
        if (node != null) {
            if (val > node.val) {
                if (node.right == null) {
                    node.right = new TreeNode(val);
                } else {
                    insert(node.right, val);
                }
            } else if (val < node.val) {
                if (node.left == null) {
                    node.left = new TreeNode(val);
                } else {
                    insert(node.left, val);
                }
            }
        }
    }
}
