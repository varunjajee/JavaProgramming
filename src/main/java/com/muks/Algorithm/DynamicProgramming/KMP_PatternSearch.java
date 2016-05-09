package com.muks.Algorithm.DynamicProgramming;

/**
 * Created by mukthar.ahmed on 2/26/16.
 */
public class  KMP_PatternSearch {
    public static void main(String args[]){

        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";

        boolean result = KMP(str, subString);
        System.out.print(result);

    }

    /** =============================================================================================
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     */
    private static int[] computeTemporaryArray(String pattern){
        int[] Table = new int[pattern.length()];

        int j = 0;
        int i = 1;

        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                Table[i] = j + 1;
                j++;
                i++;
            }
            else {
                if (j != 0) {
                    j = Table[j-1];
                } else {
                    Table[i] = 0;
                    i++;
                }
            }
        }
        return Table;
    }

    /**
     * KMP algorithm of pattern matching.
     */
    public static boolean KMP(String text, String pattern){

        int Table[] = computeTemporaryArray(pattern);
        int i=0;
        int j=0;
        while(i < text.length() && j < pattern.length()) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            else {
                if(j != 0) {
                    j = Table[j-1];
                } else {
                    i++;
                }
            }
        }
        if(j == pattern.length()) {
            return true;
        }
        return false;
    }


    /** =============================================================================================
     * Slow method of pattern matching
     */
    public static boolean hasSubstring(String text, String pattern){
        int i=0;
        int j=0;
        int k = 0;
        while(i < text.length() && j < pattern.length()){
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            else {
                j=0;
                k++;
                i = k;
            }
        }
        if(j == pattern.length()){
            return true;
        }
        return false;
    }

}