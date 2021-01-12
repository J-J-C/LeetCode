package dp;

public class Num276_PaintFence {

  static int[][][][] memory;

  // either memory issue or time limit exceed, as we are not doing correct memorization
  public static int numWays(int n, int k) {
    if (n == 0) {
      return 0;
    }
    memory = new int[n + 1][k + 1][k + 1][k + 1];
    return numWays(n, k, 0, 0);
  }

  public static int numWays(int n, int k, int previous, int current) {
    if (n == 0) {
      return 1;
    }
    int total = 0;
    for (int i = 1; i <= k; i++) {
      if (!(previous == current && current == i)) {
        if (memory[n - 1][k][current][i] != 0) {
          total = total + memory[n - 1][k][current][i];
        } else {
          total = total + numWays(n - 1, k, current, i);
        }
      }
    }
    memory[n][k][previous][current] = total;
    return total;
  }

  private int[] memo;

  public int numWaysTopdown(int n, int k) {
    if (n == 0) {
      return 0;
    }
    this.memo = new int[n + 1];
    return this.totalWaysTopdown(n, k);
  }

  private int totalWaysTopdown(int posts, int k) {
    if (posts == 1) {
      return k;
    }
    if (posts == 2) {
      return k * k;
    }
    if (this.memo[posts - 1] == 0) {
      this.memo[posts - 1] = this.totalWaysTopdown(posts - 1, k);
    }
    if (this.memo[posts - 2] == 0) {
      this.memo[posts - 2] = this.totalWaysTopdown(posts - 2, k);
    }
    return (this.memo[posts - 1] + this.memo[posts - 2]) * (k - 1);
  }

  public int numWaysBottomUp(int n, int k) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return k;
    }
    int[] dp = new int[n + 1];
    // initialize special cases
    dp[1] = k;
    dp[2] = k * k;

    for (int i = 3; i <= n; i++) {
      dp[i] = (dp[i - 1] + dp[i - 2]) * (k - 1);
    }
    return dp[n];
  }
}
