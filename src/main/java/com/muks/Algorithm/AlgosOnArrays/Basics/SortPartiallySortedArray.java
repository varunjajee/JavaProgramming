package com.muks.Algorithm.AlgosOnArrays.Basics;

public class SortPartiallySortedArray {

    /**
     * In place sorting of a partially sorted array
     */
    public static void main(String[] args) {
        //int[] arr = {1, 4, 5, 7, 8, 9, 2, 3, 6, 10, 11};
        int[] arr = {7, 8, 9, 10, 11, 1, 2, 3, 4, 5, 6,};
        sort(arr);

        String s = "";
        for (int i : arr) {
            s += i + " ";
        }
        System.out.println(s);
    }


    public static void sort(int[] a) {
        int i = 0;
        int j = a.length - 1;

        // find beginning of second sub-array
        while ( i < j ) {
            if (a[j] < a[j-1]) {
                break;
            }
            j--;
        }


        while (j != a.length && i != a.length) {
            if (a[i] < a[j]) {
                i++;
            } else {
                System.out.println(a[i] + " < " + a[j]);
                swap(a, i, j);
                j++;
            }
        }
    }

    public static void swap(int[] a, int l, int r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }


}
