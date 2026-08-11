package backtracking;

import java.util.*;

public class SudokuSolver {

    public static boolean backtrack(char[][] board) {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    for (char num = '1'; num <= '9'; num++) {

                        if (isSafe(board, row, col, num)) {

                            board[row][col] = num;

                            if (backtrack(board)) {
                                return true;
                            }

                            // Backtrack
                            board[row][col] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isSafe(char[][] board, int row, int col, char num) {

        for (int i = 0; i < 9; i++) {

            if (board[row][i] == num) {
                return false;
            }

            if (board[i][col] == num) {
                return false;
            }

            int newRow = 3 * (row / 3) + i / 3;
            int newCol = 3 * (col / 3) + i % 3;

            if (board[newRow][newCol] == num) {
                return false;
            }
        }

        return true;
    }

    public static void solveSudoku(char[][] board) {
        backtrack(board);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] board = new char[9][9];

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                board[i][j] = sc.next().charAt(0);
            }
        }

        solveSudoku(board);

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                System.out.print(board[i][j] + " ");
            }

            System.out.println();
            sc.close();
        }
    }
}
