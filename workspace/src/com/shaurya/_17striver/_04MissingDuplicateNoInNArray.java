package com.shaurya._17striver;

public class _04MissingDuplicateNoInNArray {
    public static void main(String[] args) {
        int arr[] = {4, 3, 6, 2, 1, 1} ;
        solution(arr);
    }

    private static void solution(int[] arr) {
        int []newArr = new int[arr.length+1];
        for(int i=0; i<arr.length; i++){
            newArr[arr[i]] = newArr[arr[i]] + 1;
        }
        for(int i=1; i<newArr.length; i++){
            if(newArr[i] == 0){
                System.out.println("Missing Number is : " + i);
            }else if(newArr[i] > 1){
                System.out.println("Duplicate Number is : " + i);
            }
        }
    }
}
