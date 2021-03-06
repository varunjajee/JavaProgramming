package com.muks.Algorithm.AlgoBasics;
import java.util.HashMap;


public class FindMaxOccurrenceByHash {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String str = "abcdaebbaa";
        maxOccurringByHash(str);
        //System.out.println("+++ Max: " + findMax(str, 2) );

    } // lib()


    public static void maxOccurringByHash(String str) {
        int[] arr = new int[256];

        for (char ch : str.toCharArray()) {
            arr[ch]++;
        }

        char maxOccurring = str.charAt(0);
        for (char ch : str.toCharArray()) {
            if (arr[ch] > arr[maxOccurring]) {
                maxOccurring = ch;
            }
        }


        System.out.println("char = " + maxOccurring + ", Occurrence = " + arr[maxOccurring]);
    }



    public static char findMax (String str, int place) {
        int len = str.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i=0; i < len-1; i++) {
            if ( !map.containsKey(str.charAt(i)) ) {
                map.put(str.charAt(i), 1);

            } else {
                map.put(str.charAt(i), (map.get(str.charAt(i)) + 1 ) );

            }

        } // end of for
        System.out.println("Hash Map: \n" + map.toString());



        // Finding out the max occurrence:
        char max = str.charAt(0);
        char sec = str.charAt(1);

        for (char k : map.keySet()) {
            System.out.println( " +++ " + map.get(k) + " > " +  map.get(max) );
            System.out.println( " +++ " + k + " > " +  max );

            if ( map.get(k) > map.get(max) ) {
                sec = max;
                max = k;

            } else if ( map.get(k) > map.get(sec) ) {
                sec = k;

            } else if ( map.get(k) > map.get(sec) ) {
                sec = k;

            }
            System.out.println(" MAX: " + max + " Second: " + sec + "\n");


        }

        System.out.println(" ++++++++ MAX: " + max + " Second: " + sec);
        if ( place == 1 ) {
            return max;

        } else if (place == 2) {
            System.out.println("++ ask for second heighest...");
            return sec;
        }

        return 9999;

    }

}
