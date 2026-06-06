package stack.string_parsing;

import java.util.Stack;

/*
Problem - Defanging an IP Address (LC-1108)

 Approach - String Parsing + stack Simulation
 T.C      - O(n)
 S.C      - O(n)
*/

public class DefangingAnIPAddress {

    public static void main(String[] args) {

        String address = "1.1.1.1";

        System.out.println(defangIPaddr(address));
    }

    public static String defangIPaddr(String address) {

         Stack<Character> stack = new Stack<>();

        for (char ch : address.toCharArray()) {

            if (ch == '.') {

                stack.push('[');
                stack.push('.');
                stack.push(']');

            } else {

                stack.push(ch);
            }
        }

        StringBuilder answer = new StringBuilder();

        for (char ch : stack) {
            answer.append(ch);
        }

        return answer.toString();
    }
}