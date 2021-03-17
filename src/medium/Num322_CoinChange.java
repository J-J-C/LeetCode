package medium;

public class Num322_CoinChange {

  // DP function
  // Optimal =

  public static void main(String[] args) {
  }

  public int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    int[] memory = new int[amount + 1];
    return coinChange(coins, amount, memory);
  }

  public int coinChange(int[] coins, int amount, int[] memory) {

    if (0 > amount) {
      return -1;
    } else if (amount == 0) {
      return 0;
    } else if ((memory[amount] != 0)) {
      return memory[amount];
    } else {
      int localMin = Integer.MAX_VALUE;
      for (int c : coins) {
        int res = coinChange(coins, amount - c, memory);
        if (res >= 0 && res < localMin) {
          localMin = 1 + res;
        }
      }
      memory[amount] = localMin == Integer.MAX_VALUE ? -1 : localMin;
      return memory[amount];
    }
  }
}
