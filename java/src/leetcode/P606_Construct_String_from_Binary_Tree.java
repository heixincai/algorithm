package leetcode;

class P606_Construct_String_from_Binary_Tree {
    public String tree2str(TreeNode t) {

        if (t == null) {
            return "";
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(t.val);

            // 当left和right都为null的时候，才省略掉左边的节点
            if (t.left != null || t.right != null) {
                sb.append("(").append(tree2str(t.left)).append(")");
            }

            // 右边的节点只要为null就省略
            if (t.right != null) {
                sb.append("(").append(tree2str(t.right)).append(")");
            }

            return sb.toString();
        }
    }
}
