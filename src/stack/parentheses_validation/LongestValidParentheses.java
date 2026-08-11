package stack.parentheses_validation;

import java.util.*;

/*
Problem - Longest Valid Parentheses (LC-32)

Approach - Stack of Indices
T.C      - O(n)
S.C      - O(n)
*/

public class LongestValidParentheses {

    public static void main(String[] args) {

        String s = ")()())";

        System.out.println(longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        stack.push(-1);

        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (ch == '(') {

                stack.push(i);

            } else {

                stack.pop();

                if (stack.isEmpty()) {

                    stack.push(i);

                } else {

                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }

        return maxLength;
    }
}
