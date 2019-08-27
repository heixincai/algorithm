package leetcode;

class P198_House_Robber {

    int[] mem = null;

    public int rob(int[] nums) {

        mem = new int[nums.length];
        for (int i = 0; i < mem.length; i++) {
            mem[i] = -1;
        }

        return rob(nums, nums.length - 1);
    }

    public int rob(int[] nums, int i) {
        if (i < 0) {
            return 0;
        }

        if (mem[i] >= 0) {
            return mem[i];
        }

        return mem[i] = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    }
}
