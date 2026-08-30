package graph;

import java.util.*;

public class FindEventualSafeStates {

    public static List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        ArrayList<ArrayList<Integer>> reverseGraph =
            new ArrayList<>();

        for (int i = 0; i < n; i++) {
            reverseGraph.add(new ArrayList<>());
        }

        int[] indegree = new int[n];

        // Create reverse graph
        for (int node = 0; node < n; node++) {

            for (int neighbor : graph[node]) {

                reverseGraph.get(neighbor).add(node);

                indegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        // Terminal nodes
        for (int i = 0; i < n; i++) {

            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        boolean[] safe = new boolean[n];

        while (!queue.isEmpty()) {

            int node = queue.poll();

            safe[node] = true;

            for (int neighbor : reverseGraph.get(node)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (safe[i]) {
                result.add(i);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int[][] graph = {
            {1, 2},
            {2, 3},
            {5},
            {0},
            {5},
            {},
            {}
        };

        List<Integer> result =
            eventualSafeNodes(graph);

        System.out.println(result);
    }
}
