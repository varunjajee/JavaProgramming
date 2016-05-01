//package com.muks.Algorithm.AlgoBasics;
//
//import org.testng.annotations.Parameters;
//
///**
// * Created by mukthar.ahmed on 4/18/16.
// */
//public class TryHere {
//
//
//    public static void main(String[] args) {
//
//        String str = "one two three";
//
//        deleteDuplciates(str);
//    }
//
//    private static void deleteSpaces(String input) {
//        char[] arr = input.toCharArray();
//        int i = 0, j = 0;
//        while (j < arr.length) {
//            if (arr[j] == ' ') {
//                j++;
//            }
//            else {
//                i++;
//                arr[i] = arr[j];
//                j++;
//            }
//        }
//        print(arr, 0, arr.length);
//    }
//
//
//    private static void deleteDuplciates(String input) {
//        char[] arr = input.toCharArray();
//
//        boolean[] hash = new boolean[256];
//        int j = 0;
//
//        for (int i = 0; i < arr.length; i++) {
////            if ( !hash[ arr[i] ] ) {
////                hash[arr[i]] = true;
////                arr[j] = arr[i];
////                j++;
////            }
//            if (arr[i] != ' ') {
//                arr[j] = arr[i];
//                j++;
//            }
//
//        }
//
//        print(arr, 0, j);
//
//    }
//
//    private static void print(char[] arr, int start, int end) {
//        System.out.println("");
//        for (int i = start; i < end; i++) {
//            System.out.print(arr[i] + " ");
//        }
//    }
//
//
//
//    private static void swap(char[] arr, int i, int j) {
//        char temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//}
