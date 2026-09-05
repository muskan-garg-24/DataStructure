package graph;

import java.util.*;

public class ShortestPathInUnweightedGraph {

    public static int shortestPath(int V, int[][] edges, int src, int dest) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

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
        Queue<Integer> queue = new LinkedList<>();

        queue.add(src);
        visited[src] = true;

        int distance = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int node = queue.poll();

                if (node == dest) {
                    return distance;
                }

                for (int neighbor : adj.get(node)) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }

            distance++;
        }

        return -1;
    }

    public static void main(String[] args) {

        int V = 6;

        int[][] edges = {
            {0, 1},
            {0, 2},
            {1, 3},
            {2, 3},
            {3, 4},
            {4, 5}
        };

        int src = 0;
        int dest = 5;

        System.out.println(shortestPath(V, edges, src, dest));
    }
}
