package backtracking;

import java.util.*;

public class PathWithMaximumGold {

    public static int backtrack(int[][] grid, int row, int col) {

        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 0) {
            return 0;
        }

        int gold = grid[row][col];

        grid[row][col] = 0;

        int down = backtrack(grid, row + 1, col);
        int up = backtrack(grid, row - 1, col);
        int right = backtrack(grid, row, col + 1);
        int left = backtrack(grid, row, col - 1);

        grid[row][col] = gold;

        return gold + Math.max(Math.max(down, up), Math.max(left, right));
    }

    public static int getMaximumGold(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int maxGold = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, backtrack(grid, i, j));
                }
            }
        }

        return maxGold;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(getMaximumGold(grid));
        sc.close();
    }
}
