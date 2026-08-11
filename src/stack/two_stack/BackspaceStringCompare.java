package stack.two_stack;

import java.util.*;

/*
Problem - Backspace String Compare (LC-844)

 Approach - Two Stacks
 T.C      - O(n + m)
 S.C      - O(n + m)
*/

public class BackspaceStringCompare {

    public static void main(String[] args) {

        String s = "ab#c";
        String t = "ad#c";

        System.out.println(backspaceCompare(s, t));
    }

    public static boolean backspaceCompare(String s, String t) {

        Stack<Character> stack1 = buildStack(s);
        Stack<Character> stack2 = buildStack(t);

        if (stack1.size() != stack2.size()) {
            return false;
        }

        while (!stack1.isEmpty()) {

            if (stack1.pop() != stack2.pop()) {
                return false;
            }
        }

        return true;
    }

    private static Stack<Character> buildStack(String str) {

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {

            if (ch != '#') {

                stack.push(ch);

            } else if (!stack.isEmpty()) {

                stack.pop();
            }
        }

        return stack;
    }
}