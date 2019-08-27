package leetcode;

class P413_Arithmetic_Slices {
    //https://blog.csdn.net/camellhf/article/details/52824234

    public int numberOfArithmeticSlices(int[] A) {
        int added = 0;
        int count = 0;

        for (int i = 2; i < A.length; i++) {
            if (A[i - 1] - A[i] == A[i - 2] - A[i - 1]) {
                count += ++added;
            } else {
                added = 0;
            }
        }

        return count;
    }
}
