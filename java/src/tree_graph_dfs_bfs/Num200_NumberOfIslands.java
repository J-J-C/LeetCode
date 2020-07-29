package tree_graph_dfs_bfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class Num200_NumberOfIslands {


  public static void main(String[] args) {
    char[][] array = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'},
        {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
    System.out.println(numIslandsBFS(array));
  }

  public static int numIslandsBFS(char[][] grid) {
    if (grid.length == 0) {
      return 0;
    }
    int result = 0;
    int nc = grid[0].length;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          result++;
          grid[i][j] = '0';
          Queue<Integer> queue = new ArrayDeque<>();
          queue.add(i * nc + j);
          while (!queue.isEmpty()) {
            int v = queue.poll();
            int vx = v / nc;
            int vy = v % nc;
            grid[vx][vy] = '0';
            if (vy - 1 >= 0 && grid[vx][vy - 1] == '1') {
              queue.add((vx * nc + vy - 1));
              grid[vx][vy - 1] = '0';

            }
            if (vx - 1 >= 0 && grid[vx - 1][vy] == '1') {
              queue.add((vx - 1) * nc + vy);
              grid[vx - 1][vy] = '0';
            }
            if (vy + 1 < grid[0].length && grid[vx][vy + 1] == '1') {
              queue.add(vx * nc + vy + 1);
              grid[vx][vy + 1] = '0';

            }
            if (vx + 1 < grid.length && grid[vx + 1][vy] == '1') {
              queue.add((vx + 1) * nc + vy);
              grid[vx + 1][vy] = '0';

            }
          }
        }

      }
    }
    return result;
  }

  public int numIslands(char[][] grid) {
    // 11110
    // 11010
    // 11000
    // 00000
    int count = 0;
    //BFS
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          removeLand(grid, i, j);
          count++;
        }
      }
    }
    return count;
  }

  public void removeLand(char[][] grid, int i, int j) {
    if (
        i < 0 ||  // row inbound
            i > grid.length - 1 ||
            j < 0 || //col inbound
            j > grid[0].length - 1 ||
            grid[i][j] == '0'
    ) {
      return;
    }

    // let us remove this land first:
    grid[i][j] = '0';

    // let us iterate the adjacent node horizontally and vertically
    removeLand(grid, i - 1, j); // adjacent top
    removeLand(grid, i + 1, j); // adjacent bottom
    removeLand(grid, i, j - 1); // adjacent left
    removeLand(grid, i, j + 1); // adjacent right
  }
}
