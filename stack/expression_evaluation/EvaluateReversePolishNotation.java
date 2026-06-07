package stack.expression_evaluation;

import java.util.*;

/*
Problem - Evaluate Reverse Polish Notation (LC-150)

 Approach - Expression Evaluation Stack
 T.C      - O(n)
 S.C      - O(n)
*/

public class EvaluateReversePolishNotation {

    public static void main(String[] args) {

        String[] tokens = {"2", "1", "+", "3", "*"};

        System.out.println(evalRPN(tokens));
    }

    public static int evalRPN(String[] tokens) {

        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+")) {

                int b = stack.pop();
                int a = stack.pop();

                stack.push(a + b);

            } else if (token.equals("-")) {

                int b = stack.pop();
                int a = stack.pop();

                stack.push(a - b);

            } else if (token.equals("*")) {

                int b = stack.pop();
                int a = stack.pop();

                stack.push(a * b);

            } else if (token.equals("/")) {

                int b = stack.pop();
                int a = stack.pop();

                stack.push(a / b);

            } else {

                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }
}
