package graph;

import java.util.*;

public class ZeroOneMatrix {

    public static int[][] updateMatrix(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Put all 0s into the queue
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
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
                    mat[newRow][newCol] == -1) {

                    mat[newRow][newCol] =
                        mat[row][col] + 1;

                    queue.add(new int[]{newRow, newCol});
                }
            }
        }

        return mat;
    }

    public static void main(String[] args) {

        int[][] mat = {
            {0, 0, 0},
            {0, 1, 0},
            {1, 1, 1}
        };

        int[][] result = updateMatrix(mat);

        for (int[] row : result) {

            for (int value : row) {
                System.out.print(value + " ");
            }

            System.out.println();
        }
    }
}