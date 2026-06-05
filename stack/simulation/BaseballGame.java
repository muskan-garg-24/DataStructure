package stack.simulation;

import java.util.*;

/*
Problem - Baseball Game (LC-682)

 Approach - Stack
 T.C      - O(n)
 S.C      - O(n)
*/

public class BaseballGame {

    public static void main(String[] args) {

        String[] operations = {"5", "2", "C", "D", "+"};

        System.out.println(calPoints(operations));
    }

    public static int calPoints(String[] operations) {

        Stack<Integer> stack = new Stack<>();

        for (String operation : operations) {

            if (operation.equals("C")) {

                stack.pop();

            } else if (operation.equals("D")) {

                stack.push(2 * stack.peek());

            } else if (operation.equals("+")) {

                int first = stack.pop();
                int second = stack.peek();

                stack.push(first);
                stack.push(first + second);

            } else {

                stack.push(Integer.parseInt(operation));
            }
        }

        int score = 0;

        while (!stack.isEmpty()) {
            score += stack.pop();
        }

        return score;
    }
}