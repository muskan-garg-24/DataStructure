package backtracking;

import java.util.*;

public class BeautifulArrangement {

    public static int backtrack(int position, int n, boolean[] visited) {

        if (position > n) {
            return 1;
        }

        int count = 0;

        for (int num = 1; num <= n; num++) {

            if (!visited[num] &&
                (num % position == 0 || position % num == 0)) {

                visited[num] = true;

                count += backtrack(position + 1, n, visited);

                visited[num] = false;
            }
        }

        return count;
    }

    public static int countArrangement(int n) {

        boolean[] visited = new boolean[n + 1];

        return backtrack(1, n, visited);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int ans = countArrangement(n);

        System.out.println(ans);
        sc.close();
    }
}
