package tree_graph;

public class Num200_NumberOfIslands {
  // [["1","1","1","1","0"],["1","1","0","1","0"],["1","1","0","0","0"],["0","0","0","0","0"]]
  //
  // [["1","1","0","0","0"],["1","1","0","0","0"],["0","0","1","0","0"],["0","0","0","1","1"]]
  public int numIslands(char[][] grid) {
    int total = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        char c = grid[i][j];
        if (c == '1') {
          visitIsland(grid, i, j);
          total++;
        }
      }
    }

    return total;
  }

  private void visitIsland(char[][] grid, int x, int y) {

    if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == '0') {
      return;
    }

    grid[x][y] = '0';
    visitIsland(grid, x + 1, y);
    visitIsland(grid, x, y + 1);
    visitIsland(grid, x - 1, y);
    visitIsland(grid, x, y - 1);
  }
}
