package graph;

import java.util.*;

public class DFSOfGraph {

    public static void dfsHelper(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited,
        ArrayList<Integer> ans) {

        visited[node] = true;

        ans.add(node);

        for (int neighbor : adj.get(node)) {

            if (!visited[neighbor]) {
                dfsHelper(neighbor, adj, visited, ans);
            }
        }
    }

    public static ArrayList<Integer> dfs(
        ArrayList<ArrayList<Integer>> adj
    ) {

        ArrayList<Integer> ans = new ArrayList<>();

        boolean[] visited = new boolean[adj.size()];

        dfsHelper(0, adj, visited, ans);

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

        System.out.println(dfs(adj));
    }
}
