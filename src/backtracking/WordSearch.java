package backtracking;

import java.util.*;

public class WordSearch {

    public static boolean backtrack(char[][] board, String word,int row, int col, int index) {

        if (index == word.length()) {
            return true;
        }

        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
            board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#';

        boolean found = backtrack(board, word, row + 1, col, index + 1) ||
                        backtrack(board, word, row - 1, col, index + 1) ||
                        backtrack(board, word, row, col + 1, index + 1) ||
                        backtrack(board, word, row, col - 1, index + 1);

        board[row][col] = temp;

        return found;
    }

    public static boolean exist(char[][] board, String word) {

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {

                if (backtrack(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        char[][] board = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }

        String word = sc.next();

        System.out.println(exist(board, word));
        sc.close();
    }
}
