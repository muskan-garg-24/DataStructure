package stack.simulation;

import java.util.*;

/*
Problem - Removing Stars From a String (LC-2390)

 Approach - Stack
 T.C      - O(n)
 S.C      - O(n)
*/

public class RemovingStarsFromString {

    public static void main(String[] args) {

        String s = "leet**cod*e";

        System.out.println("Optimal: " + removeStars(s));
    }

    public static String removeStars(String s) {

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {

            if (ch == '*') {

                stack.pop();

            } else {

                stack.push(ch);
            }
        }

        StringBuilder answer = new StringBuilder();

        while (!stack.isEmpty()) {

            answer.append(stack.pop());
        }

        return answer.reverse().toString();
    }
}