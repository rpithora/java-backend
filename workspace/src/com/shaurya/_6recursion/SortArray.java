package com.shaurya._6recursion;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortArray {
    public static void main(String[] args) {
        /*Integer arr[] = {2 , 7, 6, 4, 5, 9, 3} ;
        List<Integer> arrList = new ArrayList<>();
        arrList.add(2);arrList.add(7);arrList.add(6);arrList.add(4);arrList.add(5);
        arrList.add(9);arrList.add(3);*/

        //List<Integer> arrList = Arrays.asList(arr);

        List<Integer> arrList = Stream.of(2, 7, 6, 4, 5, 9, 3).collect(Collectors.toList());
        arrList.stream().forEach(s -> System.out.print(s + " "));
        //Arrays.sort(arr);
        System.out.println();
        solution(arrList);

        arrList.stream().forEach(s -> System.out.print(s + " "));
    }

    private static void solution(List<Integer> arrList) {
        if(arrList.size() == 0){
            return;
        }
        int last = arrList.remove(arrList.size()-1);
        solution(arrList);
        insert(arrList, last);
    }

    private static int[] removeLastElement(int[] arr, int index) {
        int[] anotherArray = new int[arr.length - 1];
        for(int i=0,k = 0; i<arr.length; i++, k++){
            if(i!=index){
                anotherArray[k] = arr[i];
            }
        }
        return anotherArray;
    }

    private static void add(int[] arr, int last) {
        int[] newArray = new int[arr.length + 1];
        if(arr.length == 0){
            arr[0] = last;
            return ;
        }

        int i=0, k = 0;
        for(i=0, k=0; i<arr.length;i++,k++){
            if(arr[i] <= last){
                newArray[k] = arr[i];
            }else {
                break;
            }
        }
        newArray[k] = last;
        k++;
        for(; i<arr.length;i++,k++){
            newArray[k] = arr[i];
        }
        return ;
    }

    private static void insert(List<Integer> arrList, int last) {
        if(arrList.size() == 0 || arrList.get(arrList.size()-1) <= last){
            if(arrList.size() == 0){
                arrList.add(last);
            }else {
                arrList.add(arrList.size(), last);
            }
            return ;
        }

        int temp = arrList.remove(arrList.size()-1);
        insert(arrList,last);
        arrList.add(arrList.size(), temp);

    }
}
