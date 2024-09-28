package com.shaurya._17striver._06arrays;

/**
 * Stock Buy And Sell
 * <p>
 * <p>
 * 228
 * <p>
 * 3
 * Problem Statement: You are given an array of prices where prices[i] is the price of a given stock on an ith day.
 * <p>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock. Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 * <p>
 * Examples
 * Example 1:
 * Input:
 * prices = [7,1,5,3,6,4]
 * Output:
 * 5
 * Explanation:
 * Buy on day 2 (price = 1) and
 * sell on day 5 (price = 6), profit = 6-1 = 5.
 */
public class _12StockBuyAndSell {
    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 3, 6, 4};

        int buy = 0;
        int sell = 0;
        int maxProfit = Integer.MIN_VALUE;
        int buyVal = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < buyVal) {
                buyVal = arr[i];
                buy = i;
            } else {
                if (arr[i] - buyVal > maxProfit) {
                    sell = i;
                    maxProfit = Math.max(maxProfit, arr[i] - buyVal);
                }
            }
        }
        System.out.println("max profit : " + maxProfit);
        System.out.println("max profit can be obtain during : " + " i : " + buy + ", j : " + sell);
    }
}
