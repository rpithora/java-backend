package com.shaurya._17striver._20misc;

public class BestTimeToBuyShareII {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5};
        int maxProfit = maxProfit(0, arr.length, arr, true);
        System.out.println("Max Profit : " + maxProfit);
    }

    private static int maxProfit(int i, int n, int[] values, boolean canBuy) {
        if(i == n)
            return 0;

        int profit = 0;
        if(canBuy){
            profit = Math.max(-values[i] + maxProfit(i+1, n, values, false),
                0 + maxProfit(i+1, n, values, true));
        }else{
            profit = Math.max(values[i] + maxProfit(i+1, n, values, true),
                    0 + maxProfit(i+1, n, values, false));
        }
        return profit;
    }
}
