package com.muks.algo.SortingTechniques;

/**
 * Created by mukthar.ahmed on 3/5/16.
 */
public class RadixSort {

    public static void main(String[] args) {
        String str = "mukthar";

    }

    /**
     * Radix Sort function
     **/

    public static void sort(int[] a) {
        int i, m = a[0];
        int exp = 1;
        int n = a.length;

        int[] b = new int[10];
        for (i = 1; i < n; i++) {
            if (a[i] > m) {
                m = a[i];
            }
        }

        while (m / exp > 0) {
            int[] bucket = new int[10];

            for (i = 0; i < n; i++) {
                bucket[(a[i] / exp) % 10]++;
            }

            for (i = 1; i < 10; i++) {
                bucket[i] += bucket[i - 1];
            }

            for (i = n - 1; i >= 0; i--) {
                b[--bucket[(a[i] / exp) % 10]] = a[i];
            }

            for (i = 0; i < n; i++) {
                a[i] = b[i];
            }

            exp *= 10;

        }

    }
}
