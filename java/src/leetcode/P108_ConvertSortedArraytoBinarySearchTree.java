package leetcode;

/**
 * Created by krosshuang on 2018/11/18.
 */
public class P108_ConvertSortedArraytoBinarySearchTree {

    public static void main(String[] args) {
        new P108_ConvertSortedArraytoBinarySearchTree().sortedArrayToBST(new int[]{-10,-3,0,5,9});
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    public TreeNode build(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        } else if (start > end) {
            return null;
        } else {
            int index = (end - start) / 2 + start;
            TreeNode t = new TreeNode(nums[index]);
            t.left = build(nums, start, index - 1);
            t.right = build(nums, index + 1, end);
            return t;
        }
    }
}
