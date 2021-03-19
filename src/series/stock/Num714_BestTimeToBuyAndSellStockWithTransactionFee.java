package series.stock;

public class Num714_BestTimeToBuyAndSellStockWithTransactionFee {

  public int maxProfit(int[] prices, int fee) {

    int[] ownState = new int[prices.length];
    int[] notOwnState = new int[prices.length];
    int[] buyState = new int[prices.length];

    ownState[0] = -prices[0];
    notOwnState[0] = 0;

    for (int i = 1; i < prices.length; i++) {
      int price = prices[i];

      ownState[i] = Math.max(notOwnState[i - 1] - price, ownState[i - 1]);
      notOwnState[i] = Math.max(notOwnState[i - 1], ownState[i - 1] + price - fee);
    }
    return Math.max(ownState[prices.length - 1], notOwnState[prices.length - 1]);
  }
}
