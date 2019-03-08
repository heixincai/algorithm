package leetcode;

/**
 * Created by krosshuang on 2019/3/8.
 */
public class P34_Find_First_and_Last_Position_of_Element_in_Sorted_Array {

    public int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int lo = 0;
        int hi = nums.length - 1;

        int firstFindIndex = -1;

        while (lo <= hi) {
            final int mid = (lo + hi) >>> 1;
            final int p = nums[mid];

            if (p > target) {
                hi = mid - 1;
            } else if (p < target) {
                lo = mid + 1;
            } else {
                firstFindIndex = mid;
                break;
            }
        }

        if (firstFindIndex == -1) {
            return new int[]{-1, -1};
        } else {
            boolean findHead = false;
            boolean findTail = false;

            int head = firstFindIndex;
            int tail = firstFindIndex;

            while (!findHead || !findTail) {
                if (head > 0 && nums[head - 1] == target) {
                    head--;
                } else {
                    findHead = true;
                }

                if (tail < nums.length - 1 && nums[tail + 1] == target) {
                    tail++;
                } else {
                    findTail = true;
                }
            }

            return new int[]{head, tail};
        }
    }
}
