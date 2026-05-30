package queue.monotonic;

import java.util.*;

/*
Problem - Continuous Subarrays(Lc-2767)

Brute Approach   - Check every subarray and verify max - min <= 2
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Sliding Window + Two Monotonic Deques
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

public class ContinuousSubarrays {

    public static void main(String[] args) {

        int[] nums = {5, 4, 2, 4};

        // System.out.println("Brute: " + continuousSubarraysBrute(nums));
        System.out.println("Optimal: " + continuousSubarrays(nums));
    }

    public static long continuousSubarraysBrute(int[] nums) {

        int n = nums.length;

        long count = 0;

        for (int i = 0; i < n; i++) {

            int min = nums[i];
            int max = nums[i];

            for (int j = i; j < n; j++) {

                min = Math.min(min, nums[j]);
                max = Math.max(max, nums[j]);

                if (max - min <= 2) {
                    count++;
                }
            }
        }

        return count;
    }

    public static long continuousSubarrays(int[] nums) {

        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        int left = 0;

        long count = 0;

        for (int right = 0; right < nums.length; right++) {

            // Maintain decreasing deque for maximum
            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {

                maxDeque.pollLast();
            }

            // Maintain increasing deque for minimum
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {

                minDeque.pollLast();
            }

            maxDeque.offerLast(right);
            minDeque.offerLast(right);

            // Shrink invalid window
            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > 2) {

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            count += (right - left + 1);
        }

        return count;
    }
}