package com.shreya.functionalprogramming;

import java.util.function.BiFunction;
import java.util.function.Function;

public class _01First {
    static class MyMath {
        public static int triple(int x) {
            return 3 * x;
        }
    }

    public static void main(String[] args) {
        Function<Integer, Integer> myTriple = MyMath::triple;
        Integer result = myTriple.apply(5);
        System.out.println(result);

        //Function<Integer, Integer> absoluteValue = s -> s < 0 ? -s : s;

        Function<Integer, Integer> absoluteValue = (s) -> {
            if (s < 0) {
                return -s;
            } else {
                return s;
            }
        };

        Integer res = absoluteValue.apply(-12);
        System.out.println(res);

        //BiFunction

        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
        System.out.println(add.apply(10, 20));

        //TriFunction

        TriFunction<Integer, Integer, Integer, Integer> addThree = (a, b, c) -> a + b + c;
        System.out.println(addThree.apply(10, 20, 30));

        //NoArg

        NoArgFunction<String> hello = () -> "Hello!!";
        System.out.println(hello.apply());

    }
}
