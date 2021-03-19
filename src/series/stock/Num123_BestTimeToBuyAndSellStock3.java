package series.stock;

public class Num123_BestTimeToBuyAndSellStock3 {

  public static int maxProfit(int[] prices) {
    int[] buy1State = new int[prices.length];
    int[] buy2State = new int[prices.length];
    int[] sold1State = new int[prices.length];
    int[] sold2State = new int[prices.length];

    buy1State[0] = -prices[0];
    buy2State[0] = -prices[0];
    sold1State[0] = 0;
    sold2State[0] = 0;

    for (int i = 1; i < prices.length; i++) {
      int price = prices[i];

      buy1State[i] = Math.max(buy1State[i - 1], -(price));
      buy2State[i] = Math.max(buy2State[i - 1], sold1State[i - 1] - (price));

      sold1State[i] = Math.max(sold1State[i - 1], buy1State[i - 1] + price);
      sold2State[i] = Math.max(sold2State[i - 1], buy2State[i - 1] + price);
    }
    return Math.max(sold1State[prices.length - 1], sold2State[prices.length - 1]);
  }
}
