package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class P18_4Sum {

    public static void main(String[] args) {
        new P18_4Sum().fourSum(new int[]{1,0,-1,0,-2,2}, 0);
    }

    // https://www.cnblogs.com/grandyang/p/4515925.html
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();

        for (int i1 = 0; i1 < nums.length - 3; i1++) {
            if (i1 > 0 && nums[i1] == nums[i1 - 1]) continue;
            for (int i2 = i1 + 1; i2 < nums.length - 2; i2++) {
                if (i2 > i1 + 1 && nums[i2] == nums[i2 - 1]) continue;
                int i3 = i2 + 1;
                int i4 = nums.length - 1;
                while (i3 < i4) {
                    int sum = nums[i1] + nums[i2] + nums[i3] + nums[i4];
                    if (sum > target) {
                        i4--;
                    } else if (sum < target) {
                        i3++;
                    } else {
                        List<Integer> oneResult = new ArrayList();
                        oneResult.add(nums[i1]);
                        oneResult.add(nums[i2]);
                        oneResult.add(nums[i3]);
                        oneResult.add(nums[i4]);
                        result.add(oneResult);
                        while (i3 < i4 && nums[i3] == nums[i3 + 1]) i3++;
                        while (i3 < i4 && nums[i4] == nums[i4 - 1]) i4--;
                        i3++;
                        i4--;
                    }
                }
            }
        }

        return result;
    }
}
