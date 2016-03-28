package com.muks.Algorithm.AlgosOnString;

/**
 * Created by mukthar.ahmed on 25/11/14.
 */
public class FindMaxOccurChar {

    public static void main(String[] args) {
        findMaxOccurChar("this is me here and now");

    }

    // Using javapack DSC:
    private static void findMaxOccurChar (String input) {
        System.out.println("+ Finding max occuring char by using java DSC.");

        char[] inChars = input.toCharArray();
        int charCounter[] = new int[256];

        for (char c : inChars) {
            if (c != ' ') {
                charCounter[c]++;
            }
        }

        char maxC = inChars[0];
        for (char c : inChars) {
            System.out.println(" C = " + c + " - " + charCounter[c]
                    + ", maxC = " + maxC + " - " + charCounter[maxC]);
            if (charCounter[c] > charCounter[maxC]) {
                maxC = c;
            }
        }
        System.out.println("+ Char = " + maxC);

    }
}
