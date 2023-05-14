package com.shaurya._1array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortArrayRelatively {
    public static void main(String[] args) {
        int[] Array1 = {10, 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8};
        int[] Array2 = {2, 1, 8, 3};
        solution(Array1, Array2);
    }

    private static void solution(int[] array1, int[] array2) {

        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> hMap = new HashMap<>();

        for (int a : array1) {
            hMap.put(a, hMap.getOrDefault(a, 0) + 1);
        }

        for (int a : array2) {
            if (hMap.containsKey(a)) {
                int count = hMap.get(a);
                for (int jtr = 0; jtr < count; jtr++) {
                    result.add(a);
                }
                hMap.remove(a);
            }
        }

        for (Map.Entry m : hMap.entrySet()) {
            int count = (int) m.getValue();
            for (int jtr = 0; jtr < count; jtr++) {
                result.add((Integer) m.getKey());
            }
        }
        System.out.println(result);
    }
}
