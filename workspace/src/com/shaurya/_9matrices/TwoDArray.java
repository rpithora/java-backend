package com.shaurya._9matrices;

import java.util.Arrays;

public class TwoDArray {
    public static void main(String[] args) {
        int array[][] = new int[5][5];
        int n = array.length;
        int m = array[0].length;
        int c = 10;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
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

        for (int s[] : array) {
            Arrays.stream(s).forEach(a -> System.out.print(a + " "));
            System.out.println();
        }

        System.out.println();
        System.out.println("Total Cell : " + n * m);
        System.out.println("Top Left Cell " + array[0][0]);
        System.out.println("Top Right Cell " + array[0][m - 1]);
        System.out.println("Bottom Left Cell " + array[n - 1][0]);
        System.out.println("Bottom Right Cell " + array[n - 1][m - 1]);
        System.out.println();

        printRowWise(array, n, m);
        printColumnWise(array, n, m);
        printDiagonalCell(array, n, m);
        printTopRightToBottomCell(array, n, m);
        printTranspose(array, n, m);
        printTranspose(array, n, m);

    }

    private static void printTranspose(int[][] array, int n, int m) {
        System.out.println("printTranspose");
        for(int i=0; i<n; i++){
            for(int j=i+1; j<m; j++){
                swap(array, i, j);
            }
        }

        for (int s[] : array) {
            Arrays.stream(s).forEach(a -> System.out.print(a + " "));
            System.out.println();
        }
    }

    private static void swap(int[][] array, int i, int j) {
        int temp = array[i][j];
        array[i][j] = array[j][i];
        array[j][i] = temp;
    }

    private static void printTopRightToBottomCell(int[][] array, int n, int m) {
        System.out.println("TopRightToBottomCell");
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            System.out.println(array[i][j]);
            i++;
            j--;
        }

        System.out.println("Formula i+j == n-1");
        for (i = 0; i < n; i++) {
            System.out.println(array[i][n - i - 1]);
        }
    }

    private static void printDiagonalCell(int[][] array, int n, int m) {
        System.out.println("Diagonal Element");
        for (int i = 0; i < n; i++) {
            System.out.println(array[i][i]);
        }
    }

    private static void printColumnWise(int[][] array, int n, int m) {
        System.out.println("Print Data Column wise");
        for (int j = 0; j < m; j++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                System.out.print(array[i][j] + " ");
                sum += array[i][j];
            }
            System.out.println("Column Sum : " + sum);
        }
    }

    private static void printRowWise(int[][] array, int n, int m) {
        System.out.println("Print Data Row wise");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
