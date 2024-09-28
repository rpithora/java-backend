package com.shaurya._17striver._08string;

import java.util.Arrays;

public class _02LongestCommonPrefix {
    public static void main(String[] args) {
        String[] arr = {"god", "godman", "goibibo", "gogoagone"};
        Arrays.sort(arr);

        String s1 = arr[0];
        String s2 = arr[arr.length - 1];

        int i = 0;
        while (i < Math.min(s1.length(), s2.length())) {
            if (!(s1.charAt(i) == s2.charAt(i)))
                break;
            i++;
        }

        System.out.println("the longest common prefix : " + s1.substring(0, i));
    }
}
