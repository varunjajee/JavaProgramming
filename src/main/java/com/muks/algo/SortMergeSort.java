package com.muks.algo;

/**
 * Created by mukthar.ahmed on 1/13/16.
 */
public class SortMergeSort {

    private static int[] numbers;
    private static int[] helper;

    public static void main(String[] args) {

        int[ ] numbers = { 1000, 80, 10, 50, 70, 60, 90, 20, 30, 40, 0, -1000 };
        MergeSort(0, numbers.length-1);
//
//        String s = "";
//        for (int i : sorted) {
//            s += i + " ";
//        }
//        System.out.println(s);
    }


    private static void MergeSort(int low, int high) {
        // check if low is smaller then high, if not then the array is sorted
        if (low < high) {

            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;

            // Sort the left side of the array
            MergeSort(low, middle);

            // Sort the right side of the array
            MergeSort(middle + 1, high);

            // Combine them both
            merge(low, middle, high);
        }
    }


    private static void merge(int low, int middle, int high) {

        // Copy both parts into the helper array
        for (int i = low; i <= high; i++) {
            helper[i] = numbers[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helper[i] <= helper[j]) {
                numbers[k] = helper[i];
                i++;
            } else {
                numbers[k] = helper[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            numbers[k] = helper[i];
            k++;
            i++;
        }

    }
}
