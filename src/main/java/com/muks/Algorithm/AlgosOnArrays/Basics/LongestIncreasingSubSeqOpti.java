package com.muks.Algorithm.AlgosOnArrays.Basics;

/**
 * Created by mukthar.ahmed on 5/9/16.
 */
public class LongestIncreasingSubSeqOpti {

    public static void main(String[] args) {
        int arr[] = {1, 2, 5, 9, 16};
        byBinarySearch(arr);
    }

    private static int binarySearch(int table[], int curr, int len) {

        int end = len - 1;
        int start = 0;
        int mid = 0;

        int result = -1;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (table[mid] < curr) {
                start = mid + 1;
                result = mid;
            } else if (table[mid] == curr) {
                return len - 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }

    private static void byBinarySearch(int[] arr) {
        int table[] = new int[arr.length];

        table[0] = arr[0];
        int len = 1;

        for (int i = 1; i < arr.length; i++) {
            if (table[0] > arr[i]) {
                table[0] = arr[i];
            } else if (table[len - 1] < arr[i]) {
                table[len++] = arr[i];
            } else {
                table[binarySearch(table, arr[i], len) + 1] = arr[i];
            }
        }

        System.out.println("# By binary search = " + len);
    }
}
