package com.muks.algo.DynamicProgramming;

import java.util.ArrayList;
import java.util.HashMap;

// http://www.ritambhara.in/longest-substring-of-unique-characters/

/*
 * Q: Find the longest substring having non-repated characters
 *
 *  Difference between sub-string and sub-sequence is the ordering of char occurrence.
 *
 *  If they occur, side-by-side then its a sub-string but if not next to each other rather
 *  occurring in the same order is called sub-sequence
 */

public class LongestCommonSubString {

    public static void main(String[] args) {
        String a = "ABCDAF";
        String b = "3BCDF";

        LongestCommonSubString(a, b);

    } // main()


    public static void LongestCommonSubString(String x, String y) {
        int M = x.length();
        int N = y.length();

        int[][] T = new int[M + 1][N + 1];

        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {
                if (x.charAt(i) == y.charAt(j)) {
                    T[i][j] = T[i + 1][j + 1] + 1;
                } else {
                    T[i][j] = 0;
                }
            }
        }

        MatrixUtils.printMatrix(T); /** Printing the matrix */
        int result = -1;
        for (int i = 0; i <= x.length(); i++) {
            for (int j = 0; j <= y.length(); j++) {
                if (result < T[i][j]) {
                    result = T[i][j];
                }
            }
        }

        int i = 0, j = 0;
        String longest = "";
        while (i < M & j < N) {
            /** break out when we have found a string of the max length */
            if (x.charAt(i) == y.charAt(j) ) {
                if (longest.length() == result) {
                    break;
                }

                longest += x.charAt(i);

                i++;
                j++;
            } else if (T[i + 1][j] > T[i][j]) {
                i++;
            } else {
                j++;
            }
        }

        System.out.println("\n+ Longest Common Sub String = " + longest);


    }






    /**
     * A recursive way of finding
     * Finding longest substring from a string having unique chars
     */
    public static void findLongestSubStr(String inputString) {
        System.out.println("+ String: " + inputString);

        HashMap<Character, Integer> map = new HashMap<>();
        String unique = new String();

        ArrayList<String> subStrings = new ArrayList<>();
        String longestSubStr = "";


        for (char c : inputString.toCharArray()) {

            if (map.containsKey(c)) {
                System.out.println("+ Unique: " + unique + " : 2nd occurrence... +++ \n");

                subStrings.add(unique);
                longestSubStr = findMax(longestSubStr, unique); // call the method to declare the longest-substr

                unique = Character.toString(c);
                map.clear();
                map.put(c, 1);

            } else {
                unique += c;
                map.put(c, 1);

                // In case the longest substring is at end
                if (c == inputString.charAt(inputString.length() - 1)) {
                    System.out.println("+ UNIQUE: " + unique);
                    subStrings.add(unique);
                    longestSubStr = findMax(longestSubStr, unique);    // call the method to declare the longest-substr

                } // if ()

            } // if-else()

        } // for()

        System.out.println("\n+ Sub Strings: " + subStrings.toString());
        System.out.println("+ Longest: " + longestSubStr);

    } // findLongestSubStr()


    public static String findMax(String str1, String str2) {

        if (str1.length() > str2.length()) {
            return str1;

        } else if (str1.length() == str2.length()) {
            return str1;

        } else {
            return str2;

        }

    } // findMax()


} // class LongestSubString90

