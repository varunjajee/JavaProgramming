package com.muks.trail_here;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Testing {
    public static int stackdepth = 0;
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 2, 5, 6, 7, 5,8));

        remove(arr);


    }


    public static void remove(List<Integer> arr) {
//        int runner;
//        int current = 0;
//
//        while (current < arr.size()) {
//            runner = current + 1;
//
//            while (runner < arr.size()) {
//                if (arr.get(current) == arr.get(runner)) {
//                    System.out.println("+ found duplicate...");
//                    arr.remove(runner);
//                }
//
//                runner++;
//            }
//
//            current++;
//        }

        for (int i : arr) {
            System.out.print(" " + i);
        }
    }

}