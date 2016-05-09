package com.muks.Algorithm.DynamicProgramming;

/**
 *  Given a string find longest palindromic substring in this string.
 *
 *  Manacher_Ignore's algorithm to find - longest palindromic substring
 *
 */
public class Longest_PalindromicSubStrManachers {
    /**
      There are 4 cases to handle

      Linear time Manacher's algorithm to find longest palindromic substring.
      There are 4 cases to handle
      Case-1 : Right side palindrome is totally contained under current palindrome - Do not consider this as center

      Case-2 : Current palindrome is proper suffix of input. Terminate the loop in this case. No better palindrom
      will be found on right.

      Case 3 : Right side palindrome is proper suffix and its corresponding left side palindrome is proper prefix
      of current palindrome. Make largest such point as next center.

      Case 4 : Right side palindrome is proper suffix but its left corresponding palindrome is be beyond current
      palindrome. Do not consider this as center because it will not extend at all.


     EVEN length input: To handle even  size palindromes replace input string with one containing $ between every input
     character and in start and end.
     */


    private static char[] processString(char[] input) {
        // Add sentinel char likely -> $a$b$c$ to handle even length case.
        int index = 0;
        char newInput[] = new char[2 * input.length + 1];   // Total size will be 2*n + 1 of this new array.
        for (int i = 0; i < newInput.length; i++) {
            if (i % 2 != 0) {
                newInput[i] = input[index++];
            } else {
                newInput[i] = '#';
            }
        }

        return newInput;
    }

    public static String FindLongstPalindromicSubStr(String inStr) {
        char input[] = inStr.toCharArray();

        char[] newInput = processString(input);

        System.out.println("+ NewInput = ");
        printArray(newInput);

        // create temporary array for holding largest palindrome at every point. There are 2*n + 1 such points.
        int table[] = new int[newInput.length];

        int start = 0;
        int end = 0;

        for (int i = 0; i < newInput.length; ) {                    // here i is the center.
            // expand around i. See how far we can go.
            while (start > 0 && end < newInput.length - 1 && newInput[start - 1] == newInput[end + 1]) {
                start--;
                end++;
            }

            // set the longest value of palindrome around center i at table[i]
            table[i] = end - start + 1;

            // Case # 2, Current palindrome expands till the end of the input.
            if (end == table.length - 1) {
                break;
            }

            // Mark newCenter to be either end or end + 1 depending on if we dealing with even or odd index Id
            int newCenter = end + (i % 2 == 0 ? 1 : 0);

            for (int j = i + 1; j <= end; j++) {
                /**         i - (j - i) = left mirror.
                 *          2 * (end - 1) + 1 = distance of j to end
                 *
                 *    Its possible left mirror might go beyond current center palindrome.
                 *    So take minimum of either left side palindrome or distance of j to end.
                 */
                int mirrorLeft = table[i - (j - i)];
                int distanceOf_J = 2 * (end - j) + 1;

                table[j] = Math.min( mirrorLeft, distanceOf_J );

                /** Choice of next center : If the palindrome expands at least till the right edge */
                if (j + table[i - (j - i)] / 2 == end) {
                    newCenter = j;
                    break;
                }
            }
            //make i as newCenter. Set right and left to at least the value we already know should be matching based
            // of left side palindrome.
            i = newCenter;
            end = i + table[i] / 2;
            start = i - table[i] / 2;

            System.out.println(table[i]);

        }

        printIntArray(table);

        return getPalindromicString(inStr, table);
    }


    // longest palindromic substring
    public static String getPalindromicString(String inStr, int[] p) {
        int length = 0;   // length of longest palindromic substring
        int center = 0;   // center of longest palindromic substring
        for (int i = 1; i < p.length-1; i++) {
            if (p[i] > length) {
                length = p[i];
                center = i;
            }
        }

        center = center/2;
        length = length/2;
        System.out.println("+ Center : " + center + ", Length = " + length);

        int mirrorIndex = 1;
        String res = String.valueOf(inStr.charAt(center));

        while (res.length() != length) {
            res = inStr.charAt(center - mirrorIndex) + res;
            res = res + inStr.charAt(center + mirrorIndex);
        }

        return res;
    }



    private static void printIntArray(int[] arr) {
        for (int i : arr) {
            System.out.print(" " + i);
        }
        System.out.println("");
    }
    private static void printArray(char[] arr) {
        for (char i : arr) {
            System.out.print(" " + i);
        }
    }



    public static void main(String args[]) {
        String str0 = "caba";
        String str1 = "abaaba";
        String str2 = "babcbaabcbaccba";

        String palindromicSubStr = FindLongstPalindromicSubStr(str0);

        System.out.println("\nLongest Palindrome = " + palindromicSubStr
            + " of size = " + palindromicSubStr.length());
    }

}
