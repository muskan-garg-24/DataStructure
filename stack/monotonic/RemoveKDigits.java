package stack.monotonic_increasing;

import java.util.*;

/*
Problem - Remove K Digits (LC-402)

 Approach - Monotonic Increasing Stack
 T.C      - O(n)
 S.C      - O(n)
*/

public class RemoveKDigits {

    public static void main(String[] args) {

        String num = "1432219";
        int k = 3;

        System.out.println(removeKdigits(num, k));
    }

    public static String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {

            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {

                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        while (k > 0) {

            stack.pop();
            k--;
        }

        StringBuilder result = new StringBuilder();

        for (char digit : stack) {
            result.append(digit);
        }

        while (result.length() > 0 && result.charAt(0) == '0') {

            result.deleteCharAt(0);
        }

        return result.length() == 0 ? "0": result.toString();
    }
} 