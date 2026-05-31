package queue.monotonic;

import java.util.*;

/*
Problem - Max Value of Equation (lc -1499)

Brute Approach   - Check every valid pair
Brute T.C        - O(n^2)
Brute S.C        - O(1)

Optimal Approach - Monotonic Deque
Optimal T.C      - O(n)
Optimal S.C      - O(n)
*/

public class  MaxValueEquation{

    public static void main(String[] args) {

        int[][] points = {{1, 3}, {2, 0}, {5, 10}, {6, -10} };

        int k = 1;

        // System.out.println("Brute: " + findMaxValueOfEquationBrute(points, k));
        System.out.println("Optimal: " + findMaxValueOfEquation(points, k));
    }

    public static int findMaxValueOfEquationBrute(int[][] points, int k) {

        int n = points.length;

        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {

            for (int j = i + 1; j < n; j++) {

                if (points[j][0] - points[i][0] <= k) {

                    int value =
                            points[i][1]
                                    + points[j][1]
                                    + points[j][0]
                                    - points[i][0];

                    answer = Math.max(answer, value);
                }
            }
        }

        return answer;
    }

    public static int findMaxValueOfEquation(int[][] points, int k) {

        Deque<int[]> deque = new LinkedList<>();

        int answer = Integer.MIN_VALUE;

        for (int[] point : points) {

            int x = point[0];
            int y = point[1];

            // Remove points outside range k
            while (!deque.isEmpty()
                    && x - deque.peekFirst()[0] > k) {

                deque.pollFirst();
            }

            // Best candidate at front
            if (!deque.isEmpty()) {

                answer = Math.max(answer,
                        x + y + deque.peekFirst()[1]);
            }

            int current = y - x;

            // Maintain decreasing deque on (y - x)
            while (!deque.isEmpty()
                    && deque.peekLast()[1] <= current) {

                deque.pollLast();
            }

            deque.offerLast(new int[]{x, current});
        }

        return answer;
    }
}