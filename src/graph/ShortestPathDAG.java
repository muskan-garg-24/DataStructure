package graph;

import java.util.*;

public class ShortestPathDAG {

    public static ArrayList<Integer> shortestPath(int V, int[][] edges) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Build weighted graph
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            adj.get(u).add(new int[]{v, weight});
        }

        int[] indegree = new int[V];

        // Calculate indegree
        for (int u = 0; u < V; u++) {

            for (int[] edge : adj.get(u)) {

                int v = edge[0];

                indegree[v]++;
            }
        }

        // Topological Sort
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < V; i++) {

            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> topo = new ArrayList<>();

        while (!queue.isEmpty()) {

            int node = queue.poll();

            topo.add(node);

            for (int[] edge : adj.get(node)) {

                int neighbor = edge[0];

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // Distance
        int[] dist = new int[V];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;

        // Relaxation
        for (int node : topo) {

            if (dist[node] == Integer.MAX_VALUE) {
                continue;
            }

            for (int[] edge : adj.get(node)) {

                int neighbor = edge[0];
                int weight = edge[1];

                if (dist[node] + weight < dist[neighbor]) {

                    dist[neighbor] = dist[node] + weight;
                }
            }
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < V; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                result.add(-1);
            } else {
                result.add(dist[i]);
            }
        }

        return result;
    }

    public static void main(String[] args) {

        int V = 6;

        int[][] edges = {
            {0, 1, 2},
            {0, 4, 1},
            {1, 2, 3},
            {4, 2, 2},
            {4, 5, 4},
            {2, 3, 6},
            {5, 3, 1}
        };

        ArrayList<Integer> result = shortestPath(V, edges);

        System.out.println(result);
    }
}
