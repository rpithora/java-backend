package com.shaurya._17striver._1buildupproblemsolving;

public class _00Patterns {
    public static void main(String[] args) {
        _00Patterns patterns = new _00Patterns();

        patterns.printPattern1();
        System.out.println();
        patterns.printPattern2();
        System.out.println();
        patterns.printPattern3();
        System.out.println();
        patterns.printPattern4();
        System.out.println();
        patterns.printPattern5(5);
        System.out.println();
        patterns.printPattern6(5);

    }

    private void printPattern6(int n) {
        /*
         *         *********
         *          *******
         *           *****
         *            ***
         *             *
         */
        for (int i = n; i >= 0; i--) {
            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private void printPattern5(int n) {
        /*
         *              *
         *             ***
         *            *****
         *           *******
         *          *********
         */

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < n - i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    private void printPattern4() {
        /*
         *      1
         *      22
         *      333
         *      4444
         *      55555
         */

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i);
            }
            System.out.println();
        }
    }

    private void printPattern3() {
        /*
         *      1
         *      12
         *      123
         *      1234
         *      12345
         */

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    private void printPattern2() {
        /*
         *      *****
         *      ****
         *      ***
         *      **
         *      *
         */

        for (int i = 5; i > 0; i--) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private void printPattern1() {
        /*
         *      *****
         *      *****
         *      *****
         *      *****
         *      *****
         */

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
