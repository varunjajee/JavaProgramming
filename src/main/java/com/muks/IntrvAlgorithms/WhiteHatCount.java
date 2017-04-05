package com.muks.IntrvAlgorithms;

import java.util.HashMap;

/**
 * Created by 300000511 on 21/12/16.
 *
 *  http://www.geeksforgeeks.org/program-find-number-persons-wearing-white-hat/
 *
 */
public class WhiteHatCount {

    public static void main(String[] args) {
        int[] arr = {2, 2, 2, 3, 3};
        int n = arr.length;
        System.out.println("=> " + numOfWhiteHats(arr, n));

    }

    private static int numOfWhiteHats(int[] arr, int n) {
        int[] freq = new int[n + 1];

        for (int i = 0; i < n; i++) {
            // Count of White hats cannot be more than
            // n for n persons.
            if (arr[i] >= n)
                return -1;
            freq[arr[i]]++;
        }

        for (int i : freq) {
            System.out.print(i + " ");
        }


        // Counting number of different frequencies
        int diffFreq = 0;
        for (int i = n-1; i >= 0; i--)
            if (freq[i] != -1)
                diffFreq++;

        // Cases where all the persons wearing white hat.
        if (diffFreq == 1 && freq[n-1] == n)
            return n;

        // Case where no one wearing white hat.
        if (diffFreq == 1 && freq[0] == n)
            return 0;

        // Else : number of distinct frequency must be 2.
        if (diffFreq != 2)
            return -1;

        // Finding the last frequency with non zero value.
        // Note that we travers from right side.
        int k;
        for (k = n-1; k >= 1; k--)
            if (freq[k] != -1)
                break;

        // Checking number of k's must be n - k.
        // And number of (k-1)'s must be k.
        if (freq[k-1] == k && freq[k] + k == n)
            return freq[k-1];
        else
            return -1;
    }
}
