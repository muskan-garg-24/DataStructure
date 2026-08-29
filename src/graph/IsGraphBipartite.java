package graph;

import java.util.*;

public class IsGraphBipartite {

    public static boolean isBipartite(int[][] graph) {

        int n = graph.length;

        int[] color = new int[n];

        Arrays.fill(color, -1);

        // Graph may be disconnected
        for (int i = 0; i < n; i++) {

            if (color[i] == -1) {

                if (!bfs(i, graph, color)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean bfs( int start, int[][] graph, int[] color) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);

        // Give starting node color 0
        color[start] = 0;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            for (int neighbor : graph[node]) {

                // If neighbor is not colored
                if (color[neighbor] == -1) {

                    // Give opposite color
                    color[neighbor] = 1 - color[node];

                    queue.add(neighbor);
                }

                // If both have same color
                else if (color[neighbor] == color[node]) {

                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        int[][] graph = { {1, 3}, {0, 2}, {1, 3}, {0, 2}};

        System.out.println(isBipartite(graph));
    }
}