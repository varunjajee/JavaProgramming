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
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ') {
                arr[j] = arr[i];
                j++;
            }
        }


        for (int x = 0; x < j; x++) {
            System.out.print(arr[x]);
        }


    }
}
