package hard;

import java.util.Arrays;

public class TO_REVIEWNum1335_MinimumDifficultyOfAJobSchedule {
  public int minDifficulty(int[] jobDifficulty, int D) {
    final int length = jobDifficulty.length;
    if (length < D) return -1;

    int[][] memo = new int[length][D + 1];
    for (int[] row : memo) Arrays.fill(row, -1);

    return dfs(D, 0, jobDifficulty, memo);
  }

  private int dfs(int d, int len, int[] jobDifficulty, int[][] memo) {
    final int length = jobDifficulty.length;
    if (d == 0 && len == length) {
      return 0;
    }
    if (d == 0 || len == length) {
      return Integer.MAX_VALUE;
    }
    if (memo[len][d] != -1) {
      return memo[len][d];
    }

    int curMax = jobDifficulty[len];
    int min = Integer.MAX_VALUE;
    for (int schedule = len; schedule < length; schedule++) {
      curMax = Math.max(curMax, jobDifficulty[schedule]);
      int temp = dfs(d - 1, schedule + 1, jobDifficulty, memo);
      if (temp != Integer.MAX_VALUE) {
        min = Math.min(min, temp + curMax);
      }
    }

    return memo[len][d] = min;
  }
}
