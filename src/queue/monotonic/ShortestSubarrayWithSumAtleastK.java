package queue.monotonic;

import java.util.*;

/*
Problem - Shortest Subarray with Sum at Least K (Lc - 862)

Brute Approach   - Check every subarray sum
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Prefix Sum + Monotonic Deque
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

public class ShortestSubarrayWithSumAtleastK {

    public static void main(String[] args) {

        int[] nums = {2, -1, 2};

        int k = 3;

        //System.out.println("Brute: " + shortestSubarrayBrute(nums, k));
        System.out.println("Optimal: " + shortestSubarray(nums, k));
    }

    public static int shortestSubarrayBrute(int[] nums, int k) {

        int n = nums.length;

        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {

            long sum = 0;

            for (int j = i; j < n; j++) {

                sum += nums[j];

                if (sum >= k) {
                    minLength = Math.min(minLength, j - i + 1);
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }

    public static int shortestSubarray(int[] nums, int k) {

        int n = nums.length;

        long[] prefixSum = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        Deque<Integer> deque = new LinkedList<>();

        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {

            // Valid subarray found
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {

                minLength = Math.min(minLength, i - deque.pollFirst());
            }

            // Maintain increasing prefix sums
            while (!deque.isEmpty() && prefixSum[deque.peekLast()] >= prefixSum[i]) {

                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return minLength == Integer.MAX_VALUE ? -1 : minLength;
    }
}