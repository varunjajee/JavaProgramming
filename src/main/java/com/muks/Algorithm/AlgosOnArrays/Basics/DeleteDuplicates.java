package com.muks.Algorithm.AlgosOnArrays.Basics;

/**
 * Created by mukthar.ahmed on 2/22/16.
 *
 *  Delete duplicate elements from a int[] in o(1) / o(n) space
 *
 */

public class DeleteDuplicates {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 4, 5};

        deleteDuplicatesFromSorted(arr);

        //System.out.println("+ Deleted Spaces: " + DeleteSpaces("I am here"));

        String str = "I am here";
        //DeleteFromUnsorted(str);

    }


    /**
     * Delete duplicate elements from int array using O(1) Space and O(n) time complexity.
     */
    public static void deleteDuplicatesFromSorted(int[] arr) {
        int i = 0;
        int j = 1;

        while (j < arr.length) {
            if (arr[i] == arr[j]) {
                j++;
            } else {
                i++;
                arr[i] = arr[j];
                j++;
            }
        }


        /** Limiting the array till 'i' */
        for (int x = 0; x <= i; x++) {
            System.out.print(" " + arr[x]);
        }
    }

    public static void DeleteSpaces(String str) {
        char[] charArray = str.toCharArray();

        int i = 0, j = 1, spaces = 0;
        while (j < charArray.length) {
            if (charArray[j] == ' ') {
                j++;
                spaces++;
            }
            else {
                i++;
                charArray[i] = charArray[j];
                j++;
            }
        }


        for (int x = 0; x <= i; x++) {
            System.out.print(charArray[x]);
        }
    }


    /**
     *  Deleting from un-sorted arrays
     *      - Amongst all the solutions, sorting the array and deleting seems to be tempting
     *      solutions but its NOT.
     *
     *      - Track the repeated elements using hashmap and then print each
     *      non-repeated element
     */
    public static void DeleteFromUnsorted(String str) {
        int[] marker = new int[256];

        char[] myarr = str.toCharArray();
        for (char ch : myarr) {
            marker[ch]++;
        }

        for (char ch : myarr) {
            if (marker[ch] == 1) {
                System.out.print(" " + ch);
            }
        }


    }
}