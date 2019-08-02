package q101_to_q200;

public class Num121_BestTimeBuyStock {


    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int low = prices[0];
        int high = prices[0];
        int max = high - low;
        for (int i = 1; i < prices.length; i++) {
            int price = prices[i];
            if (price < low) {
                low = price;
                high = price;
            }
            if (price > high) {
                high = price;
                max = Math.max(max, high - low);
            }
        }
        return max;
    }
}
