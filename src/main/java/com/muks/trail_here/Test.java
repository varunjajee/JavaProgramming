package com.muks.trail_here;

/**
 * Created by mukthar.ahmed on 12/22/15.
 */


public class Test {


    public static void factorial(int[] arr, int n) {
        if (n < 0) {
            return;
        }

        factorial (arr, n-1);
        System.out.println(arr[n]);
    }


    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4};
        // Try routine
        factorial(arr, arr.length-1);
    }

}
