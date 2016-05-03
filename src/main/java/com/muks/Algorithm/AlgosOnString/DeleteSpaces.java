package com.muks.Algorithm.AlgosOnString;

/**
 * Created by mukthar.ahmed on 4/9/16.
 */
public class DeleteSpaces {
    public static void main(String[] args) {
        String input = "one two    three";

        DeleteSpaces(input);
    }


    public static void DeleteSpaces(String str) {
        char[] arr = str.toCharArray();

        int j = 0;      // copy index
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] != ' ') {
//                arr[j] = arr[i];
//                j++;
//            }
//        }
        int i = 0;
        while (i < arr.length) {
            if (arr[i] != ' ') {
                arr[j] = arr[i];
                j++;
            }
            i++;
        }

        arr[j] = '\0';

        for (int k = 0; k < j; k++) {
            System.out.print(" " + arr[k]);
        }

    }
}
