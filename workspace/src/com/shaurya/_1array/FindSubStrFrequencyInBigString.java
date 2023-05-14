package com.shaurya._1array;

public class FindSubStrFrequencyInBigString {
    public static void main(String[] args) {
        String s1 = "ageeksforgeeks";
        String pattern = "geeks";
        System.out.println(s1.indexOf(pattern, 6));
        System.out.println(solution(s1, pattern));
    }

    private static int solution(String s1, String pattern) {
        if (s1 == null || pattern == null) {
            throw new IllegalArgumentException("Wrong Input");
        }
        if (s1.isEmpty() || pattern.isEmpty()) {
            return 0;
        }
        int position = 0;
        int cnt = 0;
        int n = pattern.length();

        while ((position = s1.indexOf(pattern, position)) != -1) {
            position += n;
            cnt++;
        }
        return cnt;
    }
}
