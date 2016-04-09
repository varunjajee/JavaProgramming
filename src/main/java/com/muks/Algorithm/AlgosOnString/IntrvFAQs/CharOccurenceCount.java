package com.muks.Algorithm.AlgosOnString.IntrvFAQs;

/**
 * Created by mukthar.ahmed on 4/9/16.
 *
 * Amazon/Microsoft Question:
 *      Given a string with repeated chars, eg: aabbcccddeeee, print the char count with char
 *      Output: 2a 2b 3c 2d 4e
 *
 */
public class CharOccurenceCount {

    public static void main(String[] args) {
        String str = "aabbccddde";
        charOccurenceCount(str);
    }

    private static void charOccurenceCount(String input) {
        int[] charCounter = new int[256];   /** java data structure to hold char info as int count */

        for (char ch : input.toCharArray()) {
            charCounter[ch]++;
        }

        String uniq = getUniqChars(input);
        for (char ch : uniq.toCharArray()) {
            System.out.print(" " + charCounter[ch] + ch);
        }
    }


    private static String getUniqChars(String input) {
        StringBuilder sb = new StringBuilder();

        boolean[] flag = new boolean[256];  /** Special java data structure to hold char info */
        for (char ch : input.toCharArray()) {
            if ( !flag[ch] ) {
                sb.append(ch);
                flag[ch] = true;
            }
        }

        System.out.println("# De dup = " + sb.toString());
        return sb.toString();
    }
}
