package com.shaurya._9matrices;

import java.util.Arrays;

public class SubArraySumMatrix {
    public static void main(String[] args) {
        int n = 3;
        int m = 3;
        int array[][] = new int[n][m];
        int c = 10;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                array[i][j] = ++c;
            }
        }
        /*
        11 12 13 14 15
        16 17 18 19 20
        21 22 23 24 25
        26 27 28 29 30
        31 32 33 34 35
        */
        for(int s[] : array){
            Arrays.stream(s).forEach(a -> System.out.print(a + " "));
            System.out.println();
        }

        int pfSum[][] = new int[n][m];

        System.out.println();
        for(int i=0; i<n; i++){
            pfSum[i][0] = array[i][0];
            for(int j=1; j<m; j++){
                pfSum[i][j] = pfSum[i][j-1] + array[i][j];
            }
        }

        for(int s[] : pfSum){
            Arrays.stream(s).forEach(a -> System.out.print(a + " "));
            System.out.println();
        }

        System.out.println();
        for(int j=0; j<m; j++){
            pfSum[0][j] = pfSum[0][j];
            for(int i=1; i<n; i++){
                pfSum[i][j] = pfSum[i-1][j] + pfSum[i][j];
            }
        }

        for(int s[] : pfSum){
            Arrays.stream(s).forEach(a -> System.out.print(a + " "));
            System.out.println();
        }

        int sum = pfSum[2][2] - pfSum[0][2] - pfSum[2][0] + pfSum[0][0];
        System.out.println("SUM :::: " + sum);
    }
}
