package queue.monotonic;

import java.util.*;

/*
Problem - Sum of Subarray Minimums (LC-907)

Brute Approach   - Generate all subarrays and track minimum
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Monotonic Stack (Contribution Technique)
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

public class SumOfSubarrayMinimums {

    public static void main(String[] args) {

        int[] arr = {3, 1, 2, 4};

        // System.out.println("Brute: " + sumSubarrayMinsBrute(arr));
        System.out.println("Optimal: " + sumSubarrayMins(arr));
    }

    public static int sumSubarrayMinsBrute(int[] arr) {

        long sum = 0;
        int mod = 1_000_000_007;

        for (int i = 0; i < arr.length; i++) {

            int min = Integer.MAX_VALUE;

            for (int j = i; j < arr.length; j++) {

                min = Math.min(min, arr[j]);

                sum = (sum + min) % mod;
            }
        }

        return (int) sum;
    }

    public static int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int mod = 1_000_000_007;

        int[] pse = new int[n];
        int[] nse = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Previous Smaller Element
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {

                stack.pop();
            }

            pse[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        stack.clear();

        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {

                stack.pop();
            }

            nse[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        long answer = 0;

        for (int i = 0; i < n; i++) {

            long left = i - pse[i];
            long right = nse[i] - i;

            long contribution = (long) arr[i] * left * right;

            answer = (answer + contribution) % mod;
        }

        return (int) answer;
    }
}