package com.muks.Algorithm.AlgosOnArrays.Basics;

/**
 * Created by mukthar.ahmed on 3/8/16.
 *
 *  Q1 - Given a rotated array, find the pivotal point of rotation
 *  Q2 - Find a element/value from a rotated array.
 *
 */


public class RotatedArrayFind {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 8, 9, 1, 2, 3};

        System.out.println("+ Is Rotated @ index = " + findRotationPivot(arr));

        FindElementFromRotated(arr, 4, findRotationPivot(arr));
    }

    public static int findRotationPivot(int[] arr) {
        if (arr.length <= 0) {
            return 0;
        }
        else {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > arr[i + 1]) {
                    return i;
                }
            }
        }

        return 0;
    }

    public static void FindElementFromRotated(int[] arr, int val, int offset) {
        if (val >= arr[0] & val <= arr[offset]) {
            binarySearch(arr, 0, offset, val);
        }
        else {
            binarySearch(arr, offset+1, arr.length-1, val);
        }
    }

    public static void binarySearch(int[] arr, int low, int high, int val) {
        if (low > high) {
            return;
        }
        else {
            int mid = low + (high - low)/2;

            if (arr[mid] == val) {
                System.out.println("+ Found @ index = " + mid);
                return;
            }
            else if (val < arr[mid]) {
                binarySearch(arr, 0, mid-1, val);
            }
            else {
                binarySearch(arr, mid + 1, arr.length-1, val);
            }
        }
    }
}
