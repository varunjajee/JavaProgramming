package com.muks.Algorithm.SortingTechniques;

/**
 * Created by mukthar.ahmed on 3/6/16 -
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {4, 3, 7, 1, 2, 5, 6};

        bubbleSortAlgo(arr);

        for (int i : arr) {
            System.out.print(" " + i);
        }
    }

    private static void bubbleSortAlgo(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i - 1;j++ ) {

                if (arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }

            }
        }
    }
}
