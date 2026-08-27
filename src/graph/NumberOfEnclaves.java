package graph;

import java.util.*;

public class NumberOfEnclaves {

    public static int numEnclaves(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Boundary rows
        for (int row = 0; row < rows; row++) {

            if (grid[row][0] == 1) {

                grid[row][0] = 0;
                queue.add(new int[]{row, 0});
            }

            if (grid[row][cols - 1] == 1) {

                grid[row][cols - 1] = 0;
                queue.add(new int[]{
                    row,
                    cols - 1
                });
            }
        }

        // Boundary columns
        for (int col = 0; col < cols; col++) {

            if (grid[0][col] == 1) {

                grid[0][col] = 0;
                queue.add(new int[]{0, col});
            }

            if (grid[rows - 1][col] == 1) {

                grid[rows - 1][col] = 0;
                queue.add(new int[]{
                    rows - 1,
                    col
                });
            }
        }

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!queue.isEmpty()) {

            int[] current = queue.poll();

            int row = current[0];
            int col = current[1];

            for (int[] direction : directions) {

                int newRow = row + direction[0];
                int newCol = col + direction[1];

                if (newRow >= 0 &&
                    newRow < rows &&
                    newCol >= 0 &&
                    newCol < cols &&
                    grid[newRow][newCol] == 1) {

                    grid[newRow][newCol] = 0;

                    queue.add(new int[]{
                        newRow,
                        newCol
                    });
                }
            }
        }

        int count = 0;

        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (grid[row][col] == 1) {
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        int[][] grid = {
            {0, 0, 0, 0},
            {1, 0, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };

        System.out.println(numEnclaves(grid));
    }
}