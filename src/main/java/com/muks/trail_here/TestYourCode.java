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
        int[] arr = {2, 1, 9, 3, 4, 6, 0};


        actualInsertion(arr);
        //insertion(arr);

        for (int i : arr) {
            System.out.print(" " + i);
        }
    }


    private static void insertion(int[] arr) {

        int ins;
        for (int i = 0; i < arr.length; i++) {
            ins = 0;

            while (ins != i) {
                if (arr[ins] > arr[i]) {
                    swap(arr, ins, i);
                }
                ins++;
            }
        }
    }

    private static void actualInsertion(int[] arr) {

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i;

            while ((j > 0) && (arr[j-1] > key)) {
                arr[j] = arr[j-1];
                j--;
            }

            arr[j] = key;
        }
    }


    private static void swap(int[] arr, int i, int j) {
        System.out.println("Swaping => [" + i + ", " + j + "] = " + arr[i] + " & " + arr[j]);
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
