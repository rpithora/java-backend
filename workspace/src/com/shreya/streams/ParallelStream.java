package com.shreya.streams;

import java.util.stream.IntStream;

public class ParallelStream {
    public static void main(String[] args) {
        long start ;
        long end ;

        start = System.currentTimeMillis();
        IntStream.range(1, 100).forEach(s -> System.out.print(" "+s));
        end = System.currentTimeMillis();
        System.out.println();
        System.out.println("Total execution time : "+(end -start));

        start = System.currentTimeMillis();
        IntStream.range(1, 100).parallel().forEach(s -> System.out.print(" " +s));
        end = System.currentTimeMillis();
        System.out.println();
        System.out.println("Parallel Total execution time : "+(end -start));

        // Thread Name

        IntStream.range(1,10).forEach(s ->{
            System.out.println("Value : "+s+" Thread Name "+Thread.currentThread().getName());
        });
        System.out.println();
        System.out.println("++++++++++++++");
        IntStream.range(1,10).parallel().forEach(s ->{
            System.out.println("Value : "+s+" Thread Name "+Thread.currentThread().getName());
        });
    }
}
