package stack.string_parsing;

import java.util.*;

/*
Problem - Basic Calculator II (LC-227)

 Approach - Stack + String Parsing
 T.C      - O(n)
 S.C      - O(n)
*/

public class BasicCalculatorII {

    public static void main(String[] args) {

        String s = "3+2*2";

        System.out.println(calculate(s));
    }

    public static int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int number = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {

                number = number * 10 + (ch - '0');
            }

            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {

                if (operator == '+') {

                    stack.push(number);

                } else if (operator == '-') {

                    stack.push(-number);

                } else if (operator == '*') {

                    stack.push(stack.pop() * number);

                } else if (operator == '/') {

                    stack.push(stack.pop() / number);
                }

                operator = ch;
                number = 0;
            }
        }

        int answer = 0;

        while (!stack.isEmpty()) {

            answer += stack.pop();
        }

        return answer;
    }
}