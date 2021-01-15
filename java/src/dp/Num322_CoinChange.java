package dp;

import java.util.Arrays;

public class Num322_CoinChange {

  static int[] memory;

  public static void main(String[] args) {
    int[] array = {186, 419, 83, 408};
    int amount = 6249;
    System.out.println(coinChange(array, amount));
    System.out.println(coinChange2(array, amount));
  }

  public static int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    memory = new int[amount + 1];
    Arrays.fill(memory, -1);
    memory[0] = 0;
    int optimal = coinChangeHelper(coins, amount);
    return optimal == Integer.MAX_VALUE || optimal < 0 ? -1 : optimal;
  }

  private static int coinChangeHelper(int[] coins, int amount) {
    int optimal = Integer.MAX_VALUE;
    if (amount < 0) {
      return Integer.MAX_VALUE;
    }

    if (memory[amount] != -1) {
      return memory[amount];
    }
    for (int i = 0; i < coins.length; i++) {
      int currentOptimal = Integer.MAX_VALUE;
      if (amount - coins[i] == 0) {
        currentOptimal = memory[amount - coins[i]] + 1;
      } else if (amount - coins[i] > 0) {
        currentOptimal = coinChangeHelper(coins, amount - coins[i]) + 1;
      }
      if (currentOptimal > -1) {
        optimal = Math.min(currentOptimal, optimal);
      }
    }
    memory[amount] = optimal;
    return optimal;
  }

  //  ------------------------------------------------------------

  public static int coinChange2(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    int[] optimal = new int[amount + 1];
    Arrays.fill(optimal, Integer.MAX_VALUE);
    coinChange2(coins, amount, optimal);
    return optimal[amount] == Integer.MAX_VALUE || optimal[amount] < 0 ? -1 : optimal[amount];
  }

  private static int coinChange2(int[] coins, int amount, int[] optimal) {
    if (amount == 0) {
      return 0;
    }
    if (optimal[amount] != Integer.MAX_VALUE) {
      return optimal[amount] > 0 ? optimal[amount] : Integer.MAX_VALUE;
    }
    int min = Integer.MAX_VALUE;
    for (int c : coins) {
      if (c == amount) {
        optimal[amount] = 1;
        return 1;
      } else if (c < amount) {
        int temp = coinChange2(coins, amount - c, optimal);
        if (temp > -1) {
          min = Math.min(min, temp);
        }
      } else {

      }
    }
    min += 1;
    optimal[amount] = min;
    return min;
  }
}
