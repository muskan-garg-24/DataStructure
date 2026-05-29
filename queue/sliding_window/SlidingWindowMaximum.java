package queue.sliding_window;

import java.util.*;

/*
Problem - 239. Sliding Window Maximum

Brute Approach   - Find maximum for every window
Brute T.C        - O(n * k)
Brute S.C        - O(1)

Optimal Approach - Sliding Window + Monotonic Deque
Optimal T.C      - O(n)
Optimal S.C      - O(k)
*/

public class SlidingWindowMaximum {

    public static void main(String[] args) {

        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};

        int k = 3;

        // System.out.println(Arrays.toString(maxSlidingWindowBrute(nums, k)));
        System.out.println(Arrays.toString(maxSlidingWindow(nums, k)));
    }

    public static int[] maxSlidingWindowBrute(int[] nums, int k) {

        int n = nums.length;

        int[] ans = new int[n - k + 1];

        int index = 0;

        for (int i = 0; i <= n - k; i++) {

            int max = nums[i];

            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }

            ans[index++] = max;
        }

        return ans;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;

        int[] ans = new int[n - k + 1];

        Deque<Integer> deque = new LinkedList<>();

        int index = 0;

        for (int i = 0; i < n; i++) {

            // Remove out of window indices
            while (!deque.isEmpty()
                    && deque.peekFirst() <= i - k) {

                deque.pollFirst();
            }

            // Maintain decreasing deque
            while (!deque.isEmpty()
                    && nums[deque.peekLast()] < nums[i]) {

                deque.pollLast();
            }

            deque.offerLast(i);

            // Window formed
            if (i >= k - 1) {
                ans[index++] = nums[deque.peekFirst()];
            }
        }

        return ans;
    }
}