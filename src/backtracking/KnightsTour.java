package backtracking;

import java.util.*;

public class KnightsTour {

    static int[] rowMove = {2, 1, -1, -2, -2, -1, 1, 2};
    static int[] colMove = {1, 2, 2, 1, -1, -2, -2, -1};

    public static boolean backtrack(int row, int col, int move, int[][] board, int n) {

        if (move == n * n) {
            return true;
        }

        for (int i = 0; i < 8; i++) {

            int newRow = row + rowMove[i];
            int newCol = col + colMove[i];

            if (isSafe(newRow, newCol, board, n)) {

                board[newRow][newCol] = move;

                if (backtrack(newRow, newCol, move + 1, board, n)) {
                    return true;
                }

                // Backtrack
                board[newRow][newCol] = -1;
            }
        }

        return false;
    }

    public static boolean isSafe(int row, int col, int[][] board, int n) {

        return row >= 0 &&
               col >= 0 &&
               row < n &&
               col < n &&
               board[row][col] == -1;
    }

    public static ArrayList<ArrayList<Integer>> knightTour(int n) {

        int[][] board = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], -1);
        }

        board[0][0] = 0;

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        if (backtrack(0, 0, 1, board, n)) {

            for (int i = 0; i < n; i++) {

                ArrayList<Integer> row = new ArrayList<>();

                for (int j = 0; j < n; j++) {
                    row.add(board[i][j]);
                }

                ans.add(row);
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> ans = knightTour(n);

        if (ans.isEmpty()) {
            System.out.println("No Solution Exists");
        } else {

            for (ArrayList<Integer> row : ans) {

                for (int value : row) {
                    System.out.print(value + " ");
                }

                System.out.println();
                sc.close();
            }
        }
    }
}
