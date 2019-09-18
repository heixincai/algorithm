package leetcode;

/**
 * Created by krosshuang on 2019/3/27.
 */
public class P1008_Construct_Binary_Search_Tree_from_Preorder_Traversal {

    static int i = 0;

    public TreeNode bstFromPreorder(int[] preorder) {
        i = 0;
        return build(preorder, Integer.MAX_VALUE);
    }

    public static TreeNode build(int[] preorder, int bound) {
        if (i == preorder.length || preorder[i] > bound) return null;
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = build(preorder, root.val);
        root.right = build(preorder, bound);
        return root;
    }
}
