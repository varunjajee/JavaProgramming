package com.muks.Algorithm.AlgoBasics;

/**
 * Created by mukthar.ahmed on 4/18/16.
 */
public class TryHere {


    public static void main(String[] args) {
        String str = "aabacdaa";

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

}
