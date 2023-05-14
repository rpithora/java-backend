package com.shreya.streams;

import java.util.stream.Stream;

public class ReductionStreams {
    public static void main(String[] args) {
        Stream<Double> items = Stream.of(10.5, 15.5, 19.9);
        Double sum = items.reduce(0.0, (a, b) -> a + b);
        System.out.println("Total : " + sum);
    }
}
