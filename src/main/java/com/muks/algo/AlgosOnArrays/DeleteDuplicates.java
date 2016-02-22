package com.muks.algo.AlgosOnArrays;

/**
 * Created by mukthar.ahmed on 2/22/16.
 *
 *  Delete duplicate elements from a int[] in o(1) / o(n) space
 *
 */

public class DeleteDuplicates {

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 2, 2, 3, 4, 5};

        System.out.println("+ Deleted Duplicates: " + deleteDuplicates(arr));

        System.out.println("+ Deleted Spaces: " + DeleteSpaces("I am here"));

    }


    /**
     * Delete duplicate elements from int array using O(1) Space and O(n) time complexity.
     */
    public static String deleteDuplicates(int[] arr) {
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


        StringBuilder sb = new StringBuilder();
        for (int x : arr) {
            sb.append(" " + x);
        }

        return sb.toString();

    }

    public static String DeleteSpaces(String str) {
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

        System.out.println("+ Len = " + spaces);
        charArray[charArray.length - spaces] = '\0';
        StringBuilder sb = new StringBuilder();
        for (char ch : charArray) {
            sb.append(" " + ch);
        }

        return sb.toString();
    }
}