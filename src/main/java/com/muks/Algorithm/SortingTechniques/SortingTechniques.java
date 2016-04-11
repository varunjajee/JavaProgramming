package com.muks.Algorithm.SortingTechniques;


/**
 * Sorting techniqueues:
 * 1) Insertion Sorting
 * 2) Selection Sorting
 * 3) Quick Sort
 * 4) Merge Sort
 * 5) Heap Sort
 */

public class SortingTechniques {

    public static void main(String[] args) { // arrays are always call-by reference, so it retains its reference
        //int[] arrayToSort = new int[] {9, 2, 8, 5, 1, 10, 0};
        int[] arrayToSort = {3, 2, 5, 1, 4, 0};

        //InsertionSorting(arrayToSort);
        //SelectionSort(arrayToSort);
        //QuickSorting(arrayToSort);


        printArray(arrayToSort);
    } // end main


    /** Sorting technique used in sorting singly linked list */
    private static void insertion(int[] arr) {
        int runner;
        for (int i = 0; i < arr.length; i++) {
            runner = 0;

            while (runner <= i) {
                if (arr[runner] > arr[i]) {
                    swap(arr, runner, i);
                }
                runner++;
            }
        }

    }

    /**
     *  Heap sort - Pending ????
     *  Addition and deletion are both O(logn) operations. We need to perform n additions and deletions, leading to
     *  an O(nlogn) algorithm. We will look at another efficient sorting algorithm, Quicksort, and then compare it
     *  with Heap sor
     */


    /**
     * ===========================================================================================
     * Time - O(n^2)
     * Space - O(1) auxiliary space
     * .
     * Logic: Picks a key a[i] and finds a right position to place it by moving other elements right
     */
    private static void InsertionSorting(int[] arr) {

        int key;    /** key to best fit */

        for (int i = 1; i < arr.length; i++) {
            int j = i;
            key = arr[i];

            while ((j > 0) && (arr[j - 1] > key)) {
                arr[j] = arr[j - 1];      /** move elements towards right */
                j--;
            }

            arr[j] = key;   /** Finally, best fit the key */
        }
    }


    /**
     * Time - O(n^2)
     * Space - O(1)
     * .
     * Logic:
     * - Finds i = max-element index, j = max-element index, and finally swap
     */
    private static void SelectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index_of_min = i;

            for (int j = i; j < array.length; j++) {
                if (array[j] < array[index_of_min]) {
                    index_of_min = j;
                }
            }

            /** swap max and min */
            swap(array, i, index_of_min);
        }

    } // end SelectionSort()


    /**
     * Time - O(n Log n)
     * <p>
     * Partition() - The partition routine examines every item in the array at most once, so it is clearly O(n).
     * Divide 'n' items - recursively takes - log-n
     * .
     * .
     * Logic:
     * - First, partition and sort sub array   - O(n)
     * - Recursively, partition sort left and right sub arrays - O( Log n)
     */
    public static int[] QuickSorting(int[] arr) {
        QuickSorting(arr, 0, arr.length - 1);
        return arr;
    }

    public static void QuickSorting(int[] arr, int start, int end) {
        if (start < end) {
            int mid = Partition(arr, start, end);
            QuickSorting(arr, start, mid);
            QuickSorting(arr, mid + 1, end);
        }

    }

    private static int Partition(int[] arr, int start, int end) {
        int pivot = arr[start];

        int i = start - 1;
        int j = end + 1;

        while (true) {
            i++;
            while (arr[i] < pivot) {
                i++;
            }

            j--;
            while (arr[j] > pivot) {
                j--;
            }

            /** swap them, if pointers have NOT crossed */
            if (i < j) {
                swap(arr, i, j);
            } else {
                return j;   /** Returning j as the mid element */
            }
        }
    }





    // swap 2 elements
    public static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;

    }


    // print the original array:
    public static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(" " + a);
        }
        System.out.println("");
    }

} // end of class

