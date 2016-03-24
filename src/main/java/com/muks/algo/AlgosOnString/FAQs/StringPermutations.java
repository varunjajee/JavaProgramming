package com.muks.algo.AlgosOnString.FAQs;

/**
 * Print all the permutations of the given string (abc) or integers (123)
 */
public class StringPermutations {

    public static void main(String[] args) {
        String inputStr = "abc";

        permute(inputStr.toCharArray());
    }


    static void permute(char[] input) {
        permute(input, 0, input.length - 1);
    }


    static void permute(char[] a, int start, int end) {
        if (start == end) {
            printArray(a);
        }
        else  {
            for (int i = start; i <= end; i++) {
                swap(a, start, i);
                permute(a, start+1, end);
                swap(a, start, i); /** back track */
            }
        }
    }

    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void printArray(char[] arr) {
        StringBuilder sb = new StringBuilder();
        for (char ch : arr) {
            sb.append(" " + ch);
        }
        System.out.println(sb.toString());
    }
}
