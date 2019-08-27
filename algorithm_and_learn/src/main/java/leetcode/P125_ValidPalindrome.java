package leetcode;

/**
 * Created by krosshuang on 2018/11/3.
 */
public class P125_ValidPalindrome {

    public static void main(String[] args) {
        System.out.print(new P125_ValidPalindrome().isPalindrome("A man a plan a canal: Panama"));
    }

    public boolean isPalindrome(String s) {

        s = s.toLowerCase();

        if (s == null || s.equals("")) {
            return false;
        }

        int i = 0;
        int j = s.length() - 1;

        while (true) {
            if (i > j) {
                break;
            }
            while (!isAlpha(s.charAt(i))) {
                i++;
            }
            i++;
            while (!isAlpha(s.charAt(j))) {
                j--;
            }
            j--;

            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }

        return true;
    }

    public boolean isAlpha(char a) {
        return (a >= 'a' && a <= 'z') || (a >= 'A' && a <= 'Z');
    }
}
