package com.shaurya._3slidingwindow;

public class _1MaximumSumSubArray {
    public static void main(String[] args) {
        int arr[] = {2,5,1,8,2,9,1};
        int k=3;
        System.out.println(solution(arr,k));
    }

    private static int solution(int[] arr, int k) {
        int i=0, j=0, sum=0;
        int max = Integer.MIN_VALUE;
        while(j< arr.length){
            sum+=arr[j];
            if(j-i+1<k){
                j++;
            }else{
                System.out.println(sum);
                max = Math.max(max, sum);
                sum-=arr[i];
                i++;j++;
            }
        }
        return max;
    }
}
