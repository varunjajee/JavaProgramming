package com.muks.algo.DynamicProgramming;

/**
 * Created by mukthar.ahmed on 2/26/16.
 */
public class KMP_PatternSearch {

    /**
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

    /**
     * Compute temporary array to maintain size of suffix which is same as prefix
     * Time/space complexity is O(size of pattern)
     */
    private static int[] computeTemporaryArray(String pattern){
        int [] lps = new int[pattern.length()];
        int index = 0;

        for(int i=1; i < pattern.length();) {
            if(pattern.charAt(i) == pattern.charAt(index)) {
                lps[i] = index + 1;
                index++;
                i++;
            }
            else {
                if (index != 0) {
                    index = lps[index-1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    /**
     * KMP algorithm of pattern matching.
     */
    public static boolean KMP(String text, String pattern){

        int lps[] = computeTemporaryArray(pattern);
        int i=0;
        int j=0;
        while(i < text.length() && j < pattern.length()) {
            if(text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            }
            else {
                if(j != 0) {
                    j = lps[j-1];
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

    public static void main(String args[]){

        String str = "abcxabcdabcdabcy";
        String subString = "abcdabcy";

        boolean result = KMP(str, subString);
        System.out.print(result);

    }
}