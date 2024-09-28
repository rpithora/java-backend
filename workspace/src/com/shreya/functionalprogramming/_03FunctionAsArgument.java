package com.shreya.functionalprogramming;

import java.util.function.BiFunction;

public class _03FunctionAsArgument {
    protected static class A1 {
        public static int add(int a, int b) {
            return a + b;
        }

        public static int subtract(int a, int b) {
            return a - b;
        }

        public static int combine2And3(BiFunction<Integer, Integer, Integer> combine) {
            return combine.apply(2, 3);
        }
    }

    public static void main(String[] args) {
        System.out.println(A1.combine2And3(A1::add));
        System.out.println(A1.combine2And3(A1::subtract));

        System.out.println(A1.combine2And3((a, b) -> 2 * (a + b)));

        NoArgFunction<NoArgFunction<String >> greeter = () -> () -> "Hello!";
        NoArgFunction<String> greet = greeter.apply();
        System.out.println(greet.apply());

    }
}
