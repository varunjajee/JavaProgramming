package com.muks.IntrvAlgorithms.SkylineProblem;


import java.util.ArrayList;
import java.util.List;

/*
 * Created by mukthar.ahmed on 2/10/16.
 */
public class SkylineSolution {

    static int counter = 0;

    public static List<int[]> getSkyline(int[][] buildings) {
        return getSkyline(0, buildings.length-1, buildings);
    }

    public static void main(String[] args) {
        int[][] buildings = { {1, 5, 11},
                {2, 7, 6},
                {3, 9, 13},
                {12, 16, 7},
                {14, 25, 3},
                {19, 22, 18},
                {23, 29, 13},
                {24, 28, 4}
        };

        List<int[]> skyLine = getSkyline(buildings);

        System.out.println("Skyline for given buildings would look like: " );
        for (int i = 0;  i < skyLine.size(); i++) {
            System.out.print(" (" + skyLine.get(i)[0]+"," +skyLine.get(i)[1] + ")");
        }
    }

    /* Get greator from two values */
    private static int greater(int a, int b) {
        if (a > b) return a;
        return b;
    }


    /* Split entire buildins into smaller skylines using merge sort algorithm */
    private static List<int[]> getSkyline(int low, int high, int[][]buildings) {
        List<int[]> skyLineList = new ArrayList<>();

        if (low > high) {
            return skyLineList;
        }
        else if (low == high) {
            int x1 = buildings[low][0];
            int x2 = buildings[low][1];
            int h  = buildings[low][2];

            int[] element1 = {x1, h};
            int[] element2 = {x2, 0};

            skyLineList.add(element1);
            skyLineList.add(element2);

            return skyLineList;
        }
        else {
            int mid = (low + high) / 2;

            List<int[]> skylineListLower = getSkyline(low, mid, buildings);

            List<int[]> skylineListHigher = getSkyline(mid+1, high, buildings);

            return mergeSkylines(skylineListLower, skylineListHigher);
        }

    }


    /* Merge two list of int[] */
    private static List<int[]> mergeSkylines(
            List<int[]> skylineListLower, List<int[]> skylineListHigher ) {

        counter++;

        int h1 = 0, h2 = 0;
        int newIndex = 0;
        int x1, x2;

        List<int[]> skylineMerged = new ArrayList<int[]>();;

        System.out.println("+ Counter = " + counter);
        System.out.println("+ Lower = " + printList(skylineListLower));
        System.out.println("+ Higher = " + printList(skylineListHigher));

        while (true) {
            if (skylineListLower.isEmpty() || skylineListHigher.isEmpty()) {
                break;
            }

            int [] strip1 = skylineListLower.get(0);
            int [] strip2 = skylineListHigher.get(0);
            System.out.println("\n+ Strip-1: " + printArray(strip1) );
            System.out.println("+ Strip-2: " + printArray(strip2) );


            int [] mergedStrip = new int[2];

            if (strip1[0] < strip2[0]) {
                x1 = strip1[0];
                h1 = strip1[1];

                // Height of the current strip will always be the max of two heights
                h1 = Math.max(h1, h2);

                mergedStrip[0] = x1;
                mergedStrip[1] = h1;

                skylineListLower.remove(0);     // remove the element/strip from the list
            }
            else if (strip2[0] < strip1[0]) {
                x2 = strip2[0];
                h2 = strip2[1];

                // Height of the current strip will always be the max of two heights
                h2 = Math.max(h1, h2);

                mergedStrip[0] = x2;
                mergedStrip[1] = h2;

                skylineListHigher.remove(0);    // remove the element/strip from the list
            }
            else {          // if both x-cordinates are same
                mergedStrip[0] = strip2[0];
                mergedStrip[1] = Math.max(strip1[1], strip2[1]);

                h1 = strip1[1];
                h2 = strip2[1];

                skylineListLower.remove(0);
                skylineListHigher.remove(0);
            }

            skylineMerged.add(mergedStrip);
        }

        // Adding the rest of the list beyond the conditional validations as above
        if (skylineListLower.isEmpty()) {
            while ( !skylineListHigher.isEmpty() ) {
                skylineMerged.add(skylineListHigher.remove(0));
            }
        }
        else {
            while ( !skylineListLower.isEmpty() ) {
                skylineMerged.add(skylineListLower.remove(0));
            }
        }


        // Get rid of duplicate/redundant: Remove duplicates, remove teh strip having same heights
        int runner;
        int current = 0;

        while (current < skylineMerged.size()) {
            runner = current + 1;

            while (runner < skylineMerged.size()) {
                if (skylineMerged.get(current)[1] == skylineMerged.get(runner)[1]) {
                    skylineMerged.remove(runner);
                }

                runner++;
            }

            current++;
        }

        return skylineMerged;
    }



    /* Helper methods() */
    private static String printArray(int[] arr) {
        StringBuilder sb = new StringBuilder("(");
        for (int i = 0; i < arr.length; i++) {
            sb.append(" " + arr[i]);
        }
        sb.append(")");
        return sb.toString();
    }

    private static String printList(List<int[]> myList) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < myList.size(); i++) {
            sb.append(" " + printArray(myList.get(i)) );
        }

        return sb.toString();
    }
}
