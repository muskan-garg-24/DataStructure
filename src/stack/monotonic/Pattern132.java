package stack.monotonic;

import java.util.*;

/*
Problem - 132 Pattern (LC-456)

Brute Approach   - Check all triplets (i, j, k)
Brute T.C        - O(n^3)
Brute S.C        - O(1)

Optimal Approach - Monotonic Decreasing Stack + Reverse Traversal
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

public class Pattern132 {

    public static void main(String[] args) {

        int[] nums = {3, 1, 4, 2};

        // System.out.println("Brute: " + find132patternBrute(nums));
        System.out.println("Optimal: " + find132pattern(nums));
    }

    public static boolean find132patternBrute(int[] nums) {

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                for (int k = j + 1; k < n; k++) {

                    if (nums[i] < nums[k] && nums[k] < nums[j]) {

                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean find132pattern(int[] nums) {

        Stack<Integer> stack = new Stack<>();

        int second = Integer.MIN_VALUE;

        for (int i = nums.length - 1; i >= 0; i--) {

            if (nums[i] < second) {
                return true;
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {

                second = stack.pop();
            }

            stack.push(nums[i]);
        }

        return false;
    }
} 