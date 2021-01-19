package dp_greedy;

public class Num121_BestTimeToBuyAndSellStock1 {
  public int maxProfit(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }

    int maxProfit = 0;
    int currentSelling = prices[0];
    for (int i = 1; i < prices.length; i++) {

      maxProfit = Math.max(maxProfit, prices[i] - currentSelling);

      currentSelling = Math.min(currentSelling, prices[i]);
    }

    return maxProfit;
  }
}
