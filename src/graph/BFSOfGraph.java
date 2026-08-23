package graph;

import java.util.*;

public class BFSOfGraph {

    public static ArrayList<Integer> bfs(
        ArrayList<ArrayList<Integer>> adj
    ) {

        ArrayList<Integer> ans = new ArrayList<>();

        boolean[] visited = new boolean[adj.size()];

        Queue<Integer> queue = new LinkedList<>();

        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            ans.add(node);

            for (int neighbor : adj.get(node)) {

                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.add(neighbor);
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        int V = 5;

        ArrayList<ArrayList<Integer>> adj =
            new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(0);
        adj.get(1).add(3);

        adj.get(2).add(0);
        adj.get(2).add(4);

        adj.get(3).add(1);

        adj.get(4).add(2);

        System.out.println(bfs(adj));
    }
}