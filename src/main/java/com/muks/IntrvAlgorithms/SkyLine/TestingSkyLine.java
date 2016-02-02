package com.muks.IntrvAlgorithms.SkyLine;


/*
 * Created by mukthar.ahmed on 1/29/16.

    Ref # 1: http://www.geeksforgeeks.org/divide-and-conquer-set-7-the-skyline-problem/
    Ref # 2: http://sandrasi-sw.blogspot.in/2012/12/the-skyline-problem.html

 */

public class TestingSkyLine {
    public static void main(String[] args) {
        Building buildings[] = {
                new Building(1, 5, 11),
                new Building(2, 7, 6),
                new Building(3, 9, 13),
                new Building(12, 16, 7),
                new Building(14, 25, 3),
                new Building(19, 22, 18),
                new Building(23, 29, 13),
                new Building(24, 28, 4)
        };


        for (int i = 0; i < buildings.length; i++) {
            System.out.print(" " + buildings[i]);
        }
        System.out.println("\n");


        //ToDo: findSkyline() - hits null pointer at a point where it is trying to merge strips
        SkyLine res = new SkyLine(16);
        SkyLine.findSkyline(buildings);
    }

}
