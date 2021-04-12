package medium;

public class Num486_PredictTheWinner {

  public boolean PredictTheWinner(int[] nums) {

    int n = nums.length;
    int[][] memory = new int[n][n];
    for (int i = 0; i < n; i++) {
      memory[i][i] = nums[i];
    }
    for (int len = 1; len < n; len++) {
      for (int i = 0; i < n - len; i++) {
        int j = i + len;
        memory[i][j] = Math.max(nums[i] - memory[i + 1][j], nums[j] - memory[i][j - 1]);
      }
    }
    return memory[0][n - 1] >= 0;
  }
}
