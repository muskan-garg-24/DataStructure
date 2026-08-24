package graph;

public class NumberOfIslands {

    public static void dfs(char[][] grid, int row, int col) {

        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != '1') {

            return;
        }

        // Mark as visited
        grid[row][col] = '0';

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    public static int numIslands(char[][] grid) {

        int islands = 0;

        for (int row = 0; row < grid.length; row++) {

            for (int col = 0; col < grid[0].length; col++) {

                if (grid[row][col] == '1') {

                    islands++;

                    dfs(grid, row, col);
                }
            }
        }

        return islands;
    }

    public static void main(String[] args) {

        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };

        System.out.println(numIslands(grid));
    }
}
