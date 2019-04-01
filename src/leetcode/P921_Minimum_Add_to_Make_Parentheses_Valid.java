package leetcode;

import collection.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

class P921_Minimum_Add_to_Make_Parentheses_Valid {

    public int minAddToMakeValid(String S) {
        Deque<Character> stack = new ArrayDeque<>();

        int fuck = 0;

        for (char c : S.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(c);
                fuck--;
            } else {
                if (c == '(') {
                    stack.push(c);
                    fuck--;
                } else {
                    if (stack.peek() == '(') {
                        stack.pop();
                        fuck++;
                    } else {
                        fuck--;
                    }
                }

            }
        }
        return -fuck;
    }
}
