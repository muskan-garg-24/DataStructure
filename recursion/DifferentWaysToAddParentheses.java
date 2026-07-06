package recursion;

import java.util.*;

public class DifferentWaysToAddParentheses {

    public static List<Integer> diffWaysToCompute(String expression) {

        List<Integer> result = new ArrayList<>();

        // Try every operator as the partition point
        for (int i = 0; i < expression.length(); i++) {

            char ch = expression.charAt(i);

            if (ch == '+' || ch == '-' || ch == '*') {

                // Divide into left and right parts
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                // Recursively solve both parts
                List<Integer> leftResult = diffWaysToCompute(left);
                List<Integer> rightResult = diffWaysToCompute(right);

                // Combine all possible results
                for (int a : leftResult) {
                    for (int b : rightResult) {

                        if (ch == '+')
                            result.add(a + b);
                        else if (ch == '-')
                            result.add(a - b);
                        else
                            result.add(a * b);
                    }
                }
            }
        }

        // Base Case: expression contains only a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Expression: ");
        String expression = sc.next();

        System.out.println(diffWaysToCompute(expression));

        sc.close();
    }
}