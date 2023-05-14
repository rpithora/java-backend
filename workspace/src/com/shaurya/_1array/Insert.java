package com.shaurya._1array;

import java.util.Arrays;

public class Insert {
    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 5} ;
        int value = 3;

        int newArray[] = new int[arr.length+1];
        Arrays.stream(arr).forEach(s -> System.out.print(s+" "));
        System.out.println();
        int i=0, k = 0;
        for(i=0, k=0; i<arr.length;i++,k++){
            if(arr[i] <= value){
                newArray[k] = arr[i];
            }else {
                break;
            }
        }
        newArray[k] = value;
        k++;
        for(; i<arr.length;i++,k++){
            newArray[k] = arr[i];
        }

        Arrays.stream(newArray).forEach(s -> System.out.print(s+" "));
    }
}
