package com.shaurya._17striver._06arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Rearrange Array Elements by Sign
 * <p>
 * <p>
 * 178
 * <p>
 * 2
 * Variety-1
 * <p>
 * Problem Statement:
 * <p>
 * There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements. Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values.
 * <p>
 * Note: Start the array with positive elements.
 * <p>
 * Examples:
 * <p>
 * Example 1:
 * <p>
 * Input:
 * arr[] = {1,2,-4,-5}, N = 4
 * Output:
 * 1 -4 2 -5
 * <p>
 * Explanation:
 * <p>
 * Positive elements = 1,2
 * Negative elements = -4,-5
 * To maintain relative ordering, 1 must occur before 2, and -4 must occur before -5.
 * <p>
 * Example 2:
 * Input:
 * arr[] = {1,2,-3,-1,-2,-3}, N = 6
 * Output:
 * 1 -3 2 -1 3 -2
 * Explanation:
 * <p>
 * Positive elements = 1,2,3
 * Negative elements = -3,-1,-2
 * To maintain relative ordering, 1 must occur before 2, and 2 must occur before 3.
 * Also, -3 should come before -1, and -1 should come before -2.
 */
public class _13RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] arr = {1, 2, -4, -5};
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        System.out.println();
        rearrange(arr);
        Arrays.stream(arr).forEach(s -> System.out.print(s + " "));
        System.out.println();
        int[] arr1 = {1, 2, -4, -5};
        Arrays.stream(arr1).forEach(s -> System.out.print(s + " "));
        System.out.println();
        rearrangeSinglePass(arr1);
        Arrays.stream(arr1).forEach(s -> System.out.print(s + " "));
    }

    private static void rearrangeSinglePass(int[] arr) {
        List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int posIdx = 0;
        int negIdx = 1;
        for (int i = 0; i < arrList.size(); i++) {
            if (arrList.get(i) > 0) {
                arr[posIdx] = arrList.get(i);
                posIdx = posIdx + 2;
            } else {
                arr[negIdx] = arrList.get(i);
                negIdx = negIdx + 2;
            }
        }
    }

    //with extra space
    private static void rearrange(int[] arr) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                pos.add(arr[i]);
            } else {
                neg.add(arr[i]);
            }
        }

        for (int i = 0; i < arr.length / 2; i++) {
            arr[2 * i] = pos.get(i);
            arr[2 * i + 1] = neg.get(i);
        }
    }
}
