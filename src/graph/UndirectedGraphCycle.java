package graph;

import java.util.*;

public class UndirectedGraphCycle {

    public static boolean bfs(
        int start,
        ArrayList<ArrayList<Integer>> adj,
        boolean[] visited
    ) {

        Queue<int[]> queue = new LinkedList<>();

        // {node, parent}
        queue.add(new int[]{start, -1});

        visited[start] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int node = current[0];
            int parent = current[1];

            for (int neighbor : adj.get(node)) {

                if (!visited[neighbor]) {

                    visited[neighbor] = true;

                    queue.add(new int[]{
                        neighbor,
                        node
                    });

                } else if (neighbor != parent) {

                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycle(
        int V,
        int[][] edges
    ) {

        ArrayList<ArrayList<Integer>> adj =
            new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build undirected graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[V];

        // Handle disconnected graph
        for (int i = 0; i < V; i++) {

            if (!visited[i]) {

                if (bfs(i, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        int V = 5;

        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 3},
            {3, 0},
            {3, 4}
        };

        System.out.println(isCycle(V, edges));
    }
}
