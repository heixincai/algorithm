package leetcode;

import collection.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class P1021_Remove_Outermost_Parentheses {
    public String removeOuterParentheses(String S) {
        Deque<Character> stack = new ArrayDeque<>();
        String result = "";
        for (char c : S.toCharArray()) {
            if (c == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                    result += "()";
                    continue;
                }
            }
            stack.pop();
        }
        return result;

        //Arrays.copyOfRange()
    }
}
