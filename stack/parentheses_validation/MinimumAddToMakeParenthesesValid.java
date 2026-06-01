package stack.parentheses_validation;

import java.util.*;

/*
Problem - Minimum Add to Make Parentheses Valid (LC-921)

 Approach   - Use Stack to match valid parentheses
 T.C        - O(n)
 S.C        - O(n)

*/

public class MinimumAddToMakeParenthesesValid {

    public static void main(String[] args) {

        String s = "()))((";

        System.out.println(minAddToMakeValid(s));
    }

    public static int minAddToMakeValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                stack.push(ch);

            } else {

                if (!stack.isEmpty() && stack.peek() == '(') {

                    stack.pop();

                } else {

                    stack.push(ch);
                }
            }
        }

        return stack.size();
    }
}