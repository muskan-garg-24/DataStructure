package stack.expression_evaluation;

/*
Problem - Evaluate Prefix Expression

Approach         - Stack + Expression Evaluation
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

import java.util.*;

class Solution {

    static int evaluatePrefix(String[] arr) {

        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {

            String token = arr[i];

            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/") || token.equals("^")) {

                int a = stack.pop();
                int b = stack.pop();

                int result = 0;

                switch (token) {

                    case "+":
                        result = a + b;
                        break;

                    case "-":
                        result = a - b;
                        break;

                    case "*":
                        result = a * b;
                        break;

                    case "/":
                        result = Math.floorDiv(a, b);
                        break;

                    case "^":
                        result = (int) Math.pow(a, b);
                        break;
                }

                stack.push(result);

            } else {

                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
