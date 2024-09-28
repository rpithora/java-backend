package com.shaurya._17striver._06arrays;

public class _06FindMissingNumber1ToNArray {
    public static void main(String[] args) {
        int n = 5;
        int[] arr = {1, 2, 4, 5};

        int missingNumber = findMissingNumber1(arr, n);
        System.out.printf("\nmissing number : " + missingNumber);

        missingNumber = findMissingNumber2(arr, n);
        System.out.printf("\nmissing number : " + missingNumber);

    }

    private static int findMissingNumber1(int[] arr, int n) {
        int sum1 = n * (n + 1) / 2;

        int sum2 = 0;

        for (int i : arr)
            sum2 += i;

        return sum1 - sum2;
    }

    private static int findMissingNumber2(int[] arr, int n) {
        int xor1 = 0;
        int xor2 = 0;

        for (int i = 1; i <= n; i++)
            xor1 ^= i;

        for (int i = 0; i < arr.length; i++)
            xor2 ^= arr[i];

        return xor1 ^ xor2;
    }
}
