package graph;

import java.util.*;

public class DirectedGraphCycle {

  public static boolean isCyclic(int V, int[][] edges) {

    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    // Directed edges
    for (int[] edge : edges) {

      int u = edge[0];
      int v = edge[1];

      adj.get(u).add(v);
    }

    boolean[] visited = new boolean[V];

    boolean[] pathVisited = new boolean[V];

    // Graph can be disconnected
    for (int i = 0; i < V; i++) {

      if (!visited[i]) {

        if (dfs(i, adj, visited, pathVisited)) {

          return true;
        }
      }
    }

    return false;
  }

  private static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited,
      boolean[] pathVisited) {

    visited[node] = true;

    pathVisited[node] = true;

    for (int neighbor : adj.get(node)) {

      // Neighbor not visited
      if (!visited[neighbor]) {

        if (dfs( neighbor, adj, visited, pathVisited)) {

          return true;
        }
      }

      // Neighbor exists in current DFS path
      else if (pathVisited[neighbor]) {

        return true;
      }
    }

    // Remove from current path
    pathVisited[node] = false;

    return false;
  }

  public static void main(String[] args) {

    int V = 4;

    int[][] edges = {
        { 0, 1 },
        { 1, 2 },
        { 2, 3 },
        { 3, 1 }
    };

    System.out.println(
        isCyclic(V, edges));
  }
}
