package queue.sliding_window;

import java.util.*;

/*
Problem - First Negative Integer in Every Window (GFG)
Difficulty - Medium

Brute Approach   - Traverse every window and find first negative element
Brute T.C        - O(n * k)
Brute S.C        - O(1)

Optimal Approach - Sliding Window + Queue
Optimal T.C      - O(n)
Optimal S.C      - O(k)
*/

public class FirstNegativeIntegerInEveryWindow {

    public static void main(String[] args) {

        int[] nums = {12, -1, -7, 8, -15, 30, 16, 28};

        int k = 3;

        // System.out.println(firstNegIntBrute(nums, k));
        System.out.println(firstNegInt(nums, k));
    }

    public static List<Integer> firstNegIntBrute(int nums[], int k) {

        List<Integer> ans = new ArrayList<>();

        int n = nums.length;

        for (int i = 0; i <= n - k; i++) {

            int firstNegative = 0;

            for (int j = i; j < i + k; j++) {

                if (nums[j] < 0) {
                    firstNegative = nums[j];
                    break;
                }
            }

            ans.add(firstNegative);
        }

        return ans;
    }

    public static List<Integer> firstNegInt(int nums[], int k) {

        List<Integer> ans = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();

        int n = nums.length;

        for (int i = 0; i < n; i++) {

            if (nums[i] < 0) {
                queue.offer(i);
            }

            while (!queue.isEmpty() && queue.peek() <= i - k) {
                queue.poll();
            }

            if (i >= k - 1) {

                if (queue.isEmpty()) {
                    ans.add(0);
                } else {
                    ans.add(nums[queue.peek()]);
                }
            }
        }

        return ans;
    }
}