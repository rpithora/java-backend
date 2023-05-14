package com.shaurya._5string;

import java.util.Arrays;

public class CountNumberSubstringsExactlyKDistinctChar {
    public static void main(String[] args) {
        String s = "abcbaa";
        int k = 3;
        // O(n2) Approach
        solution(s, k);

        // O(n) Approach
        solution(s, k);
    }

    private static void solution(String s, int k) {
        boolean seen[] = new boolean[26];
        int counter = 0;
        for(int i=0; i<s.length(); i++){
            int distinct = 0;
            Arrays.fill(seen, false);
            for(int j=i; j<s.length(); j++){
                if(!seen[s.charAt(j) - 'a'])
                    distinct++;

                seen[s.charAt(j) - 'a'] = true;

                if(distinct == k)
                    counter++;
            }
        }
        System.out.println("Total Substring : " + counter);
    }
}
