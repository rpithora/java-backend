package com.shaurya._13backtracking;

import java.util.Arrays;

public class _01Print2DigitPermutation {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5} ;
        int n = 5;
        Arrays.stream(arr).forEach(System.out::println);
        System.out.println();
        solution(0, n, new int[n]);
        System.out.println(" ::::::::::::::::: ");
        char options[] = {'a', 'b', 'c'};
        solution1(0, 3, new char[3], options);
    }

    private static void solution(int i, int n, int[] temp) {
        if(i == n){
            Arrays.stream(temp).forEach(s -> System.out.print(s + " "));
            System.out.println();
            return;
        }

        for(int j=1; j<=n; j++){
            temp[i] = j;
            solution(i+1, n, temp);
        }
    }

    private static void solution1(int i, int n, char[] temp, char[] options) {
        if(i == n){
            //Arrays.stream(temp).forEach(s -> System.out.print(s + " "));
            for(char c : temp){
                System.out.print(c + "");
            }
            System.out.println();
            return;
        }

        for(int j=0; j<options.length; j++){
            temp[i] = options[j];
            solution1(i+1, n, temp, options);
        }
    }
}
