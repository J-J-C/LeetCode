package dp_greedy;

public class Num122_BestTimeToBuyAndSellStock2 {
  public int maxProfit(int[] prices) {
    if (prices.length <= 1) {
      return 0;
    }

    int maxProfit = 0;
    int currentHolding = prices[0];
    int holdingProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < currentHolding) {
        currentHolding = prices[i];
        continue;
      }

      if (i == prices.length - 1) {
        if (prices[i] > currentHolding) {
          holdingProfit = prices[i] - currentHolding;
        }
        break;
      }

      if (prices[i + 1] < prices[i]) {
        maxProfit += prices[i] - currentHolding;
        currentHolding = prices[i + 1];
        holdingProfit = 0;
        i++;
      } else {
        holdingProfit = prices[i] - currentHolding;
      }
    }
    maxProfit += holdingProfit;

    return maxProfit;
  }

  public int maxProfitPeekValley(int[] prices) {
    int i = 0;
    int valley;
    int peak;
    int maxprofit = 0;
    while (i < prices.length - 1) {
      while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
        i++;
      }
      valley = prices[i];
      while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
        i++;
      }
      peak = prices[i];
      maxprofit += peak - valley;
    }
    return maxprofit;
  }

  public int maxProfitSimple(int[] prices) {
    int maxprofit = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) maxprofit += prices[i] - prices[i - 1];
    }
    return maxprofit;
  }
}
