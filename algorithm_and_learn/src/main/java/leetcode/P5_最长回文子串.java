package leetcode;

public class P5_最长回文子串 {

    int maxL = 0;
    int maxR = -1;

    public String longestPalindrome(String s) {

        for (int i = 0; i < s.length(); i++) {
            ex(s, i, i);
            ex(s, i, i + 1);
        }

        return s.substring(maxL, maxR + 1);
    }

    public void ex(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        if (R - L - 1 > maxR - maxL + 1) {
            maxL = L + 1;
            maxR = R - 1;
        }
    }

    public static void main(String[] args) {
        new P5_最长回文子串().longestPalindrome("a");
    }
}
