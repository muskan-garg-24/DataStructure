package stack.parentheses_validation;

import java.util.*;

/*
Problem - Valid Parentheses (LC-20)

 Approach - Stack (Store Expected Closing Brackets)
 T.C      - O(n)
 S.C      - O(n)
*/

public class ValidParentheses {

    public static void main(String[] args) {

        String s = "()[]{}";

        System.out.println("Optimal: " + isValid(s));
    }

    public static boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                stack.push(')');

            } else if (ch == '{') {

                stack.push('}');

            } else if (ch == '[') {

                stack.push(']');

            } else if (stack.isEmpty() || stack.peek() != ch) {

                return false;

            } else {

                stack.pop();
            }
        }

        return stack.isEmpty();
    }
}