//package com.muks.IntrvAlgorithms.SkyLineNext;
//
///*
// * Created by mukthar.ahmed on 2/2/16.
// */
//
//
//import com.muks.IntrvAlgorithms.SkyLine.Building;
//import com.muks.IntrvAlgorithms.SkyLine.SkyLine;
//import com.muks.IntrvAlgorithms.SkyLine.Strip;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class SkyLineRecursive {
//
//
//    public List<int[]> getSkyline_rec(int low, int high, Building[] buildings) {
//        List<int[]> skyLineList = new ArrayList<>();
//
//        if (low > high) {
//            return skyLineList;
//        }
//        else if (low == high) {
//            int x1, x2, h;
//            x1 = buildings[low].left;
//            x2 = buildings[low].right;
//            h = buildings[low].height;
//
//            int[] element1 = {x1, h};
//            int[] element2 = {x2, 0};
//
//            skyLineList.add(element1);
//            skyLineList.add(element2);
//
//            skyLineList.add(element2);
//            skyLineList.add(0, element1);
//
//            return skyLineList;
//
//        }
//        else {
//            int mid = (low + high)/2;
//            getSkyline_rec(low, mid, buildings);
//            getSkyline_rec(mid+1, high, buildings);
//
//            List<int[]> skylineLeft = getSkyline_rec(low, mid, buildings);
//            List<int[]> skylineRight = getSkyline_rec(mid+1, high, buildings);
//
//            return mergedSkylines(skylineLeft, skylineRight);
//        }
//
//
//    }
//
//
//
//    public static List<int[]> mergedSkylines(List<int[]> left, List<int[]> right) {
//        System.out.println(" --- " + left.toString());
//        System.out.println(right.toString());
//
//
//        return left;
//    }
//
//    public static SkyLine mergedSkylines(SkyLine sl, SkyLine sr) {
//        System.out.println(sl.toString());
//        System.out.println(sr.toString());
//
//        SkyLine res = new SkyLine(sl.arr.length + sr.arr.length);
//
//        // To store current heights of two skylines
//        int h1 = 0, h2 = 0;
//
//        // Indexes of strips in two skylines
//        int i = 0, j = 0;
//
//
//        while (i < sl.arr.length && j < sr.arr.length) {
//
//
//            if (sl.arr[i].left < sr.arr[j].left) {
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
//                int x2 = sr.arr[j].left;
//                h2 = sr.arr[j].height;
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
//        while (j < sr.arr.length) {
//            res.append(sr.arr[j]);
//            j++;
//        }
//
//        return res;
//
//    }
//
//
//
//    public static void main(String[] args) {
//        Building[] buildings = {
//                new Building(1, 5, 11),
//                new Building(2, 7, 6),
//                new Building(3, 9, 13),
//                new Building(12, 16, 7),
//                new Building(14, 25, 3),
//                new Building(19, 22, 18),
//                new Building(23, 29, 13),
//                new Building(24, 28, 4)
//        };
//
//
//        SkyLineRecursive skyLineRecursive = new SkyLineRecursive();
//        SkyLine res = new SkyLine(buildings.length * 2);
//
//        skyLineRecursive.getSkyline_rec(0, buildings.length-1, buildings);
//    }
//
//
//}
