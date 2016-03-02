package com.muks.algo.DynamicProgramming;

import com.sun.tools.doclets.formats.html.SourceToHTMLConverter;

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

public class LongestSubString {

    public static void main(String[] args) {
        String a = "ABCDAF";
        String b = "3BCDF";
        //findLongestSubStr("ababaefabc");

        //findLongestSubStr("ABDEFGABEF");


        //LongestCommonSubString(a, b);
        LongestCommonSubStr(a, b);

    } // main()


    public static void LongestCommonSubStr(String x, String y) {
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
     * Dynamic way of calculating Longest common sub-string
     */
    public static void LongestCommonSubString(String x, String y) {
        int M = x.length();
        int N = y.length();

        int[][] T = new int[M + 1][N + 1];
        int max = 0;

        for (int i = M - 1; i >= 0; i--) {
            for (int j = N - 1; j >= 0; j--) {

                if (x.charAt(i) == y.charAt(j)) {
                    T[i][j] = T[i + 1][j + 1] + 1;

                    System.out.println(T[i][j]);

                    if (max < T[i][j]) {
                        max = T[i][j];    // calculating the length of longest sub-string
                    }

                }

            }

        }

        System.out.println("+ Longest Common Substring is of length = " + max);

        /** Start from the right-most-bottom-most corner and one by one store characters in lcs[] */
        String res = "";
        int i = x.length() - 1, j = y.length() - 1;
        while (i > 0 && j > 0) {
            // If current character in X[] and Y are same, then current character is part of LCS
            if (x.charAt(i) == y.charAt(j)) {
                res += x.charAt(i);
                i--;
                j--;
            }

            // If not same, then find the larger of two and
            // go in the direction of larger value
            else if (T[i - 1][j] > T[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }

        System.out.println("+ Final String: " + res);

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

