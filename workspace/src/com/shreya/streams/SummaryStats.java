package com.shreya.streams;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class SummaryStats {
    public static void main(String[] args) {
        IntSummaryStatistics intSummaryStatistics = IntStream.of(25, 45, 76, 89, 99, 100).summaryStatistics();
        System.out.println(intSummaryStatistics);
        System.out.println(intSummaryStatistics.getSum());
    }
}
