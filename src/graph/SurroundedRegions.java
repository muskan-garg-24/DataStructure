package graph;

import java.util.*;

public class SurroundedRegions {

    public static void solve(char[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        Queue<int[]> queue = new LinkedList<>();

        // Check first and last columns
        for (int row = 0; row < rows; row++) {

            if (board[row][0] == 'O') {

                board[row][0] = '#';

                queue.add(new int[]{row, 0});
            }

            if (board[row][cols - 1] == 'O') {

                board[row][cols - 1] = '#';

                queue.add(new int[]{
                    row,
                    cols - 1
                });
            }
        }

        // Check first and last rows
        for (int col = 0; col < cols; col++) {

            if (board[0][col] == 'O') {

                board[0][col] = '#';

                queue.add(new int[]{0, col});
            }

            if (board[rows - 1][col] == 'O') {

                board[rows - 1][col] = '#';

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

        // BFS from boundary O's
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
                    board[newRow][newCol] == 'O') {

                    board[newRow][newCol] = '#';

                    queue.add(new int[]{
                        newRow,
                        newCol
                    });
                }
            }
        }

        // Convert remaining O → X
        // Convert safe # → O
        for (int row = 0; row < rows; row++) {

            for (int col = 0; col < cols; col++) {

                if (board[row][col] == 'O') {

                    board[row][col] = 'X';

                } else if (board[row][col] == '#') {

                    board[row][col] = 'O';
                }
            }
        }
    }

    public static void main(String[] args) {

        char[][] board = {
            {'X', 'X', 'X', 'X'},
            {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'},
            {'X', 'O', 'X', 'X'}
        };

        solve(board);

        for (char[] row : board) {

            for (char value : row) {
                System.out.print(value + " ");
            }

            System.out.println();
        }
    }
}
