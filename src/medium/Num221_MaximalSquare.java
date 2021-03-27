package medium;

public class Num221_MaximalSquare {

  public int maximalSquare(char[][] matrix) {
    int[][] memory = new int[matrix.length + 1][matrix[0].length + 1];

    int max = 0;
    for (int i = 1; i <= matrix.length; i++) {
      for (int j = 1; j <= matrix[0].length; j++) {
        if (matrix[i - 1][j - 1] == '1') {
          memory[i][j] =
                  Math.min(Math.min(memory[i][j - 1], memory[i - 1][j]), memory[i - 1][j - 1]) + 1;
          max = Math.max(max, memory[i][j]);
        }
      }
    }

    return max * max;
  }
}
