package leetcode;

class P931_Minimum_Falling_Path_Sum {

    public int minFallingPathSum(int[][] A) {
        int[][] mem = new int[A.length][A[0].length];
        for (int i = 0; i < A[0].length; i++) {
            mem[A.length - 1][i] = A[A.length - 1][i];
        }

        for (int col = A.length - 2; col >= 0; col--) {
            for (int row = 0; row < A[0].length; row++) {
                if (row == 0) {
                    mem[col][row] = A[col][row] + Math.min(mem[col + 1][row], mem[col + 1][row + 1]);
                } else if (row == A[0].length - 1) {
                    mem[col][row] = A[col][row] + Math.min(mem[col + 1][row], mem[col + 1][row - 1]);
                } else {
                    mem[col][row] = A[col][row] + Math.min(Math.min(mem[col + 1][row - 1], mem[col + 1][row + 1]), mem[col + 1][row]);
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for (int m : mem[0]) {
            min = Math.min(min, m);
        }

        return min;
    }
}
