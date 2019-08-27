package leetcode;

class P647_Palindromic_Substrings {

    // https://leetcode.com/problems/palindromic-substrings/discuss/105689/Java-solution-8-lines-extendPalindrome

    public int count = 0;

    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extend(s, i, i);
            extend(s, i, i + 1);
        }
        return count;
    }

    public void extend(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
    }
}
