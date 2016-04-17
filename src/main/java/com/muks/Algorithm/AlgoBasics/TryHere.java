package com.muks.Algorithm.AlgoBasics;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukthar.ahmed on 4/18/16.
 */
public class TryHere {

    public static void main(String[] args) {
        TryHere tryHere = new TryHere();
        System.out.println(tryHere.fibonacci(7));
    }

    static List<Integer> fibonacciSeries = new ArrayList<>();

    static {
        fibonacciSeries.add(0);
        fibonacciSeries.add(1);
    }

    // 0 1 1 2 3 5
    private int fibonacci(int n) {

        if (isInSeries(n)) {
            return fibonacciSeries.get(n);
        }

        return (fibonacci(n-1) + fibonacci(n-2));
    }

    private static boolean isInSeries(int n) {
        if (fibonacciSeries.size() > n) {
            return true;
        }

        return false;
    }
}
