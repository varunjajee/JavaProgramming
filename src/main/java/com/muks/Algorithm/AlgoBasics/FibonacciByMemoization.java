package com.muks.Algorithm.AlgoBasics;

/*
 * Created by mukthar.ahmed on 1/21/16.
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


/* ===========================================================================================
    Memoization algorithm:
        Recording all the visited results and making use of the same.
 */
public class FibonacciByMemoization {

    private static final List<BigInteger> FIBONACCI_LIST = new ArrayList<>();

    static {
        FIBONACCI_LIST.add(BigInteger.ZERO);
        FIBONACCI_LIST.add(BigInteger.ONE);
    }

    public static BigInteger fibonacci(final int number) {
        if (number < 0){
            throw new IllegalArgumentException("negative number: " + number);
        }

        if (isInFibonacciList(number)) {
            return FIBONACCI_LIST.get(number);
        }

        BigInteger fibonacciValue = fibonacci(number - 1).add(fibonacci(number - 2));

        FIBONACCI_LIST.add(fibonacciValue);

        return fibonacciValue;
    }


    /** Check if we already have it */
    private static boolean isInFibonacciList(final int number) {
        return (number <= FIBONACCI_LIST.size() - 1);
    }


    public static void main(String[] args) {
        int[] findFib = {1, 2, 3, 4, 5, 6};


        System.out.println("# Fib(" + 5 + "): " + fibonacci(5) );
//
//        for (int i = 0; i <= 10; i++) {
//            System.out.println("# Fib(" + i + "): " + fibonacci(i) );
//        }

        System.out.println(FIBONACCI_LIST.toString());
    }


}
