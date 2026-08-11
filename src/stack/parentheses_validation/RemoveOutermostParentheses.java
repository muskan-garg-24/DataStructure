package stack.parentheses_validation;

import java.util.*;

/*
Problem - Remove Outermost Parentheses (LC-1021)

Approach - Stack
T.C      - O(n)
S.C      - O(n)
*/

public class RemoveOutermostParentheses {

    public static void main(String[] args) {

        String s = "(()())(())";

        System.out.println(removeOuterParentheses(s));
    }

    public static String removeOuterParentheses(String s) {

        Stack<Character> stack = new Stack<>();

        StringBuilder answer = new StringBuilder();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                if (!stack.isEmpty()) {
                    answer.append(ch);
                }

                stack.push(ch);

            } else {

                stack.pop();

                if (!stack.isEmpty()) {
                    answer.append(ch);
                }
            }
        }

        return answer.toString();
    }
}