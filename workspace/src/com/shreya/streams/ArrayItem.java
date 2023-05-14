package com.shreya.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ArrayItem {
    public static int[] removeOnce(int[] arr, int value) {
        int index = IntStream.range(0, arr.length).filter(i -> arr[i] == value).findFirst().getAsInt();
        return IntStream.range(0, arr.length).filter(i -> i != index).map(i -> arr[i]).toArray();
    }

    public static int[] removeAll(int[] arr, int value) {
        return Arrays.stream(arr).filter(val -> val != value).map(x -> x).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4, 3, 5};
        int value = 3;
        List<Integer> sss = Arrays.stream(arr).mapToObj(a -> a).collect(Collectors.toList());
        System.out.println("list :::: " + sss);
        System.out.print("Actual      : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.print("\n\nRemove Once : ");
        arr = removeOnce(arr, value);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.print("\nRemove All  : ");
        arr = removeAll(arr, value);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}