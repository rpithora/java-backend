package com.shaurya._16companies.optum;

import java.util.Locale;

public class CountPalindromeWordsSentence {
    public static void main(String[] args) {
        String sentence = "Madam Arora teaches malayalam";
        int count = count(sentence);
        System.out.println("Total Count : " + count);
        sentence = "Nitin speaks malayalam";
        count = count(sentence);
        System.out.println("Total Count : " + count);
    }

    private static int count(String sentence) {
        int count = 0;
        for (String word : sentence.split(" ")) {
            int n = word.length() - 1;
            if (isPalindrome(word.toLowerCase(Locale.ROOT), n))
                count++;
        }
        return count;
    }

    private static boolean isPalindrome(String word, int n) {
        for (int i = 0; i < n; i++, n--) {
            if (word.charAt(i) != word.charAt(n)) {
                return false;
            }
        }
        return true;
    }
}
