package com.muks.algo.DynamicProgramming;

/**
 * Created by mukthar.ahmed on 2/26/16.
 */
public class DynProgLongestPalindrome {

    public static int LongestPalindromeDynamic(char[] str) {
        boolean T[][] = new boolean[str.length][str.length];

        for (int i = 0; i < T.length; i++) {
            T[i][i] = true;
        }

        int max = 1;
        for (int l = 2; l <= str.length; l++) {
            int len = 0;
            for (int i = 0; i < str.length - l + 1; i++) {
                int j = i + l - 1;
                len = 0;
                if (l == 2) {
                    if (str[i] == str[j]) {
                        T[i][j] = true;
                        len = 2;
                    }
                } else {
                    if (str[i] == str[j] && T[i + 1][j - 1]) {
                        T[i][j] = true;
                        len = j - i + 1;
                    }
                }
                if (len > max) {
                    max = len;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(LongestPalindromeDynamic("babcbaabcbaccba".toCharArray()));

    }
}
