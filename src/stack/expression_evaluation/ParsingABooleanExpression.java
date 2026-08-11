package stack.expression_evaluation;

import java.util.*;

/*
Problem - Parsing A Boolean Expression (LC-1106)

 Approach - Expression Evaluation + String Parsing
 T.C      - O(n)
 S.C      - O(n)
*/

public class ParsingABooleanExpression {

    public static void main(String[] args) {

        String expression = "&(|(f))";

        System.out.println(parseBoolExpr(expression));
    }

    public static boolean parseBoolExpr(String expression) {

        Stack<Character> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {

            if (ch == ',') {
                continue;
            }

            if (ch != ')') {

                stack.push(ch);

            } else {

                int trueCount = 0;
                int falseCount = 0;

                while (stack.peek() != '(') {

                    char value = stack.pop();

                    if (value == 't') {
                        trueCount++;
                    } else if (value == 'f') {
                        falseCount++;
                    }
                }

                stack.pop(); // remove '('

                char operator = stack.pop();

                if (operator == '!') {

                    stack.push(falseCount == 1 ? 't' : 'f');

                } else if (operator == '&') {

                    stack.push(falseCount == 0 ? 't' : 'f');

                } else if (operator == '|') {

                    stack.push(trueCount > 0 ? 't' : 'f');
                }
            }
        }

        return stack.pop() == 't';
    }
}