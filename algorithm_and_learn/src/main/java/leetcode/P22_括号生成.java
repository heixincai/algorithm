package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/generate-parentheses/
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 *
 * 我的思路：
 * 思路是，在当前状态下有几种选择可以做？
 * 一开始是空的，那么选择只有一个，就是添加一个左括号 (
 * 当有一个左括号的时候，可以做的选择有 2 个，就是添加左括号 (( ，或者添加一个右括号 ()
 * ....
 *
 * 因此，我们需要一些东西来记录状态，只需要一个已经放入的 put 数，和总数 total 即可
 * */
public class P22_括号生成 {

    private List<String> ret = new ArrayList();

    public List<String> generateParenthesis(int n) {
        helper(0, n, "");
        return ret;
    }

    public void helper(int put, int total, String s) {
        if (total == 0) {
            ret.add(s);
            return;
        }
        if (put < total) {
            helper(put + 1, total, s + "(");
            if (put > 0) {
                helper(put - 1, total - 1, s + ")");
            }
        } else {
            helper(put - 1, total - 1, s + ")");
        }
    }

    public static void main(String[] args) {
        new P22_括号生成().generateParenthesis(3);
    }
}
