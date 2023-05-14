package com.shaurya._16companies.google;

public class GoogleInterview {
    public static void main(String[] args) {
        int []arr = {1, 2, 3, 4, 5};

        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                for(int k=i; k<=j; k++){
                    System.out.print(arr[k] + " ");
                }
                System.out.println();
            }
        }

        prefixSum(arr);
        n2(arr);
        bestSolutionSum(arr); // Contribution Technique
        int arr1[] = {2, 4, -8, 10, 15, -3, 20};
        kadaneAlgo(arr1);
    }
    private static void kadaneAlgo(int arr[]){
        int left = 0, right = 0;
        int ans_l = 0;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i=0; i<arr.length; i++){
            sum+=arr[i];

            if(sum > max){
                max = sum;
                ans_l = left;
                right = i;
            }
            //max = Math.max(max, sum);

            if(sum < 0){
                left = i+1;
                sum = 0;
            }
        }
        System.out.println("Kadane : Max Sum SubArray : " + max);
        System.out.println("Final ::: left : " + ans_l + " :: right : " + right);
    }

    private static void bestSolutionSum(int arr[]){
        int totalSum = 0;
        for(int i=0; i<arr.length; i++){
            totalSum+=((i+1) * (arr.length - i) * arr[i]);
        }
        System.out.println("Total Sum : " + totalSum);
    }

    private static void prefixSum(int arr[]){
        int pf[] = new int[arr.length];
        pf[0] = arr[0];
        for(int i=1; i<arr.length; i++){
            pf[i] = pf[i-1] + arr[i];
        }
        int total = 0;
        for(int i=0; i<arr.length; i++){
            int sum = 0;
            for(int j=i; j<arr.length; j++){
                if(i==0){
                    sum = pf[j];
                }else{
                    sum = pf[j] - pf[i-1];
                }
                System.out.println("sum : " + sum);
                total+=sum;
            }
            System.out.println();
        }
        System.out.println("Total : " + total);
    }
    private static void n2(int arr[]){
        for(int i=0; i<arr.length; i++){
            int sum = 0;
            String s = "" ;
            for(int j=i; j<arr.length; j++){
                sum+=arr[j];
                s+=" "+arr[j];
                System.out.println(s + " , sum : " + sum + " ");
            }
            System.out.println();
        }
    }
}
