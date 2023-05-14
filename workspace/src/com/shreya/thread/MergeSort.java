package com.shreya.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MergeSort implements Callable<List<Integer>> {

    private List<Integer> input ;
    private ExecutorService  executor;

    public MergeSort(List<Integer> input, ExecutorService  executor){
        this.input = input;
        this.executor = executor;
    }
    @Override
    public List<Integer> call() throws Exception {
        if(input.size() < 2){
            return input;
        }else{
            List<Integer> leftList = new ArrayList<>();
            List<Integer> rightList = new ArrayList<>();
            int mid = input.size()/2;
            for(int i=0; i<mid; i++){
                leftList.add(input.get(i));
            }
            for(int j=mid; j<input.size(); j++){
                rightList.add(input.get(j));
            }

            Future<List<Integer>> leftSortedFuture = executor.submit(new MergeSort(leftList, executor));
            Future<List<Integer>> rightSortedFuture = executor.submit(new MergeSort(rightList, executor));

            List<Integer> leftSorted = leftSortedFuture.get();
            List<Integer> rightSorted = rightSortedFuture.get();

            List<Integer> sortedList = new ArrayList<>();
            int i=0, j=0;
            while (i<leftList.size() && j<rightList.size()){
                if(leftList.get(i) <= rightList.get(j)){
                    sortedList.add(leftSorted.get(i));
                    i++;
                }else{
                    sortedList.add(rightSorted.get(j));
                    j++;
                }
            }
            while (i<leftList.size()){
                sortedList.add(leftSorted.get(i));
                i++;
            }
            while (j<rightList.size()){
                sortedList.add(rightSorted.get(j));
                j++;
            }
            return sortedList;
        }
    }
}
