package com.muks.Algorithm.SortingTechniques;

/**
 * Created by mukthar.ahmed on 1/13/16.
 *
 *
 */
public class MergeSort {

//    private static int[] numbers;
//    private static int[] helper;

    public static void main(String[] args) {
        int[] numbers = {3, 2, 5, 1, 4, 0};
        mergeSort(numbers);

        printArray(numbers);
    }


    private static void mergeSort(int[] input) {
        if (input.length <= 1) {
            return;
        }

        // Split the array in half
        int mid = input.length/2;
        int[] first = new int[mid];
        int[] second = new int[input.length - mid];

        int i;
        for (i = 0 ; i < mid; i++) {
            first[i] = input[i];
        }

        for (int j = mid; j < input.length; j++) {
            second[j - mid] = input[j];
        }

        // Sort each half
        mergeSort(first);
        mergeSort(second);

        // Merge the halves together, overwriting the original array
        merge(first, second, input);

    }

    private static void merge(int[] first, int[] second, int[] actualArray) {
        int iFirst = 0;
        int iSecond = 0;

        int j = 0;

        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                actualArray[j] = first[iFirst];
                iFirst++;
            } else {
                actualArray[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }

        // copy what's left
        System.arraycopy(first, iFirst, actualArray, j, first.length - iFirst);
        System.arraycopy(second, iSecond, actualArray, j, second.length - iSecond);
    }



    private static void printArray(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(" " + i);
        }
        System.out.println(sb.toString());
    }
}   // end class
