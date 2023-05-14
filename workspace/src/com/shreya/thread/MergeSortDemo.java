package com.shreya.thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class MergeSortDemo {

    public static void main(String[] args) {
        Integer A[] = {1, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 100};
        List<Integer> al = new ArrayList<>(Arrays.asList(A));
        System.out.println("The Input List ::: ");
        al.stream().forEach(s -> System.out.print(s + " "));
        System.out.println();
        System.out.println("Sorting...");
        mergeSort(al);
    }

    private static void mergeSort(List<Integer> al) {
        System.out.println("No. of Core ::: " + Runtime.getRuntime().availableProcessors());
        ExecutorService executor = Executors.newFixedThreadPool(20);
        try {
            Future<List<Integer>> sortedListFuture = executor.submit(new MergeSort(al, executor));
            List<Integer> sortedList = sortedListFuture.get();
            sortedList.stream().forEach(s -> System.out.print(s + " "));
            if(sortedListFuture.isDone()){
                executor.shutdown();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
