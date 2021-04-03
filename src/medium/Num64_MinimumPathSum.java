package medium;

public class Num64_MinimumPathSum {
  public int minPathSum(int[][] grid) {
    int[][] memory = new int[grid.length][grid[0].length];

    memory[0][0] = grid[0][0];
    for (int row = 1; row < grid.length; row++) {
      memory[row][0] = memory[row - 1][0] + grid[row][0];
    }
    for (int column = 1; column < grid[0].length; column++) {
      memory[0][column] = memory[0][column - 1] + grid[0][column];
    }

    for (int row = 1; row < grid.length; row++) {
      for (int column = 1; column < grid[0].length; column++) {
        memory[row][column] =
                Math.min(memory[row - 1][column], memory[row][column - 1]) + grid[row][column];
      }
    }

    return memory[grid.length - 1][grid[0].length - 1];
  }
}
