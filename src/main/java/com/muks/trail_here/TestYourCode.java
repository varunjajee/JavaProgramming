package com.muks.trail_here;

import com.muks.Algorithm.MyUtils;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * Created by mukthar.ahmed on 4/6/16.
 */
public class TestYourCode {
    public static void main(String[] args) {
        String str = "a bc de f  g";
        deleteSpaces(str);
    }

    private static void deleteSpaces(String str) {
        char[] arr = str.toCharArray();

        int i = 0, j = 1;

        while (j < arr.length) {
            if (arr[j] == ' ') {
                j++;
            }
            else {
                i++;
                arr[i] = arr[j];
                j++;
            }
        }

        for (int x = 0; x <= i; x++) {
            System.out.print(arr[x]);
        }

    }




}
