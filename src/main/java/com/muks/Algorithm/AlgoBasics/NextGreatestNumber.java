package com.muks.Algorithm.AlgoBasics;

import java.util.Arrays;
import java.util.List;

/**
 * Created by mukthar.ahmed on 5/5/16.
 */
public class NextGreatestNumber {
    public static void main(String[] args) {
        int number = 2222;
        nextGreatestInt(numberToArray(number));
    }


    private static void nextGreatestInt(int[] arr) {
        /** 1) Traversing from right to left, find the first digit that is
            smaller than the digit next to it and break out
         */
        int len = arr.length;
        int i;
        for (i = len-1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                break;
            }
        }

        /** If no such digit is found, then all digits are in descending order and next big int cannot be found */
        if (i==0) {
            System.out.println("Next number is not possible");
            return;
        }


        /** 2) Find a int such that its greater than 'i' and smaller than 'i-1' on the right side
         * */
        int x = arr[i-1];
        int rgtSmallest = i;
        int j;
        for (j = i+1; j < len; j++) {
            if (arr[j] > x && arr[j] < arr[rgtSmallest]) {
                rgtSmallest = j;
            }
        }

        /** 3) Swap the above found smallest digit with number[i-1] */
        swap(arr, (i-1), rgtSmallest);

        /** 4) finally sort the rest of the array in increasing order */
        sortInIncreasingOrder(arr, i, arr.length-1);

        for (int n : arr) {
            System.out.print(n);
        }
    }


    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void sortInIncreasingOrder(int[] arr, int startIndex, int endIndex) {
        /** base case for the break of flow */
        if(startIndex == endIndex) {
            return;
        }

        for (int i = startIndex; i <= endIndex; i++) {
            int runner = startIndex;

            while (runner != i) {
                if (arr[runner] > arr[i]) {
                    swap(arr, runner, i);
                }
                runner++;
            }
        }
    }

    private static int[] numberToArray(int number) {
        String numString = Integer.toString(number);
        int[] numArray = new int[numString.length()];
        for (int i = 0; i < numString.length(); i++) {
            numArray[i] = numString.charAt(i) - '0';
        }

        for (int i : numArray) {
            System.out.print(" " + i);
        }
        System.out.println("");

        return numArray;
    }
}
