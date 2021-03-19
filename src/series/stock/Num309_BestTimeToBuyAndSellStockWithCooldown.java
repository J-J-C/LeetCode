package series.stock;

import java.util.Arrays;

public class Num309_BestTimeToBuyAndSellStockWithCooldown {

  public static void main(String[] args) {
    //
    int[] array = {7, 1, 5, 3, 6, 4};
    System.out.println(maxProfit(array));
  }

  public static int maxProfit(int[] prices) {
    int[] soldState = new int[prices.length];
    int[] holdState = new int[prices.length];
    int[] buyState = new int[prices.length];

    soldState[0] = Integer.MIN_VALUE;
    holdState[0] = 0;
    buyState[0] = Integer.MIN_VALUE;


    for (int i = 1; i < prices.length; i++) {
      int price = prices[i];
      soldState[i] = buyState[i - 1] + price;
      buyState[i] = Math.max(buyState[i - 1], holdState[i - 1] - price);
      holdState[i] = Math.max(soldState[i - 1], holdState[i - 1]);

    }
    System.out.println(Arrays.toString(soldState));
    System.out.println(Arrays.toString(holdState));
    System.out.println(Arrays.toString(buyState));
    System.out.println("-------------------------");
    return Math.max(soldState[prices.length - 1], holdState[prices.length - 1]);

  }


  public static int maxProfitOptimal(int[] prices) {
    int sold = Integer.MIN_VALUE;
    int buy = Integer.MIN_VALUE;
    int standBy = 0;

    for (int price : prices) {
      int presold = sold;

      sold = Math.max(standBy, buy + price);
      buy = Math.max(standBy - price, buy);
      standBy = Math.max(presold, standBy);
    }

    return Math.max(sold, standBy);
  }
}
