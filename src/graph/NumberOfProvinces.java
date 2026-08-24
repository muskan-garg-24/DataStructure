package graph;

public class NumberOfProvinces {

    public static void dfs( int node, int[][] isConnected, boolean[] visited) {

        visited[node] = true;

        for (int i = 0; i < isConnected.length; i++) {

            if (isConnected[node][i] == 1 && !visited[i]) {

                dfs(i, isConnected, visited);
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;

        boolean[] visited = new boolean[n];

        int provinces = 0;

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                provinces++;

                dfs(i, isConnected, visited);
            }
        }

        return provinces;
    }

    public static void main(String[] args) {

        int[][] isConnected = { {1, 1, 0}, {1, 1, 0}, {0, 0, 1}};

        System.out.println(findCircleNum(isConnected));
    }
}