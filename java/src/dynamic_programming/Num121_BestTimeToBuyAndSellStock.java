package dynamic_programming;

public class Num121_BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minBuyIn = 0;
        int maxProfit = 0;

        minBuyIn = prices[0];


        for (int i = 1; i < prices.length; i++) {
            maxProfit = Math.max(prices[i] - minBuyIn, maxProfit);
            minBuyIn = Math.min(minBuyIn, prices[i]);
        }

        return maxProfit;
    }
}
