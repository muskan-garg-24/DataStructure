package stack.simulation;

import java.util.*;

/*
Problem - Basic Calculator (LC-224)

 Approach - Stack
 T.C      - O(n)
 S.C      - O(n)
*/

public class BasicCalculator {

    public static void main(String[] args) {

        String s = "(1+(4+5+2)-3)+(6+8)";

        System.out.println(calculate(s));
    }

    public static int calculate(String s) {

        Stack<Integer> stack = new Stack<>();

        int result = 0;
        int number = 0;
        int sign = 1;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            if (Character.isDigit(ch)) {

                number = number * 10 + (ch - '0');

            } else if (ch == '+') {

                result += sign * number;

                number = 0;
                sign = 1;

            } else if (ch == '-') {

                result += sign * number;

                number = 0;
                sign = -1;

            } else if (ch == '(') {

                stack.push(result);
                stack.push(sign);

                result = 0;
                sign = 1;

            } else if (ch == ')') {

                result += sign * number;

                number = 0;

                result *= stack.pop(); // sign
                result += stack.pop(); // previous result
            }
        }

        result += sign * number;

        return result;
    }
}