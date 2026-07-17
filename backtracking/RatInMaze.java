package backtracking;

import java.util.*;

public class RatInMaze {

    public static void backtrack(int row, int col, int[][] mat, boolean[][] visited, StringBuilder path, ArrayList<String> ans) {

        int n = mat.length;

        if (row == n - 1 && col == n - 1) {
            ans.add(path.toString());
            return;
        }

        visited[row][col] = true;

        // Down
        if (isSafe(row + 1, col, mat, visited)) {
            path.append('D');
            backtrack(row + 1, col, mat, visited, path, ans);
            path.deleteCharAt(path.length() - 1);
        }

        // Left
        if (isSafe(row, col - 1, mat, visited)) {
            path.append('L');
            backtrack(row, col - 1, mat, visited, path, ans);
            path.deleteCharAt(path.length() - 1);
        }

        // Right
        if (isSafe(row, col + 1, mat, visited)) {
            path.append('R');
            backtrack(row, col + 1, mat, visited, path, ans);
            path.deleteCharAt(path.length() - 1);
        }

        // Up
        if (isSafe(row - 1, col, mat, visited)) {
            path.append('U');
            backtrack(row - 1, col, mat, visited, path, ans);
            path.deleteCharAt(path.length() - 1);
        }

        visited[row][col] = false;
    }

    public static boolean isSafe(int row, int col, int[][] mat, boolean[][] visited) {

        int n = mat.length;

        return row >= 0 && col >= 0 && row < n && col < n && mat[row][col] == 1 && !visited[row][col];
    }

    public static ArrayList<String> findPath(int[][] mat) {

        ArrayList<String> ans = new ArrayList<>();

        int n = mat.length;

        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) {
            return ans;
        }

        boolean[][] visited = new boolean[n][n];

        backtrack(0, 0, mat, visited, new StringBuilder(), ans);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] mat = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }

        ArrayList<String> ans = findPath(mat);

        System.out.println(ans);
        sc.close();
    }
}
