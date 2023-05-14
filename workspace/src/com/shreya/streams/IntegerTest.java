package com.shreya.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntegerTest {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 5, 9, 12, 15);
        Integer sum = list.stream().reduce(0, (a, b) -> a + b);
        System.out.println(sum);
        System.out.println(list.stream().reduce(0, Integer::sum));

        IntStream intStream = list.stream().mapToInt(Integer::intValue);
        System.out.println(intStream.sum());
        intStream = list.stream().mapToInt(Integer::intValue);
        System.out.println(intStream.average().getAsDouble());

        List<Integer> sq = list.stream()
                .map(s -> s * s)
                .filter(s -> s > 100)
                .collect(Collectors.toList());
        sq.forEach(System.out::println);
        System.out.println(sq.stream().mapToInt(Integer::intValue).average());
        System.out.println("Even ++++++");
        list.stream().filter(s -> s%2 == 0).forEach(System.out::println);
        System.out.println("Odd ++++++");
        list.stream().filter(s -> s%2 != 0).forEach(System.out::println);
        System.out.println("Descending ++++++");
        list.stream().sorted((a, b) -> b -a).forEach(System.out::println);
        list.stream().sorted().forEach(System.out::println);
    }
}
