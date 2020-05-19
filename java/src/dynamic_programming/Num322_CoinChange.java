package dynamic_programming;

import java.util.Arrays;

public class Num322_CoinChange {

    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        int[] optimal = new int[amount + 1];
        Arrays.fill(optimal, Integer.MAX_VALUE);
        coinChange(coins, amount, optimal);
        return optimal[amount] == Integer.MAX_VALUE || optimal[amount] < 0 ? -1 : optimal[amount];
    }

    private static int coinChange(int[] coins, int amount, int[] optimal) {
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
                int temp = coinChange(coins, amount - c, optimal);
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
