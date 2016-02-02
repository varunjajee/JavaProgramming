//package com.muks.IntrvAlgorithms.SkyLineNext;
//
//import com.muks.IntrvAlgorithms.SkyLine.Building;
//import com.muks.IntrvAlgorithms.SkyLine.SkyLine;
//import com.muks.IntrvAlgorithms.SkyLine.Strip;
//
///*
// * Created by mukthar.ahmed on 1/29/16.
//
//    Ref # 1: http://www.geeksforgeeks.org/divide-and-conquer-set-7-the-skyline-problem/
//    Ref # 2: http://sandrasi-sw.blogspot.in/2012/12/the-skyline-problem.html
//
// */
//
//
//public class SkylineProblem {
//
//   // This function returns skyline for a given array of buildings
//    // arr[low..high].  This function is similar to mergeSort().
//    SkyLine findSkyline(Building[] arr, int low, int high, SkyLine res) {
//
//        if (low > high) {
//             return res;
//        }
//
//        /* The base case is trivial, every building can be converted into a skyline: given B(l, r,
//                h) the skyline is P(l, h), P(r, 0). */
//        if (low == high) {
//            res = new SkyLine(2);
//            System.out.println("\nLOW = " + low + ", High = " + high + ", Sky : " + arr[low].toString());
//
//            res.append(new Strip(arr[low].left, arr[low].height));
//            res.append(new Strip(arr[low].right, 0));
//
//            return res;
//        }
//
//        int mid = (low + high)/2;
//
//        SkyLine sl = findSkyline(arr, low, mid, res);
//        SkyLine sr = findSkyline(arr, mid+1, high, res);
//
//        return Merge(sl, sr);
//
////
////        // To avoid memory leak
////        delete sl;
////        delete sr;
//
////        // Return merged skyline
////        return res;
//    }
//
//
//    // Similar to merge() in MergeSort
//    // This function merges another skyline 'other' to the skyline
//    // for which it is called.  The function returns pointer to
//    // the resultant skyline
//    SkyLine Merge(SkyLine sl, SkyLine other) {
//        // Create a resultant skyline with capacity as sum of two
//        // skylines
//        SkyLine res = new SkyLine(sl.arr.length + other.arr.length);
//
//        // To store current heights of two skylines
//        int h1 = 0, h2 = 0;
//
//        // Indexes of strips in two skylines
//        int i = 0, j = 0;
//
//
//        while (i < sl.arr.length && j < other.arr.length) {
//
//
//            if (sl.arr[i].left < other.arr[j].left) {
//                int x1 = sl.arr[i].left;
//                h1 = sl.arr[i].height;
//
//                // Choose height as max of two heights
//                int maxh = Math.max(h1, h2);
//
//                res.append(new Strip(x1, maxh));
//                i++;
//            }
//            else {
//                int x2 = other.arr[j].left;
//                h2 = other.arr[j].height;
//                int maxh = Math.max(h1, h2);
//                res.append(new Strip(x2, maxh));
//                j++;
//            }
//        }
//
//        // If there are strips left in this skyline or other
//        // skyline
//        while (i < sl.arr.length){
//            res.append(sl.arr[i]);
//            i++;
//        }
//        while (j < other.arr.length) {
//            res.append(other.arr[j]);
//            j++;
//        }
//        return res;
//    }
//
//
//    public void DrawSkyline() {
//        Building buildings[] = {
//                new Building(1, 11, 5),
//                new Building(2, 6, 7),
//                new Building(3, 13, 9),
//                new Building(12, 7, 16),
//                new Building(14, 3, 25),
//                new Building(19, 18, 22),
//                new Building(23, 13, 29),
//                new Building(24, 4, 28) };
//
//
//        int n = buildings.length;
//
//        // Find skyline for given buildings and print the skyline
//        System.out.println("+ 0 " + buildings[n-1].toString());
//
//
//        SkyLine ptr = findSkyline(buildings, 0, n-1, new SkyLine(16));
//        System.out.println(" Skyline for given buildings is \n");
//        ptr.toString();
//    }
//
//
//    public void printArray(Strip[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(" (" + arr[i].left + ", " + arr[i].height + ")");
//        }
//
//    }
//    public static void main(String[] args) {
//        SkylineProblem skylineProblem = new SkylineProblem();
//        skylineProblem.DrawSkyline();
//    }
//}   // end SkyelineProblem()
