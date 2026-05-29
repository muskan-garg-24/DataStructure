package queue.sliding_window;

import java.util.*;

/*
Problem - 1438. Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
Difficulty : medium

Brute Approach   - Check every subarray and find max/min
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Sliding Window + Monotonic Queues
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanOrEqualToLimit {

    public static void main(String[] args) {

        int[] nums = {8, 2, 4, 7};

        int limit = 4;

        // System.out.println("Brute: " + longestSubarrayBrute(nums, limit));
        System.out.println("Optimal: " + longestSubarray(nums, limit));
    }

    public static int longestSubarrayBrute(int[] nums, int limit) {

        int n = nums.length;

        int maxLength = 0;

        for (int i = 0; i < n; i++) {

            int max = nums[i];
            int min = nums[i];

            for (int j = i; j < n; j++) {

                max = Math.max(max, nums[j]);
                min = Math.min(min, nums[j]);

                if (max - min <= limit) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }

        return maxLength;
    }

    public static int longestSubarray(int[] nums, int limit) {

        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int left = 0;

        int maxLength = 0;

        for (int right = 0; right < nums.length; right++) {

            // Maintain decreasing deque for maximum
            while (!maxDeque.isEmpty() &&
                    nums[maxDeque.peekLast()] < nums[right]) {

                maxDeque.pollLast();
            }

            // Maintain increasing deque for minimum
            while (!minDeque.isEmpty() &&
                    nums[minDeque.peekLast()] > nums[right]) {

                minDeque.pollLast();
            }

            maxDeque.offerLast(right);
            minDeque.offerLast(right);

            // Shrink window
            while (nums[maxDeque.peekFirst()] -
                    nums[minDeque.peekFirst()] > limit) {

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}