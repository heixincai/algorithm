package leetcode;

import java.util.Arrays;

class P581_Shortest_Unsorted_Continuous_Subarray {


    public int findUnsortedSubarray(int[] nums) {
        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        int start = nums.length - 1;
        int end = 0;

        for (int i = 0; i < nums.length / 2; i++) {
            if (nums[i] != sorted[i]) {
                start = Math.min(start, i);
            }
            if (nums[nums.length - i - 1] != sorted[nums.length - i - 1]) {
                end = Math.max(end, nums.length - i - 1);
            }
        }

        return end - start + 1;
    }
}
