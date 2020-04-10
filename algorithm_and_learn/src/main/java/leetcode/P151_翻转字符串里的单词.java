package leetcode;

/**
 * https://leetcode-cn.com/problems/reverse-words-in-a-string/
 *
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 *
 * 示例 1：
 *
 * 输入: "the sky is blue"
 * 输出: "blue is sky the"
 * 示例 2：
 *
 * 输入: "  hello world!  "
 * 输出: "world! hello"
 * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 示例 3：
 *
 * 输入: "a good   example"
 * 输出: "example good a"
 * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 说明：
 *
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 * 解题思路：
 * 对于 java 来说，先 split，再逆序的处理是最快的
 * */
public class P151_翻转字符串里的单词 {

    public String reverseWords(String s) {
        // 这一坨代码处理的是 "", " " 这样的情况
        if (s.trim().equals("")) {
            return "";
        }
        String[] arr = s.split(" ");
        StringBuilder ret = new StringBuilder();
        for (int i = arr.length - 1; i >= 0; i--) {
            if (!arr[i].equals("")) {
                ret.append(arr[i]).append(" ");
            }
        }
        return ret.substring(0, ret.length() - 1).toString();
    }
}
