package com.muks.Algorithm.AlgosOnArrays.Basics;

/*
 * Created by mukthar.ahmed on 2/2/16.
 */
public class ReverseArrayByRecurssion {

    /** In-Place Reverse array by swapping elements */
    public static void reverse(int[] arr, int left, int right){
        if(arr == null || arr.length == 1)
            return;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    /** Reverse array by recursion */
    static void reverseByRecursion(int arr[], int start, int end) {
        if (start >= end) {
            return;
        }

        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseByRecursion(arr, start+1, end-1);
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        reverseByRecursion(arr, 0, arr.length-1);

        for (int i : arr) {
            System.out.print(" " + i);
        }
    }

}
