package com.muks.algo;

/*
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

    public static int[] mergeSort(int[] mainArray) {
        if (mainArray.length <= 1) {
            return mainArray;
        }

        // Split the array in half
        int mid = mainArray.length/2;
        int[] first = new int[mid];
        int[] second = new int[mainArray.length - mid];

        int i;
        for (i = 0 ; i < mid; i++) {
            first[i] = mainArray[i];
        }

        for (int j = mid; j < mainArray.length; j++) {
            second[j - mid] = mainArray[j];
        }

        // Sort each half
        mergeSort(first);
        mergeSort(second);

        // Merge the halves together, overwriting the original array
        merge(first, second, mainArray);
        return mainArray;
    }

    private static void merge(int[] first, int[] second, int[] actualArray) {
        // Merge both halves into the actualArray array
        // Next element to consider in the first array
        int iFirst = 0;

        // Next element to consider in the second array
        int iSecond = 0;

        // Next open position in the actualArray
        int j = 0;

        // As long as neither iFirst nor iSecond is past the end, move the
        // smaller element into the actualArray.
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

}   // end class
