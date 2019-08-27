package leetcode;

import java.util.Arrays;

class P942_DI_String_Match {

    public static void main(String[] args) {
        int[] ret = new P942_DI_String_Match().diStringMatch("IDID");
        System.out.println(Arrays.toString(ret));
    }

    public int[] diStringMatch(String S) {
        int[] a = new int[S.length() + 1];

        int writeIntWhenD = S.length();
        int writeIntWhenI = 0;

        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'I') {
                a[i] = writeIntWhenI;
                writeIntWhenI++;
                if (i == S.length() - 1) {
                    a[i + 1] = a[i] + 1;
                }
            } else {
                a[i] = writeIntWhenD;
                writeIntWhenD--;
                if (i == S.length() - 1) {
                    a[i + 1] = a[i] - 1;
                }
            }
        }

        return a;

    }
}