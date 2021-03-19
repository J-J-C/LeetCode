package series.stock;

public class Num121_BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int buy = prices[0];

        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            int localProfit = prices[i] - buy;
            maxProfit = Math.max(maxProfit, localProfit);
            buy = Math.min(buy, prices[i]);
        }

        return maxProfit;
    }
}
