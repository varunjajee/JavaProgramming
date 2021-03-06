package com.muks.Algorithm.AlgosOnString.Important;

/**
 * Print all the permutations of the given string (abc) or integers (123)
 *  Total permutes will be n! i,e  factorial(n)
 */
public class StringPermutations {

    public static void main(String[] args) {
        String inputStr = "abc";

        new StringPermutations().permute(inputStr.toCharArray());
    }


    private void permute(char[] input) {
        /** iterate from 0 to string length */
        permute(input, 0, input.length - 1);
    }

    private void permute(char[] arr, int start, int end) {
        if (start == end) {
            System.out.println(new String(arr));
        }
        else  {
            for (int i = start; i <= end; i++) {
                swap(arr, start, i);
                permute(arr, start+1, end);
                swap(arr, start, i); /** back track */
            }
        }
    }

    /*
    a b c

     */
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
