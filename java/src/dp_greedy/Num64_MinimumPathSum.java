package dp_greedy;

public class Num64_MinimumPathSum {

  public static void main(String[] args) {
    int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
    System.out.println(minPathSum(grid));
  }

  public static int minPathSum(int[][] grid) {
    int[][] memory = new int[grid.length][grid[0].length];

    int[] firstLine = grid[0];
    memory[0][0] = grid[0][0];
    for (int i = 1; i < grid[0].length; i++) {
      memory[0][i] = firstLine[i] + memory[0][i - 1];
    }

    for (int i = 1; i < grid.length; i++) {
      memory[i][0] = grid[i][0] + memory[i - 1][0];
    }

    for (int i = 1; i < grid.length; i++) {
      for (int j = 1; j < grid[0].length; j++) {
        int fromTop = grid[i][j] + memory[i - 1][j];
        int fromLeft = grid[i][j] + memory[i][j - 1];
        memory[i][j] = Math.min(fromTop, fromLeft);
      }
    }

    return memory[grid.length - 1][grid[0].length - 1];
  }

  public int minPathSum1D(int[][] grid) {
    int[] dp = new int[grid[0].length];
    for (int i = grid.length - 1; i >= 0; i--) {
      for (int j = grid[0].length - 1; j >= 0; j--) {
        if (i == grid.length - 1 && j != grid[0].length - 1) {
          dp[j] = grid[i][j] + dp[j + 1];
        } else if (j == grid[0].length - 1 && i != grid.length - 1) {
          dp[j] = grid[i][j] + dp[j];
        } else if (j != grid[0].length - 1 && i != grid.length - 1) {
          dp[j] = grid[i][j] + Math.min(dp[j], dp[j + 1]);
        } else {
          dp[j] = grid[i][j];
        }
      }
    }
    return dp[0];
  }

  public int minPathSumNoExtraSpace(int[][] grid) {
    for (int i = grid.length - 1; i >= 0; i--) {
      for (int j = grid[0].length - 1; j >= 0; j--) {
        if (i == grid.length - 1 && j != grid[0].length - 1) {
          grid[i][j] = grid[i][j] + grid[i][j + 1];
        } else if (j == grid[0].length - 1 && i != grid.length - 1) {
          grid[i][j] = grid[i][j] + grid[i + 1][j];
        } else if (j != grid[0].length - 1 && i != grid.length - 1) {
          grid[i][j] = grid[i][j] + Math.min(grid[i + 1][j], grid[i][j + 1]);
        }
      }
    }
    return grid[0][0];
  }
}
