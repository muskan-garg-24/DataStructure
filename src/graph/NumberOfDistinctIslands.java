package graph;

import java.util.*;

public class NumberOfDistinctIslands {

    public static int countDistinctIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        HashSet<String> set = new HashSet<>();

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        for (int row = 0; row < n; row++) {

            for (int col = 0; col < m; col++) {

                if (grid[row][col] == 'L' &&
                    !visited[row][col]) {

                    String shape = bfs(
                        grid,
                        row,
                        col,
                        visited,
                        directions
                    );

                    set.add(shape);
                }
            }
        }

        return set.size();
    }

    private static String bfs(
        char[][] grid,
        int startRow,
        int startCol,
        boolean[][] visited,
        int[][] directions
    ) {

        Queue<int[]> queue = new LinkedList<>();

        StringBuilder shape = new StringBuilder();

        // Starting cell
        queue.add(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            // Store relative position
            shape.append(row - startRow)
                 .append(",")
                 .append(col - startCol)
                 .append(";");

            // Explore four directions
            for (int[] direction : directions) {

                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 &&
                    newRow < grid.length &&
                    newCol >= 0 &&
                    newCol < grid[0].length &&
                    grid[newRow][newCol] == 'L' &&
                    !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;

                    queue.add(new int[]{
                        newRow,
                        newCol
                    });
                }
            }
        }

        return shape.toString();
    }

    public static void main(String[] args) {

        char[][] grid = {
            {'L', 'W', 'W'},
            {'W', 'W', 'L'},
            {'L', 'W', 'W'}
        };

        int result = countDistinctIslands(grid);

        System.out.println("Number of Distinct Islands: " + result);
    }
}
