package com.shaurya._13backtracking;

public class _03StringPerm {
    public static void main(String[] args) {
        String s1 = "abc";
        solution(0, s1.length(), s1.toCharArray());
    }

    private static void solution(int i, int n, char[] chars) {
        if (i == n) {
            for (char c : chars) {
                System.out.print(c + " ");
            }
            System.out.println();
            return;
        }
        for (int j = i; j < n; j++) {
            swap(i, j, chars);
            solution(i + 1, n, chars);
            swap(i, j, chars);
        }
    }

    private static void swap(int c1, int c2, char[] chars) {
        char temp = chars[c1];
        chars[c1] = chars[c2];
        chars[c2] = temp;
    }
}
