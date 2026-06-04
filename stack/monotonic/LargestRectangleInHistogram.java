package stack.monotonic;

import java.util.*;

/*
Problem - Largest Rectangle in Histogram (LC-84)

Brute Approach   - For every bar, expand left and right
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Monotonic Increasing Stack + Greedy
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

public class LargestRectangleInHistogram {

    public static void main(String[] args) {

        int[] heights = {2, 1, 5, 6, 2, 3};

        // System.out.println("Brute: " + largestRectangleAreaBrute(heights));
        System.out.println("Optimal: " + largestRectangleArea(heights));
    }

    public static int largestRectangleAreaBrute(int[] heights) {

        int n = heights.length;

        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int minHeight = heights[i];

            for (int j = i; j < n; j++) {

                minHeight = Math.min(minHeight, heights[j]);

                int area = minHeight * (j - i + 1);

                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public static int largestRectangleArea(int[] heights) {

        int n = heights.length;

        int[] pse = new int[n];
        int[] nse = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Previous Smaller Element
        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {

                stack.pop();
            }

            pse[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(i);
        }

        stack.clear();

        // Next Smaller Element
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {

                stack.pop();
            }

            nse[i] = stack.isEmpty() ? n : stack.peek();

            stack.push(i);
        }

        int maxArea = 0;

        for (int i = 0; i < n; i++) {

            int width = nse[i] - pse[i] - 1;

            int area = heights[i] * width;

            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
