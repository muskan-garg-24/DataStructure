package stack.monotonic;

import java.util.*;

/*
Problem - Next Greater Element I (LC-496)

 Approach - Monotonic Decreasing Stack + HashMap
 T.C      - O(m + n)
 S.C      - O(n)
*/

public class NextGreaterElementI {

    public static void main(String[] args) {

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();

        Stack<Integer> stack = new Stack<>();

        for (int num : nums2) {

            while (!stack.isEmpty() && stack.peek() < num) {

                map.put(stack.pop(), num);
            }

            stack.push(num);
        }

        while (!stack.isEmpty()) {

            map.put(stack.pop(), -1);
        }

        int[] answer = new int[nums1.length];

        for (int i = 0; i < nums1.length; i++) {

            answer[i] = map.get(nums1[i]);
        }

        return answer;
    }
}