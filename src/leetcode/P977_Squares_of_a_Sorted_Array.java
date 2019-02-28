package leetcode;

/**
 * Created by krosshuang on 2019/2/28.
 */
public class P977_Squares_of_a_Sorted_Array {

    public int[] sortedSquares(int[] A) {

        int i = 0;
        while (i < A.length && A[i] < 0) {
            i++; // i 表示从中间开的第一个非负数
        }

        int j = i - 1; // j 表示从中间开始的第一个负数

        int[] ans = new int[A.length];

        // 循环数组元素个数那么多次
        for (int x = 0; x < A.length; x++) {
            if (i < A.length && j >= 0) {
                // 如果两个游标都在范围内，就进行比较
                if (A[i] * A[i] > A[j] * A[j]) {
                    ans[x] = A[j] * A[j];
                    j--;
                } else {
                    ans[x] = A[i] * A[i];
                    i++;
                }
            } else if (i < A.length) {
                // 否则的话就直接赋值
                ans[x] = A[i] * A[i];
                i++;
            } else if (j >= 0) {
                ans[x] = A[j] * A[j];
                j--;
            }
        }

        return ans;
    }
}
