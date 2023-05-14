package com.shaurya._16companies.optum;

import java.util.ArrayList;

public class MinimumDistanceBetweenWord {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("geeks");
        list.add("for");
        list.add("geeks");
        list.add("contribute");
        list.add("contribute");
        list.add("practice");
        list.add("geeks");
        String w1 = "geeks";
        String w2 = "practice";
        System.out.println(shortestDistance(list, w1, w2));
    }

    private static int shortestDistance(ArrayList<String> list, String w1, String w2) {
        int pos = -1, distance = Integer.MAX_VALUE;
        if (w1 == w2) {
            return 0;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == w1 || list.get(i) == w2) {
                if(pos != -1){
                    if(list.get(i) != list.get(pos)){
                        distance = Math.min(distance, i-pos-1);
                    }
                }
                pos = i;
            }
        }
        return distance;
    }
}
