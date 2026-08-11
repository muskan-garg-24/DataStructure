package backtracking;

import java.util.*;

public class CountNumbersWithUniqueDigits {

    public static void backtrack(int position, int length, boolean[] visited, int[] count) {

        if (position == length) {
            count[0]++;
            return;
        }

        for (int digit = 0; digit <= 9; digit++) {

            if (visited[digit]) {
                continue;
            }

            if (position == 0 && length > 1 && digit == 0) {
                continue;
            }

            visited[digit] = true;

            backtrack(position + 1, length, visited, count);

            visited[digit] = false;
        }
    }

    public static int countNumbersWithUniqueDigits(int n) {

        if (n == 0) {
            return 1;
        }

        int[] count = new int[1];

        //count[0] = 1; // Count 0

        boolean[] visited = new boolean[10];

        for (int length = 1; length <= n; length++) {
            backtrack(0, length, visited, count);
        }

        return count[0];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(countNumbersWithUniqueDigits(n));
        sc.close();
    }
}
