package com.shaurya._17striver;

public class BestTimeToBuyShare {
    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 3, 6, 4};
        int maxProfit = maxProfit(arr);
        System.out.println("Max Profit : " + maxProfit);
    }

    private static int maxProfit(int[] arr) {
        int min = arr[0];
        int maxProfit = 0;
        for (int i = 1; i < arr.length; i++) {
            int profit = arr[i] - min;
            maxProfit = Math.max(maxProfit, profit);
            min = Math.min(min, arr[i]);
        }
        return maxProfit;
    }
}
