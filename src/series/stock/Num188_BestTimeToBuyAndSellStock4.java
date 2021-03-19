package series.stock;

import java.util.Arrays;

public class Num188_BestTimeToBuyAndSellStock4 {

  public static int maxProfit(int k, int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }
    int[][] buyStates = new int[k + 1][prices.length];
    int[][] sellStates = new int[k + 1][prices.length];

    for (int[] buy : buyStates) {
      buy[0] = -prices[0];
    }

    for (int[] sell : sellStates) {
      sell[0] = 0;
    }
    Arrays.fill(sellStates[0], 0);

    for (int i = 1; i < prices.length; i++) {
      int price = prices[i];

      for (int index = 1; index < buyStates.length; index++) {
        buyStates[index][i] =
                Math.max(buyStates[index][i - 1], sellStates[index - 1][i - 1] - price);
        sellStates[index][i] = Math.max(sellStates[index][i - 1], buyStates[index][i - 1] + price);
      }
    }

    int maxProfit = 0;
    for (int[] sellState : sellStates) {
      maxProfit = Math.max(sellState[prices.length - 1], maxProfit);
    }

    return maxProfit;
  }
}
