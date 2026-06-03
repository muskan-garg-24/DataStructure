package stack.monotonic;

import java.util.*;

/*
Problem - Daily Temperatures (LC-739)

Brute Approach   - For every day, find next warmer temperature
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Monotonic Decreasing Stack
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

public class DailyTemperatures {

    public static void main(String[] args) {

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};

        // System.out.println(Arrays.toString(dailyTemperaturesBrute(temperatures)));
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }

    public static int[] dailyTemperaturesBrute(int[] temperatures) {

        int n = temperatures.length;

        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (temperatures[j] > temperatures[i]) {

                    answer[i] = j - i;
                    break;
                }
            }
        }

        return answer;
    }

    public static int[] dailyTemperatures(int[] temperatures) {

        int n = temperatures.length;

        int[] answer = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {

                stack.pop();
            }

            if (!stack.isEmpty()) {

                answer[i] = stack.peek() - i;
            }

            stack.push(i);
        }

        return answer;
    }
}