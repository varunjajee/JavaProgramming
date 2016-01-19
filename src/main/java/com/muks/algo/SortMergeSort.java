package com.muks.algo;

/**
 * Created by mukthar.ahmed on 1/13/16.
 */
public class SortMergeSort {

    private static int[] numbers;
    private static int[] helper;

    public static void main(String[] args) {

        int[ ] numbers = { 1000, 80, 10, 50, 70, 60, 90, 20, 30, 40, 0, -1000 };
        System.out.println(mergeSort(numbers));

        String s = "";
        for (int i : numbers) {
            s += i + " ";
        }
        System.out.println(s);
    }

    public static int[] mergeSort(int [] list) {
        if (list.length <= 1) {
            return list;
        }

        // Split the array in half
        int mid = list.length/2;
        int[] first = new int[mid];
        int[] second = new int[list.length - mid];

        int i;
        for (i = 0 ; i < mid; i++) {
            first[i] = list[i];
        }

        for (int j = mid; j < list.length; j++) {
            second[j - mid] = list[j];
        }

        // Sort each half
        mergeSort(first);
        mergeSort(second);

        // Merge the halves together, overwriting the original array
        merge(first, second, list);
        return list;
    }

    private static void merge(int[] first, int[] second, int [] result) {
        // Merge both halves into the result array
        // Next element to consider in the first array
        int iFirst = 0;

        // Next element to consider in the second array
        int iSecond = 0;

        // Next open position in the result
        int j = 0;

        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the result.
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
            } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }

        // copy what's left
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }

//    private static void MergeSort(int low, int high) {
//        // check if low is smaller then high, if not then the array is sorted
//        if (low < high) {
//
//            // Get the index of the element which is in the middle
//            int middle = low + (high - low) / 2;
//
//            // Sort the left side of the array
//            MergeSort(low, middle);
//
//            // Sort the right side of the array
//            MergeSort(middle + 1, high);
//
//            // Combine them both
//            merge(low, middle, high);
//        }
//    }
//
//
//    private static void merge(int low, int middle, int high) {
//
//        // Copy both parts into the helper array
//        for (int i = low; i <= high; i++) {
//            helper[i] = numbers[i];
//        }
//
//        int i = low;
//        int j = middle + 1;
//        int k = low;
//        // Copy the smallest values from either the left or the right side back
//        // to the original array
//        while (i <= middle && j <= high) {
//            if (helper[i] <= helper[j]) {
//                numbers[k] = helper[i];
//                i++;
//            } else {
//                numbers[k] = helper[j];
//                j++;
//            }
//            k++;
//        }
//        // Copy the rest of the left side of the array into the target array
//        while (i <= middle) {
//            numbers[k] = helper[i];
//            k++;
//            i++;
//        }
//
//    }
}
