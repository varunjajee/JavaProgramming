package com.muks.Algorithm.AlgosOnArrays.SlidingOrMovingWindow;

/**
 * Created by mukthar.ahmed on 4/10/16.
 *
 *  - Find the missing element in arithmetic progression.
 *
 *  Arithmetic progression is the number series where the difference between consecutive
 *  number is a constant
 *  Eg: 2, 4, 6, 7 or 1,2,3,4...
 */
public class MissingElementFromAP {

    public static void main(String[] args) {
        int[] arr1 = {4, 6, 8, 10, 12, 14};
        int[] arr2  = {1, 6, 11, 16, 21, 31};
        int[] arr3 = {1, 3, 4, 5, 6, 7};

        findMissingElement(arr1);


        int a[] = { 0, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 18, 20, 21, 23 };
        //allMissingElements(a);
    }

    /**
     *      Logic:
     *          Find diff = ( A[n-1] - A[0] ) / n
     *              => (n-1)th element - 0th element / n
     *
     */
    private static void findMissingElement(int[] arr) {

        int n = arr.length;
        int diff = (arr[n-1] - arr[0]) / n;

        System.out.println("# Missing element = " +
            findMissingUtil(arr, 0, arr.length-1, diff)
        );
    }


    /**
     *      *  Finding missing element:
     *      if A[mid+1] - A[mid] != diff, then found as A[mid] + diff
     *
     *      if A[mid] - A[mid-1] != diff, then found as A[mid-1] + diff;
     *
     *      if A[mid] = A[0] + (mid x diff); then find it in right half
     *          else
     *      recurse in left half
     */
    private static int findMissingUtil(int[] arr, int start, int end, int diff) {
        /** base case */
        if (start >= end) {
            return Integer.MAX_VALUE;
        }

        int mid = start + (end - start)/2;

        if (arr[mid+1] - arr[mid] != diff) {
            System.out.println("# mid = " + arr[mid] + " - " + arr[(mid+1)] + "= " + diff );
            return (arr[mid] + diff);
        }

        if (mid > 0 && arr[mid] - arr[mid-1] != diff) {
            return (arr[mid - 1] + diff);
        }


        System.out.println(arr[mid] + " == " + arr[0] + (mid * diff));
        if (arr[mid] == arr[0] + (mid * diff) ) {       /** search in the right half */
            return findMissingUtil(arr, mid + 1, end, diff);
        }

        /** Else recur for left half    */
        return findMissingUtil(arr, start, mid-1, diff);

    }


    public static void allMissingElements(int values[]) {
        allMissingElements(values, 0, 0);
    }

    private static void allMissingElements(int[] arr, int position, int count) {
        boolean foundMissingNumber = false;
        if (position == arr.length - 1)
            return;

        for (; position < arr[arr.length - 1]; position++) {

            if ( ( arr[position] - count) != position ) {
                System.out.println("Missing Number: " + (position + count));
                foundMissingNumber = true;
                count++;
                break;
            }
        }

        if (foundMissingNumber) {
            allMissingElements(arr, position, count);
        }
    }
}

