package leetcode;

class P1089_Duplicate_Zeros {

    public static void main(String[] args) {
        new P1089_Duplicate_Zeros().duplicateZeros(new int[]{0, 0, 0, 0, 0, 0, 0});
    }

    public void duplicateZeros(int[] arr) {
        int i = 0;

        while (i < arr.length) {
            if (arr[i] == 0 && i != arr.length - 1) {
                System.arraycopy(arr, i + 1, arr, i + 2, arr.length - i - 2);
                arr[++i] = 0;

            }
            i++;
        }
    }
}
