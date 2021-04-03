package medium;

public class Num62_UniquePaths {
  public int uniquePaths(int m, int n) {
    int[][] memory = new int[m][n];
    memory[0][0] = 1;
    for (int row = 1; row < m; row++) {
      memory[row][0] = 1;
    }

    for (int column = 1; column < n; column++) {
      memory[0][column] = 1;
    }

    for (int row = 1; row < m; row++) {
      for (int column = 1; column < n; column++) {
        memory[row][column] = (memory[row - 1][column] + memory[row][column - 1]);
      }
    }

    return memory[m - 1][n - 1];
  }
}
