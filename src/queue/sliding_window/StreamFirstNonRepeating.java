package queue.sliding_window;

import java.util.*;

/*
Problem - First Non-Repeating Character In A Stream

Brute Approach   - For every character, count frequency again
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Queue + Frequency Array
Optimal T.C      - O(n)
Optimal S.C      - O(1)
*/

public class StreamFirstNonRepeating {

    public static void main(String[] args) {

        String str = "aabc";

        // System.out.println("Brute: " + firstNonRepeatingBrute(str));
        System.out.println("Optimal: " + firstNonRepeating(str));
    }

    public static String firstNonRepeatingBrute(String str) {

        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            int[] freq = new int[26];

            // Count frequency till current index
            for (int j = 0; j <= i; j++) {
                freq[str.charAt(j) - 'a']++;
            }

            char ch = '#';

            // Find first non-repeating
            for (int j = 0; j <= i; j++) {

                if (freq[str.charAt(j) - 'a'] == 1) {
                    ch = str.charAt(j);
                    break;
                }
            }

            ans.append(ch);
        }

        return ans.toString();
    }

    public static String firstNonRepeating(String str) {

        StringBuilder ans = new StringBuilder();

        Queue<Character> queue = new LinkedList<>();

        int[] freq = new int[26];

        for (char ch : str.toCharArray()) {

            freq[ch - 'a']++;

            queue.offer(ch);

            // Remove repeating characters
            while (!queue.isEmpty() && freq[queue.peek() - 'a'] > 1) {
                queue.poll();
            }

            // First non-repeating character
            if (queue.isEmpty()) {
                ans.append('#');
            } else {
                ans.append(queue.peek());
            }
        }

        return ans.toString();
    }
}