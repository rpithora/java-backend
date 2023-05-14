package com.shreya.thread;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class MaxAge {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        IntStream ints1 = IntStream.range(10, 200);
        IntStream ints2 = IntStream.range(1, 100);
        IntStream ints3 = IntStream.range(100, 250);

        Future<Integer> f1 = threadPool.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return ints1.max().getAsInt();
            }
        });

        Future<Integer> f2 = threadPool.submit(() -> ints2.max().getAsInt());
        Future<Integer> f3 = threadPool.submit(() -> ints3.max().getAsInt());
        int i = f1.get();
        int j = f2.get();
        int k = f3.get();
        System.out.println(i + " " + j + " " + k);

        threadPool.shutdown();
    }
}
