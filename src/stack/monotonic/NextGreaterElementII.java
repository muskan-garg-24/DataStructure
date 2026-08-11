package stack.monotonic;

import java.util.*;

/*
Problem - Next Greater Element II (LC-503)

Brute Approach   - For every element, traverse circularly until next greater element is found
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Monotonic Decreasing Stack
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

public class NextGreaterElementII {

    public static void main(String[] args) {

        int[] nums = {1, 2, 1};

        // System.out.println(Arrays.toString(nextGreaterElementsBrute(nums)));
        System.out.println(Arrays.toString(nextGreaterElements(nums)));
    }

    public static int[] nextGreaterElementsBrute(int[] nums) {

        int n = nums.length;

        int[] answer = new int[n];

        Arrays.fill(answer, -1);

        for (int i = 0; i < n; i++) {

            for (int j = 1; j < n; j++) {

                int index = (i + j) % n;

                if (nums[index] > nums[i]) {

                    answer[i] = nums[index];
                    break;
                }
            }
        }

        return answer;
    }

    public static int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] answer = new int[n];

        Arrays.fill(answer, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 2 * n - 1; i >= 0; i--) {

            int index = i % n;

            while (!stack.isEmpty() && stack.peek() <= nums[index]) {

                stack.pop();
            }

            if (i < n && !stack.isEmpty()) {

                answer[index] = stack.peek();
            }

            stack.push(nums[index]);
        }

        return answer;
    }
}