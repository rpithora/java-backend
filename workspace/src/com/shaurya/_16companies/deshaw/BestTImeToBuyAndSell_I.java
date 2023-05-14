package com.shaurya._16companies.deshaw;

public class BestTImeToBuyAndSell_I {
    public static void main(String[] args) {
        int arr[] = {7, 1, 5, 3, 6, 4} ;

        int min = arr[0];
        int maxProfit = 0;

        for(int i=1; i<arr.length; i++){
            int cost = arr[i] - min;
            maxProfit = Math.max(maxProfit, cost);
            min = Math.min(min, arr[i]);
        }

        System.out.println("MaxProfit ::: " + maxProfit);
    }
}
