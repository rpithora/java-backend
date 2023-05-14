package com.shaurya._16companies.mmt;

public class StringPerm {
    public static void main(String[] args) {
        String s1 = "abc" ;
        solution(0, s1.toCharArray(), s1.length());
        int n = 3, arr[] = {1, 2, 3};
        findSubsetSum(arr, 0, 0);
    }

    private static void findSubsetSum(int[] arr, int index, int sum) {
        System.out.print(sum + " ");
        for (int i = index; i < arr.length; i++) {
            sum = sum + arr[i];
            findSubsetSum(arr, i + 1, sum);
            sum = sum - arr[i];
        }
    }

    private static void solution(int i, char[] s1, int n) {
        if(i == n){
            for(char c : s1){
                System.out.print(c + " ");
            }
            System.out.println();
            return;
        }
        for(int j=i; j<n; j++){
            swap(i, j, s1);
            solution(i+1, s1, n);
            swap(i, j, s1);
        }
    }

    private static void swap(int i, int j, char[] s1) {
        char temp = s1[i];
        s1[i] = s1[j];
        s1[j] = temp;
    }
}
