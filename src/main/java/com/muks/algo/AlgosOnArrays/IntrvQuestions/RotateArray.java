package com.muks.algo.AlgosOnArrays.IntrvQuestions;

/**
 * Created by mukthar.ahmed on 3/8/16.
 *
 * Rotate array in O(n) time and O(1) auxilary space
 */
public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        int offset = 2;

        RotateOptimised(arr, offset);
        //rotateByLeftShit(arr, offset);

        printArray(arr);
    }


    /** ===========================================================================================
     * - pop [0] item,
     * - store it to tmp variable
     * - move all elements towards left
     * - copy the [0] element at the last
     *
     * - Time complexity = O(n * offset)
     * - Space = O(n)
     */
    public static void rotateByLeftShit(int[] arr, int offset) {

        for (int i = 0; i <= offset; i++) {
            int tmp = arr[0];
            System.out.println("+ Pop'd = " + tmp);

            for (int k = 0; k < arr.length - 1; k++) {
                arr[k] = arr[k + 1];
            }

            arr[arr.length - 1] = tmp;
        }
    }


    /** ===========================================================================================
     *  Logic:
     *      Eg: 1, 2, 3, 4, 5, 6, 7
     *      1) divide the array into 2 halves. 0 - offset & (offset + 1) till length.
     *          - [1, 2, 3] & [4, 5, 6, 7]
     *      2) reverse 1st sub array
     *      3) reverse 2nd sub array
     *      4) Now reverse entire array
     *
     *  Time complexity - O(n) & Space O(n), in-place rotation
     */
    public static void RotateOptimised(int[] arr, int offset) {
        if (arr.length == 0 || offset < 0) {
            throw new IllegalArgumentException("Invalid input exception.");
        }

        reverseArray(arr, 0, offset);
        reverseArray(arr, offset + 1, arr.length - 1);
        reverseArray(arr, 0, arr.length - 1);
    }


    /** Reverse array using left pointer and right pointer and recursion */
    public static void reverseArray(int[] arr, int left, int right) {
        if (left > right) {
            return;
        }

        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
        reverseArray(arr, left + 1, right - 1);
    }

    /** Printing the entire array */
    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print( " " + i);
        }
    }
}
