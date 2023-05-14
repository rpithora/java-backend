package com.shaurya._6recursion;

public class TowerOfHanoi {
    static int count = 0;
    public static void main(String[] args) {
        int n = 3;
        int s = 1, d = 3, h = 2;
        solution(s, d, h, n);
        System.out.println("Total number step : " + count);
    }

    private static void solution(int s, int d, int h, int n) {
        ++count;
        if(n == 1){
            System.out.println("moving plate number " + n + " from " + s + " to " + d);
            return;
        }

        solution(s, h, d, n-1);
        System.out.println("moving plate number " + n + " from " + s + " to " + d);
        solution(h, d, s, n-1);
    }
}
