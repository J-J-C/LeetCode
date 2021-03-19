package series.stock;

public class Num122_BestTimeToBuyAndSellStock2 {

  public static void main(String[] args) {
    //
    int[] array = {7, 1, 5, 3, 6, 4};
    System.out.println(maxProfit(array));
  }

  public static int maxProfit(int[] prices) {
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1] && prices[i] > prices[i - 1]) {
        maxProfit += prices[i] - prices[i - 1];
      }
    }
    return maxProfit;
  }

  public int maxProfitOriginal(int[] prices) {
    int[] memory = new int[prices.length];
    int maxProfit = 0;

    for (int i = 1; i < prices.length; i++) {
      if (prices[i] < prices[i - 1]) {
        memory[i] = memory[i - 1];
      } else {
        if (prices[i] > prices[i - 1]) {
          memory[i] = memory[i - 1] + prices[i] - prices[i - 1];
        } else {
          memory[i] = memory[i - 1];
        }
      }
      maxProfit = Math.max(maxProfit, memory[i]);
    }
    return maxProfit;
  }
}
