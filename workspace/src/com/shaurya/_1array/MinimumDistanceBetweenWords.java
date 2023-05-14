package com.shaurya._1array;

import java.util.ArrayList;

public class MinimumDistanceBetweenWords {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("geeks");
        list.add("for");
        list.add("geeks");
        list.add("contribute");
        list.add("practice");
        String w1 = "geeks";
        String w2 = "practice";
        System.out.println(shortestDistance(list, w1, w2));
    }

    private static int shortestDistance(ArrayList<String> words, String w1, String w2) {
        int distance = Integer.MAX_VALUE;
        int position = -1;
        if (w1.equals(w2)) {
            return 0;
        }
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i) == w1 || words.get(i) == w2) {
                if (position != -1) {
                    if (words.get(i) != words.get(position)) {
                        distance = Math.min(distance, (i - position) - 1);
                    }
                }
                position = i;
            }
        }
        return distance;
    }
}
