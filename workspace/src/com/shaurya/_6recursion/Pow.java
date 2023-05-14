package com.shaurya._6recursion;

public class Pow {
    public static void main(String[] args) {
        Pow pow = new Pow();
        System.out.println(pow.pow(71045970, 41535484, 64735492));
    }
    public int pow(int A, int B, int C) {
        long ans = power(A, B);
        return (int) (ans<0?ans+C:ans%C);
    }
    public long power(int A, int B){
        if(B == 0)
            return 1;
        if(A == 0)
            return 0;

        long x = power(A, B/2);

        if(B%2 == 0){
            return x * x ;
        }else{
            return x * x * A;
        }
    }
}
