package dynamic_programming;

import java.util.Arrays;

public class Num1155_NumberOfDiceRollsWithTargetSum {

  public static void main(String[] args) {
    System.out.println(numRollsToTarget(10, 10, 74));
    long current = System.currentTimeMillis();
    System.out.println(numRollsToTarget3(30, 30, 500));
    System.out.println(System.currentTimeMillis() - current);
    current = System.currentTimeMillis();
    System.out.println(numRollsToTarget(30, 30, 500));
    System.out.println(System.currentTimeMillis() - current);
  }

  public static int numRollsToTarget(int d, int f, int target) {

    int[][] memory = new int[d + 1][target + 1];
    for (int i = 0; i < memory.length; i++) {
      if (i == 0) {
        Arrays.fill(memory[i], 0);
      } else {
        Arrays.fill(memory[i], -1);
      }
    }
    return numRollsToTarget(d, f, target, memory);
  }


  public static int numRollsToTarget(int d, int f, int target, int[][] memory) {
    if (d == 0 || target <= 0) {
      return 0;
    }

    if (d == 1) {
      if (target <= f) {
        memory[d][target] = 1;
        return 1;
      } else {
        memory[d][target] = 0;
        return 0;
      }
    }
    int MOD = 1000000007;
    if (memory[d][target] > -1) {
      return memory[d][target];
    }

    int sum = 0;
    int i = 1;
    while (i <= f) {
      if (target - i < 0) {
        sum += 0;
      } else if (memory[d - 1][target - i] >= 0) {
        sum += memory[d - 1][target - i];
      } else {
        sum += numRollsToTarget(d - 1, f, target - i, memory);
      }
      i++;
    }
    memory[d][target] = sum % 1000000007;
    return sum;
  }

  public static int numRollsToTarget3(int d, int f, int target) {
    int MOD = (int) Math.pow(10, 9) + 7;
    long[][] dp = new long[d + 1][target + 1];
    dp[0][0] = 1;
    for (int i = 1; i <= d; i++) {
      for (int j = 0; j <= target; j++) {
        for (int k = 1; k <= f; k++) {
          if (j >= k) {
            dp[i][j] = (dp[i][j] + dp[i - 1][j - k]) % MOD;
          } else {
            break;
          }
        }
      }
    }
    return (int) dp[d][target];
  }
}
