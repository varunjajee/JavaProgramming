package com.muks.Algorithm.AlgosOnArrays.Basics;

import java.util.Arrays;

/**
 * Created by mukthar.ahmed on 2/19/16.
 *
 * Question:
 *          Given a int[] and a number, find the pair of integers which make the number
 *
 */
public class CheckPairIntArrayNum {

    public static void main(String[] args) {
        int[] numbers = {1, 4, 45, 6, 10, -8, 16, 0};
        int sum = 16;

        findPair(numbers, sum);
    }

    private static void findPair(int[] arr, int sum) {

        Arrays.sort(arr);

        for (int i : arr) {
            System.out.print(" " + i);
        }

        int left = 0;
        int right = arr.length-1;
        while (left < right) {

            if ( (arr[left] + arr[right]) == sum) {
                System.out.println("\n+ Found the pairs: (1) " + arr[left] + " and (2) " +
                        arr[right]);
                //return true;
            }
            if ((arr[left] + arr[right]) < sum) {
                left++;
            }
            else {
                right--;
            }
        }

        //return false;

    }
}
