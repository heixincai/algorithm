package leetcode;

import java.util.ArrayList;
import java.util.List;

class P448_Find_All_Numbers_Disappeared_in_an_Array {


public List<Integer> findDisappearedNumbers(int[] nums) {

    for (int i : nums) {
        int index = Math.abs(nums[i]) - 1;
        if (nums[index] > 0) {
            nums[index] = -nums[index];
        }
    }

    List<Integer> ret = new ArrayList<>();

    for (int i = 0; i < nums.length; i++) {
        if (nums[i] == 0) {
            ret.add(i + 1);
        }
    }

    return ret;
}
}
