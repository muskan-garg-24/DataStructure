package backtracking;

import java.util.*;

public class AllGridPathsFromTopToBottomCorner {

    public static void backtrack(int row, int col, int rows, int cols, StringBuilder path, List<String> ans) {

        if (row == rows - 1 && col == cols - 1) {
            ans.add(path.toString());
            return;
        }

        // Down
        if (row + 1 < rows) {
            path.append('D');
            backtrack(row + 1, col, rows, cols, path, ans);
            path.deleteCharAt(path.length() - 1);
        }

        // Right
        if (col + 1 < cols) {
            path.append('R');
            backtrack(row, col + 1, rows, cols, path, ans);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static List<String> findAllPaths(int rows, int cols) {

        List<String> ans = new ArrayList<>();

        backtrack(0, 0, rows, cols, new StringBuilder(), ans);

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        List<String> ans = findAllPaths(rows, cols);

        System.out.println(ans);
        sc.close();
    }
}
