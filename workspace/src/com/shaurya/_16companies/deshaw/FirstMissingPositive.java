package com.shaurya._16companies.deshaw;

public class FirstMissingPositive {
    public static void main(String[] args) {
        int arr[] = {0, 10, 2, -10, -20} ;
        // extra space
        System.out.println(solution(arr));
        System.out.println(solve(arr));
    }

    private static int solution(int[] arr) {
        int pos = -1;
        boolean[] present = new boolean[1000];
        for(int i=0; i<arr.length; i++){
            if(arr[i] > 0 && arr[i] <= arr.length)
                present[arr[i]] = true;
        }
        for(int i=1; i<present.length; i++){
            if(!present[i]){
                return i;
            }
        }
        return pos;
    }

    private static int solve(int[] arr) {
        // 1 2 3 4 5
        for(int i=0; i<arr.length; i++){
            if(arr[i] > 0 && arr[i] <= arr.length && arr[i] != arr[arr[i] - 1]){
                int temp = arr[arr[i] - 1];
                arr[arr[i] - 1] = arr[i];
                arr[i] = temp;
            }
        }
        for (int i = 0; i < arr.length; i++)
            if (arr[i] != i + 1)
                return (i + 1);

        return (arr.length + 1);
    }
}
