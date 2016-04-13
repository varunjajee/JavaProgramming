package com.muks.Algorithm.AlgosOnArrays.Basics;

/*
 * Created by mukthar.ahmed on 1/22/16.
 */
public class AShiftArrayElements {

    public static void main(String[] args) {
        String url = "www.google.com?a=i w inmobi.com";
        char[] urlarr = url.toCharArray();

        for (int i = 0; i < urlarr.length - 1; i++) {
            urlarr[i+1] = urlarr[i];
        }

        for (char ch : urlarr) {
            System.out.print(" " + ch);
        }
    }
}
