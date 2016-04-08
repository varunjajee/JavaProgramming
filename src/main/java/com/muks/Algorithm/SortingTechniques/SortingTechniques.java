package com.muks.Algorithm.SortingTechniques;


import com.muks.Algorithm.MyUtils;

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
        int[] arrayToSort = new int[]{3, 2, 5, 1, 4, 0};

        //InsertionSorting(arrayToSort);
        //SelectionSort(arrayToSort);
        QuickSorting(arrayToSort);
        printArray(arrayToSort);

        //InsertionSorting();
    } // end main


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
     .
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
     .
     * Logic:
     * - Finds i = max-element index, j = max-element index, and finally swap
     */
    private static void SelectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int index_of_min = i;

            for (int j = i; j < array.length; j++) {
                if (array[index_of_min] > array[j]) {
                    index_of_min = j;
                }
            }

            /** swap max and min */
            int temp = array[i];
            array[i] = array[index_of_min];
            array[index_of_min] = temp;
        }

    } // end SelectionSort()


    /**
     * Time - O(n Log n)
     *
     * Partition() - The partition routine examines every item in the array at most once, so it is clearly O(n).
     * Divide 'n' items - recursively takes - log-n
     .
     .
     *  Logic:
     *      - First, partition and sort sub array   - O(n)
     *      - Recursively, partition sort left and right sub arrays - O( Log n)
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

        int i = start-1;
        int j = end+1;

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
            }
            else {
                return j;   /** Returning j as the mid element */
            }
         }
    }





	/* 	=========================================================================================
     *  In merge sort split the array values in halves recursively until each half has only
	 *  single  element.
	 *  Merge the two 1/2 values together and sort the values.
	 *  Do same steps iteratively until the values are not sorted.
	 */

    /**
     * Analysis
     * The partition routine examines every item in the array at most once, so it is clearly O(n).
     * <p>
     * Usually, the partition routine will divide the problem into two roughly equal sized partitions. We know that we can
     * divide n items in half log2n times. This makes quicksort a O(nlogn) algorithm - equivalent to heapsort.
     */
    public static void MergeSort(int[] arr, int lo, int n) {
        int low = lo;
        int high = n;

        if (low >= high) {
            return;
        }

        int middle = (low + high) / 2;
        MergeSort(arr, low, middle);
        MergeSort(arr, middle + 1, high);

        int end_low = middle;
        int start_high = middle + 1;

        while ((lo <= end_low) && (start_high <= high)) {
            if (arr[low] < arr[start_high]) {
                low++;

            } else {
                int Temp = arr[start_high];

                for (int k = start_high - 1; k >= low; k--) {
                    arr[k + 1] = arr[k];
                }

                arr[low] = Temp;
                low++;
                end_low++;
                start_high++;

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
    }

} // end of class

