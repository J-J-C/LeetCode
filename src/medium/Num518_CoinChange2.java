package medium;

public class Num518_CoinChange2 {
  public int change(int amount, int[] coins) {
    int[] memory = new int[amount + 1];

    memory[0] = 1;

    for (int coin : coins) {
      for (int i = coin; i < amount + 1; i++) {
        memory[i] += memory[i - coin];
      }
    }
    return memory[amount];
  }
}
