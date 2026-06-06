package stack.string_parsing;

import java.util.Stack;

/*
Problem - Goal Parser Interpretation (LC-1678)

 Approach - String Parsing
 T.C      - O(n)
 S.C      - O(n)
*/

public class GoalParserInterpretation {

    public static void main(String[] args) {

        String command = "G()(al)";

        System.out.println(interpret(command));
    }

    public static String interpret(String command) {

        Stack<Character> stack = new Stack<>();

        StringBuilder answer = new StringBuilder();

        for (char ch : command.toCharArray()) {

            if (ch == ')') {

                if (stack.peek() == '(') {

                    stack.pop();

                    answer.append("o");

                } else {

                    stack.pop(); // l
                    stack.pop(); // a
                    stack.pop(); // (

                    answer.append("al");
                }

            } else if (ch != 'G') {

                stack.push(ch);

            } else {

                answer.append("G");
            }
        }

        return answer.toString();
    }
} 