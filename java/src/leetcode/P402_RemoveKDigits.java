package leetcode;

import java.util.Set;

/**
 * Created by krosshuang on 2018/11/8.
 */
public class P402_RemoveKDigits {

    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();

        for (char c : num.toCharArray()) {
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(c);
        }

        while (sb.length() > 0) {
            if (sb.charAt(0) == '0') {
                sb.deleteCharAt(0);
            } else {
                break;
            }
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        int[] a = new int[]{0};
        int[] b = new int[]{1};

        merge(a, 0, b, 1);
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int placeIndex = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        if (n == 0) {
            return;
        }

        while (placeIndex >= 0 && j >= 0) {
            if (i >= 0) {
                if (nums1[i] > nums2[j]) {
                    nums1[placeIndex] = nums1[i];
                    i--;
                } else {
                    nums1[placeIndex] = nums2[j];
                    j--;
                }

            } else {
                nums1[placeIndex] = nums2[j];
                j--;
            }
            placeIndex--;

        }
    }
}
