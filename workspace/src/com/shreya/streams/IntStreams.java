package com.shreya.streams;

import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class IntStreams {
    public static void main(String[] args) {
        IntStream.range(1, 10).skip(4).forEach(System.out::print);
        System.out.println();
        System.out.println(IntStream.range(1,10).sum());
    }
}
