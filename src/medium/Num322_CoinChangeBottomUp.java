package medium;

public class Num322_CoinChangeBottomUp {

  // DP function
  // Optimal =

  public static void main(String[] args) {
  }

  public int coinChange(int[] coins, int amount) {
    if (amount == 0) {
      return 0;
    }
    int[] memory = new int[amount + 1];
    memory[0] = 0;

    return memory[amount];
  }
}
