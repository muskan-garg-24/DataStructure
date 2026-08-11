package backtracking;

import java.util.*;

public class NQueensII {

    public static int backtrack(int row, char[][] board) {

        if (row == board.length) {
            return 1;
        }

        int count = 0;

        for (int col = 0; col < board.length; col++) {

            if (isSafe(board, row, col)) {

                board[row][col] = 'Q';

                count += backtrack(row + 1, board);

                board[row][col] = '.';
            }
        }

        return count;
    }

    public static boolean isSafe(char[][] board, int row, int col) {

        for (int i = 0; i < row; i++) {

            if (board[i][col] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0;
             i--, j--) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        for (int i = row - 1, j = col + 1;
             i >= 0 && j < board.length;
             i--, j++) {

            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }

    public static int totalNQueens(int n) {

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        return backtrack(0, board);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(totalNQueens(n));
        sc.close();
    }
}
