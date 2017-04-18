package com.muks.IntrvAlgorithms.DailyHuntQuestions;

/**
 * Created by 300000511 on 11/04/17.
 */


public class Solution {
    public static void main(String[] args) {

        int[] array = {4, 25, 80, 123, 12345, 44, 8, 5};
        int k = 4;

        new Solution().solution(array, k);
    }

    public void solution(int[] A, int K) {
        int maxLength = findMaxLength(A);

        System.out.println("Max len: " + maxLength);

        String finalOutput = "";

        for (int i = 0; i < A.length; i++) {
            String out = "";

            if (i != 0) {
                out += "\n";
            }

            int element = A[i];

            out += ("+");

            for (int j = 1; j <= maxLength; j++) {
                out += ("-");
            }
            out+=("+");
            out+=("\n");
            out+=("|");

            int len = maxLength - findLen(element);
            for (int j = 1; j <= len; j++) {
                out+=(" ");
            }
            out+=(element);
            out+=("|");
            out+=("\n");
            out+=("+");

            for (int j = 1; j <= maxLength; j++) {
                out+=("-");
            }
            out+=("+");


            System.out.print(out.toString());
            //System.out.println("\n\n");
            finalOutput += (out.toString());

        }
        System.out.println("\n\n -----> \n" +  finalOutput.toString());


    }


    private int findMaxLength(int[] array) {
        int maxLen = 0;
        for (int arrElemn : array) {
            int elemnLen = String.valueOf(arrElemn).split("").length;
            if (maxLen < elemnLen) {
                maxLen = elemnLen;
            }
        }

        return maxLen;
    }

    private int findLen(int num) {
        return String.valueOf(num).split("").length;

    }
}
