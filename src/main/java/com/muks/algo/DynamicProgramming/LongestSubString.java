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

public class LongestSubString {

  public static void main(String[] args) {
    String a = "ABCDAF";
    String b = "3BCDF";
    //findLongestSubStr("ababaefabc");

    //findLongestSubStr("ABDEFGABEF");

    LongestCommonSubString(a, b);

  } // main()


  /**
   * Dynamic way of calculating Longest common sub-string
   */
  public static void LongestCommonSubString (String x, String y) {
    int M = x.length();
    int N = y.length();

    int[][] T = new int[M+1][N+1];
    int max = 0;

    for (int i = M-1; i >= 0; i--) {
      for (int j = N-1; j >= 0; j--) {

        if (x.charAt(i) == y.charAt(j)) {
          T[i][j] = T[i+1][j+1] + 1;

          System.out.println(T[i][j]);

          if (max < T[i][j]) {
            max = T[i][j];    // calculating the length of longest sub-string
          }

        }

      }

    }

    // recover LCS itself and print it to standard output
    System.out.println("+ Tracing back the matrix for longest common sub-string ....");
    int i = 0, j = 0;
    while(i < x.length() && j < y.length()) {
      if (x.charAt(i) == y.charAt(j)) {
        System.out.print(x.charAt(i));
        i++;
        j++;
      } else if (T[i+1][j] >= T[i][j+1]) {
        i++;
      } else {
        j++;
      }
    }
    System.out.println();

  }


  /**
   *  A recursive way of finding
   *
   */
  public static void findLongestSubStr (String inputString) {
    System.out.println("+ String: " + inputString);

    HashMap<Character, Integer> map = new HashMap<>();
    String unique = new String();

    ArrayList<String> subStrings = new ArrayList<>();
    String longestSubStr = "";


    for (char c : inputString.toCharArray()) {
      //System.out.println("+ C=" + c + " Count=" );

      if ( map.containsKey(c) ) {
        System.out.println("+ Unique: " + unique + " : 2nd occurrence... +++ \n" );

        subStrings.add(unique);
        longestSubStr = findMax(longestSubStr, unique); // call the method to declare the longest-substr

        unique = Character.toString(c);
        map.clear();
        map.put(c, 1);

        //System.out.println("+ Unique - Post reset(): "  + unique);

      } else {
        //System.out.println("+ 1st occurrence \n Building string: \"" + unique + "\" with \"" + c + "\"\n");
        unique += c;
        map.put(c, 1);

        // In case the longest substring is at end
        if ( c == inputString.charAt(inputString.length()-1)) {
          System.out.println("+ UNIQUE: " + unique);
          subStrings.add(unique);
          longestSubStr = findMax(longestSubStr, unique);	// call the method to declare the longest-substr

        } // if ()

      } // if-else()

    } // for()

    System.out.println("\n+ Sub Strings: " + subStrings.toString());
    System.out.println("+ Longest: " + longestSubStr);

  } // findLongestSubStr()



  public static String findMax (String str1, String str2) {

    if ( str1.length() > str2.length() ) {
      return str1;

    } else if (str1.length() == str2.length() ){
      return str1;

    } else {
      return str2;

    }

  } // findMax()


} // class LongestSubString90

