package graph;

import java.util.*;

public class PrerequisiteTasks {

    public static boolean isPossible(int n, int[][] pre) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        for (int[] pair : pre) {

            int course = pair[0];
            int prerequisite = pair[1];

            adj.get(prerequisite).add(course);

            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {

            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        int count = 0;

        while (!queue.isEmpty()) {

            int course = queue.poll();

            count++;

            for (int neighbor : adj.get(course)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return count == n;
    }

    public static void main(String[] args) {

        int n = 4;

        int[][] pre = {
            {1, 0},
            {2, 1},
            {3, 2}
        };

        System.out.println(isPossible(n, pre));
    }
}
