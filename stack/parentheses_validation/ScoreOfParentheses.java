package stack.parentheses_validation;

import java.util.*;

/*
Problem - Score of Parentheses (LC-856)

Approach   - Use Stack to evaluate every primitive pair
T.C        - O(n)
S.C        - O(n)

*/

public class ScoreOfParentheses {

    public static void main(String[] args) {

        String s = "(()(()))";

        System.out.println(scoreOfParentheses(s));
    }

    public static int scoreOfParentheses(String s) {

        Stack<Integer> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '(') {

                stack.push(0);

            } else {

                int score = 0;

                while (stack.peek() != 0) {
                    score += stack.pop();
                }

                stack.pop();

                stack.push(Math.max(2 * score, 1));
            }
        }

        int answer = 0;

        while (!stack.isEmpty()) {
            answer += stack.pop();
        }

        return answer;
    }
}