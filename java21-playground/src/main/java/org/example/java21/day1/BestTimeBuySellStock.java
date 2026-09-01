package org.example.java21.day1;

import java.util.Arrays;

public class BestTimeBuySellStock {
    static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));

        int[] buySellIndex = maxProfitIndex(prices);
        System.out.println(Arrays.toString(buySellIndex));
        System.out.println("Buy price : " + prices[buySellIndex[1]] + " Sell price : " + prices[buySellIndex[2]]);
    }

    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        return maxProfit;
    }

    public static int[] maxProfitIndex(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        int minPriceIndex = 0;
        int buyIndex = 0;
        int sellIndex = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
                minPriceIndex = i;
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
                buyIndex = minPriceIndex;
                sellIndex = i;
            }
        }
        return new int[]{maxProfit, buyIndex, sellIndex};
    }
}
