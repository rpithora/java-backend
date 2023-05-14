package com.shaurya._6recursion;

import java.util.HashSet;
import java.util.Set;

public class PrintUniqueSubset {
    public static void main(String[] args) {
        String input = "aab";
        String output = "";
        Set<String> hSet = new HashSet<>();
        solution(input, output, hSet);
        System.out.println(hSet);
    }

    private static void solution(String input, String output, Set<String> hSet) {
        if(input.isEmpty()){
            if(!output.isEmpty())
                hSet.add(output);
            return;
        }

        String op1 = output;
        String op2 = output;

        op1+=input.substring(0,1);

        input = input.substring(1,input.length());

        solution(input, op1, hSet);
        solution(input, op2, hSet);

    }
}
