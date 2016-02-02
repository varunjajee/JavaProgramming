package com.muks.algo.AlgosOnArrays;

/*
 * Created by mukthar.ahmed on 2/2/16.
 */
public class ReverseArrayByRecurssion {

    static void reverseArray(int arr[], int start, int end) {
        int temp;
        if (start >= end) {
            return;
        }

        temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start+1, end-1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        reverseArray(arr, 0, arr.length-1);

        for (int i : arr) {
            System.out.print(" " + i);
        }
    }

}
