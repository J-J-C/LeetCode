package medium;

import java.util.*;

public class Num1091_ShortestPathInBinaryMatrix {

  public static void main(String[] args) {
    //
    int[][] array = {
            {0, 1, 1, 0, 0, 0},
            {0, 1, 0, 1, 1, 0},
            {0, 1, 1, 0, 1, 0},
            {0, 0, 0, 1, 1, 0},
            {1, 1, 1, 1, 1, 0},
            {1, 1, 1, 1, 1, 0}
    };

    for (int[] array2 : array) {
      System.out.println(Arrays.toString(array2));
    }
    System.out.println("------------------");
    System.out.println(shortestPathBinaryMatrixDFS(array));
  }

  private static final int[][] directions =
          new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};


  public int shortestPathBinaryMatrix1(int[][] grid) {

    // Firstly, we need to check that the start and target cells are open.
    if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) {
      return -1;
    }

    // Set up the BFS.
    Queue<int[]> queue = new ArrayDeque<>();
    queue.add(new int[]{0, 0, 1}); // Put distance on the queue
    boolean[][] visited = new boolean[grid.length][grid[0].length]; // Used as visited set.
    visited[0][0] = true;

    // Carry out the BFS
    while (!queue.isEmpty()) {
      int[] cell = queue.remove();
      int row = cell[0];
      int col = cell[1];
      int distance = cell[2];
      // Check if this is the target cell.
      if (row == grid.length - 1 && col == grid[0].length - 1) {
        return distance;
      }
      for (int[] neighbour : getNeighbours(row, col, grid)) {
        int neighbourRow = neighbour[0];
        int neighbourCol = neighbour[1];
        if (visited[neighbourRow][neighbourCol]) {
          continue;
        }
        visited[neighbourRow][neighbourCol] = true;
        queue.add(new int[]{neighbourRow, neighbourCol, distance + 1});
      }
    }

    // The target was unreachable.
    return -1;
  }

  private List<int[]> getNeighbours(int row, int col, int[][] grid) {
    List<int[]> neighbours = new ArrayList<>();
    for (int i = 0; i < directions.length; i++) {
      int newRow = row + directions[i][0];
      int newCol = col + directions[i][1];
      if (newRow < 0 || newCol < 0 || newRow >= grid.length
              || newCol >= grid[0].length
              || grid[newRow][newCol] != 0) {
        continue;
      }
      neighbours.add(new int[]{newRow, newCol});
    }
    return neighbours;
  }

//  public static int shortestPathBinaryMatrix(int[][] grid) {
//    if (grid[grid.length - 1][grid[0].length - 1] == 1) {
//      return -1;
//    }
//    for (int i = 0; i < grid.length; i++) {
//      for (int j = 0; j < grid[0].length; j++) {
//        if (grid[i][j] == 1) {
//          grid[i][j] = -1;
//        }
//      }
//    }
//
//    Queue<int[]> queue = new LinkedList<>();
//    queue.add()
//    while (!queue.isEmpty()) {
//
//    }
//
//
//
//    return grid[grid.length - 1][grid[0].length - 1] == 0
//            ? -1
//            : grid[grid.length - 1][grid[0].length - 1];
//  }


  public static int shortestPathBinaryMatrixDFS(int[][] grid) {
    if (grid[grid.length - 1][grid[0].length - 1] == 1) {
      return -1;
    }
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          grid[i][j] = -1;
        }
      }
    }
    visit(grid, 0, 0, 1);

//    for (int[] array : grid) {
//      System.out.println(Arrays.toString(array));
//    }

    return grid[grid.length - 1][grid[0].length - 1] == 0
            ? -1
            : grid[grid.length - 1][grid[0].length - 1];
  }

  public static void visit(int[][] grid, int i, int j, int value) {
//    System.out.println(i + ", " + j);
//    for (int[] array : grid) {
//      System.out.println(Arrays.toString(array));
//    }
    // out of bound
    if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length) {
      return;
    }
    // hit the wall
    if (grid[i][j] == -1) {
      return;
    }
    int old = 0;
    if (grid[i][j] == 0) {
      grid[i][j] = value;
    } else {
      old = grid[i][j];
      grid[i][j] = Math.min(value, grid[i][j]);
    }
    if (i == grid.length - 1 && j == grid[0].length - 1) {
      return;
    }
//    System.out.println(old +", " + grid[i][j]);
//    System.out.println("------------------");
    if (old > value || old == 0) {
      visit(grid, i - 1, j, grid[i][j] + 1);
      visit(grid, i - 1, j + 1, grid[i][j] + 1);
      visit(grid, i - 1, j - 1, grid[i][j] + 1);


      visit(grid, i, j + 1, grid[i][j] + 1);
      visit(grid, i, j - 1, grid[i][j] + 1);


      visit(grid, i + 1, j + 1, grid[i][j] + 1);
      visit(grid, i + 1, j, grid[i][j] + 1);
      visit(grid, i + 1, j - 1, grid[i][j] + 1);
    }
  }
}
