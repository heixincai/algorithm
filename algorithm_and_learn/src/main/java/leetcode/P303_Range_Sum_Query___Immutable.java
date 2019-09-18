package leetcode;

class P303_Range_Sum_Query___Immutable {



    class NumArray {

        private int[] sum;

        public NumArray(int[] nums) {
            // sum存储的是前面多少个数的和，比如数组长度为5，那么0表示前0个数的和，所以是0
            // 1表示前1个数的和，以此类推
            sum = new int[nums.length + 1];

            for (int i = 0; i < nums.length; i++) {
                sum[i + 1] = sum[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j + 1] - sum[i];
        }
    }
}
