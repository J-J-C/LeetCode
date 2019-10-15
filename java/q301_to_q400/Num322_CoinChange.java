package q301_to_q400;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class Num322_CoinChange {
    @Test
    public void testCoinChange1() {
        int[] test = {1, 2, 5};
        int amount = 11;
        assertEquals(3, coinChange(test, amount));
    }

    @Test
    public void testCoinChange2() {
        int[] test = {2};
        int amount = 3;
        assertEquals(-1, coinChange(test, amount));
    }

    @Test
    public void testCoinChange3() {
        int[] test = {2,5,7};
        int amount = 34;
        assertEquals(6, coinChange(test, amount));
    }




    public int coinChange(int[] coins, int amount) {
        return coinChange(coins, amount, 0);

    }


    public int coinChange(int[] coins, int amount, int total) {
        int min = Integer.MAX_VALUE;
        if(coins.length == 0) {
            return -1;
        }
        if(coins.length == 1) {
            return coins[0] == amount ? 1 : -1;
        }
        if(amount == 0) {
            return total;
        }
        for(int coin: coins) {
            if(amount - coin >= 0) {
                int tempTotal = coinChange(coins, amount - coin, total + 1);
                if(tempTotal != -1 && tempTotal < min) {
                    min = tempTotal;
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}
