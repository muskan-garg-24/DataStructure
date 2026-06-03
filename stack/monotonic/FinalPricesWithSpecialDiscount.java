package stack.monotonic;

import java.util.*;

/*
Problem - Final Prices With a Special Discount in a Shop (LC-1475)

Brute Approach   - For every item, find first smaller or equal element on right
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Monotonic Increasing Stack
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

public class FinalPricesWithSpecialDiscount {

    public static void main(String[] args) {

        int[] prices = {8, 4, 6, 2, 3};

        // System.out.println(Arrays.toString(finalPricesBrute(prices)));
        System.out.println(Arrays.toString(finalPrices(prices)));
    }

    public static int[] finalPricesBrute(int[] prices) {

        int n = prices.length;

        int[] answer = Arrays.copyOf(prices, n);

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (prices[j] <= prices[i]) {

                    answer[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return answer;
    }

    public static int[] finalPrices(int[] prices) {

        int n = prices.length;

        int[] answer = Arrays.copyOf(prices, n);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {

                int index = stack.pop();

                answer[index] -= prices[i];
            }

            stack.push(i);
        }

        return answer;
    }
}