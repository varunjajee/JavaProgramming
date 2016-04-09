package com.muks.Algorithm.AlgosOnString;

/**
 * Created by mukthar.ahmed on 4/9/16.
 */
public class DeleteSpaces {
    public static void main(String[] args) {
        String input = "a b  d ef";
        DeleteSpaces(input);
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
}
