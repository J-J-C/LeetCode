package medium;

public class Num200_NumberOfIslands {

    public int numIslands(char[][] grid) {
        int result = 0;

        if (grid.length == 0 || grid[0].length == 0) {
            return result;
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if (grid[i][j] == '1') {
                    result++;
                    visit(grid, i, j);
                }
            }
        }

        return result;
    }

    public void visit(char[][] grid, int x, int y) {

        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return;
        }
        if (grid[x][y] == '1') {
            grid[x][y] = '2';
            visit(grid, x + 1, y);
            visit(grid, x - 1, y);
            visit(grid, x, y + 1);
            visit(grid, x, y - 1);
        } else {
            return;
        }
    }
}
