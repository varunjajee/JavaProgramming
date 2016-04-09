package com.muks.Algorithm.SortingTechniques;

/**
 * Created by mukthar.ahmed on 4/9/16.
 *
 * - http://faculty.simpson.edu/lydia.sinapova/www/cmsc250/LN250_Weiss/L13-HeapSortEx.htm
 */
public class HeapSort {


    /* Main method */
    public static void main(String[] args) {
        int[] numbers = {3, 2, 5, 1, 4, 0};

        HeapSort(numbers);

        /* Print sorted Array */
        System.out.println("\nElements after sorting ");
        for (int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();

    }


    public static void HeapSort(int arr[]) {
        int n = arr.length;

        // Build heap (rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--)
            buildHeap(arr, n, i);

        // One by one extract an element from heap
        for (int i = n-1; i >= 0; i--) {
            // Move current root to end
            swap(arr, 0, i);

            // call max buildHeap on the reduced heap
            buildHeap(arr, i, 0);
        }
    }

    // To buildHeap a subtree rooted with node i which is
    // an index in arr[]. n is size of heap
    private static void buildHeap(int arr[], int n, int i) {
        int largest = i;  // Initialize largest as root
        int left = 2*i + 1;
        int right = 2*i + 2;

        // If left child is larger than root
        if (left < n && arr[left] > arr[largest])
            largest = left;

        // If right child is larger than largest so far
        if (right < n && arr[right] > arr[largest])
            largest = right;

        // If largest is not root
        if (largest != i) {
            swap(arr, i, largest);

            // Recursively buildHeap the affected sub-tree
            buildHeap(arr, n, largest);
        }
    }



    /* Function to swap two numbers in an array */
    public static void swap(int arr[], int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
