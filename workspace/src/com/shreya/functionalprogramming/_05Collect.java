package com.shreya.functionalprogramming;

import java.util.*;
import java.util.stream.Collectors;

public class _05Collect {
    public static void main(String[] args) {
        String[] str = {"Ram", "Syam", "Dhanshaym", "Hanuman", "Ganesha", "Mahadeva", "Dev"};
        ArrayList<String> names = new ArrayList<>(Arrays.asList(str));

        List<String> nameList = names.stream().filter(s -> s.length() > 5).collect(Collectors.toList());
        System.out.println(nameList);
        Set<String> nameSet = names.stream().map(s -> s.toUpperCase(Locale.ROOT)).collect(Collectors.toSet());
        System.out.println(nameSet);

        String collect = names.stream().collect(Collectors.joining(", "));
        System.out.println(collect);

        Long collect1 = names.stream().collect(Collectors.counting());
        System.out.println(collect1);
        collect1 = names.stream().filter(s -> s.length() > 5).collect(Collectors.counting());
        System.out.println(collect1);

        try {
            Map<Integer, String> collect2 = names.stream().collect(Collectors.toMap(s -> s.length(), s -> s));
            System.out.println(collect2);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        //grouping by

        Map<Integer, List<String>> collect2 = names.stream().collect(Collectors.groupingBy(s -> s.length()));
        System.out.println(collect2);

        //partitioning by (this is similar to grouping by, diff is it will group in 2 parts, using predicate)

        Map<Boolean, List<String>> collect3 = names.stream().collect(Collectors.partitioningBy(s -> s.length() > 5));
        System.out.println(collect3);

    }
}
