package com.shreya.functionalprogramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class _04MapFilterPredicate {
    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        List<Integer> ints = new ArrayList<>(Arrays.asList(arr));

        Function<Integer, Integer> multiplyBy2 = s -> 2 * s;

        // If I need to do multiply by 3,5, 6 i.e. dynamic number

        Function<Integer, Function<Integer, Integer>> byMultiplier = (number) -> (s) -> s * number;
        Function<Integer, Integer> multiplyBy5 = byMultiplier.apply(5);

        List<Integer> collect3 = ints.stream().map(multiplyBy5).collect(Collectors.toList());
        System.out.println(collect3);

        //map

        List<Integer> collect = ints.stream().map(multiplyBy2).collect(Collectors.toList());
        System.out.println(collect);

        //filter
        Predicate<Integer> even = s -> s % 2 == 0;

        List<Integer> collect1 = ints.stream().filter(even).collect(Collectors.toList());
        System.out.println(collect1);

        String[] str = {"Bangalore", "Pune", "Jaipur", "Ajmer", "Kishangarh", "Hyderabad", "Chennai"};

        ArrayList<String> strings = new ArrayList<>(Arrays.asList(str));

        strings.stream().filter(s -> s.length() > 5).forEach(s -> System.out.print(s + " "));
        System.out.println();

        BinaryOperator<Integer> sum = (acc, s) -> {
            int result = acc + s;
            System.out.println("element : " + s + ", acc : " + acc);
            System.out.println("sum : " + result);
            return result;
        };

        Integer reduce1 = ints.stream().reduce(0, sum);
        Optional<Integer> reduce = ints.stream().reduce(sum);

        System.out.println(reduce.get());


    }
}
