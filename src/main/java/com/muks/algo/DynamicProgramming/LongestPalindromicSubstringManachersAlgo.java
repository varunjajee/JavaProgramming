package com.muks.algo.DynamicProgramming;

/**
 *  Given a string find longest palindromic substring in this string.
 *
 *  Manacher's algorithm to find - longest palindromic substring
 *
 */
public class LongestPalindromicSubstringManachersAlgo {
    /**
      There are 4 cases to handle

     DO NOT proceed if;
      1) Right side palindrome is totally contained under current palindrome.
     
      2) Current palindrome is proper suffix of input. Terminate the loop in this case. No better palindrome
      will be found on right.

      3) Palindrome expands till the right edge and its mirror expands beyond left edge of current palindrome. Do
     not consider this as center because it will not extend at all.


     PROCEED if;
     1) Palindrome expands till the right edge and its mirro palindrome is a proper prefix. Make largest such
     point as
     next center.


     EVEN length input: To handle even  size palindromes replace input string with one containing $ between every input
     character and in start and end.
     */


    public int findLongestPalindrome(char input[]) {
        int index = 0;
        // Add sentinel char likely -> $a$b$c$ to handle even length case.

        char newInput[] = new char[2 * input.length + 1];   // Total size will be 2*n + 1 of this new array.
        for (int i = 0; i < newInput.length; i++) {
            if (i % 2 != 0) {
                newInput[i] = input[index++];
            } else {
                newInput[i] = '$';
            }
        }

        System.out.println("+ NewInput = ");
        printArray(newInput);

        // create temporary array for holding largest palindrome at every point. There are 2*n + 1 such points.
        int T[] = new int[newInput.length];
        int start = 0;
        int end = 0;

        for (int i = 0; i < newInput.length; ) {                    //here i is the center.
            // expand around i. See how far we can go.
            while (start > 0 && end < newInput.length - 1 && newInput[start - 1] == newInput[end + 1]) {
                start--;
                end++;
            }

            // set the longest value of palindrome around center i at T[i]
            T[i] = end - start + 1;

            // Case # 2, Current palindrome is proper suffix of input.
            if (end == T.length - 1) {
                break;
            }

            // Mark newCenter to be either end or end + 1 depending on if we dealing with even or old number input.
            int newCenter = end + (i % 2 == 0 ? 1 : 0);

            for (int j = i + 1; j <= end; j++) {
                //i - (j - i) = left mirror. Its possible left mirror might go beyond current center palindrome. So
                // take minimum of either left side palindrome or distance of j to end.
                T[j] = Math.min(T[i - (j - i)], 2 * (end - j) + 1);
                //Only proceed if we get case 3. This check is to make sure we do not pick j as new center for case 1
                // or case 4. As soon as we find a center lets break out of this inner while loop.
                if (j + T[i - (j - i)] / 2 == end) {
                    newCenter = j;
                    break;
                }
            }
            //make i as newCenter. Set right and left to at least the value we already know should be matching based
            // of left side palindrome.
            i = newCenter;
            end = i + T[i] / 2;
            start = i - T[i] / 2;
        }

        //find the max palindrome in T and return it.
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < T.length; i++) {
            int val = T[i] / 2;
            if (max < val) {
                max = val;
            }
        }
        return max;
    }




    private void printArray(char[] arr) {
        for (char i : arr) {
            System.out.print(" " + i);
        }
    }

    public static void main(String args[]) {
        LongestPalindromicSubstringManachersAlgo lps = new LongestPalindromicSubstringManachersAlgo();
        //System.out.println(lps.findLongestPalindrome("abba".toCharArray()));
        //System.out.println(lps.findLongestPalindrome("abbababba".toCharArray()));
        System.out.println("\nLongest palindrome size = " +
            lps.findLongestPalindrome("babcbaabcbaccba".toCharArray()));
//        System.out.println(lps.findLongestPalindrome("cdbabcbabdab".toCharArray()));
    }

}
