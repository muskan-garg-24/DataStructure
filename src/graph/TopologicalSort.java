package graph;

import java.util.*;

public class TopologicalSort {

    public static ArrayList<Integer> topoSort(
        int V,
        int[][] edges
    ) {

        ArrayList<ArrayList<Integer>> adj =
            new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build directed graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        int[] indegree = new int[V];

        // Calculate indegree
        for (int u = 0; u < V; u++) {

            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        // Start with nodes having indegree 0
        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> result =
            new ArrayList<>();

        while (!queue.isEmpty()) {

            int node = queue.poll();

            result.add(node);

            for (int neighbor : adj.get(node)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int V = 6;

        int[][] edges = {
            {5, 2},
            {5, 0},
            {4, 0},
            {4, 1},
            {2, 3},
            {3, 1}
        };

        ArrayList<Integer> result =
            topoSort(V, edges);

        System.out.println(result);
    }
}
