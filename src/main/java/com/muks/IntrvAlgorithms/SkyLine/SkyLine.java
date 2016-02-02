package com.muks.IntrvAlgorithms.SkyLine;

/*
 * Created by mukthar.ahmed on 1/29/16.
 */


import java.util.ArrayList;
import java.util.List;

// SkyLine:  To represent Output (An array of strips)
public class SkyLine {
    public List<Strip> arr;   // Array of strips
    public int capacity; // Capacity of strip array
    public int noOfStrips;   // Actual number of strips in array

    int count()  {
        return noOfStrips;
    }

    // A function to merge another skyline
    // to this skyline
    SkyLine Merge(SkyLine other) {
        return null;
    }


    // Constructor
    public SkyLine() {};
    public SkyLine(int cap) {
        capacity = cap;
        arr = new ArrayList<>();
        noOfStrips = 0;
    }

    // Function to add a strip 'st' to array
    public void append(Strip st) {
        System.out.println("+ Prev Strip = " + this.arr.get(noOfStrips-1));
        System.out.println("+ Prev Strip = " + st.toString());
        // Check for redundant strip, a strip is
        // redundant if it has same height or left as previous
        if (noOfStrips > 0 && this.arr.get(noOfStrips -1).height == st.height) {
            return;
        }

        else if (noOfStrips > 0 && arr.get(noOfStrips -1).left == st.left) {
            this.arr.get(noOfStrips -1).height
                    = Math.max(this.arr.get(noOfStrips -1).height, st.height);

        }

        System.out.println("+ noOfStrips = " + noOfStrips);
        //arr.get(noOfStrips) = st;
        this.arr.add(st);
        this.noOfStrips++;

    }

    // A utility function to print all strips of
    // skyline
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (Strip strip : arr) {
            sb.append(" (" + strip.left);
            sb.append(", " + strip.height + ")" );
        }

        return "\nSkyLine: " + sb.toString();
    }


    public static SkyLine findSkyline(Building[] arr) {
        SkyLine res = new SkyLine(arr.length * 2);
        for (Building building : arr) {
            res.append(new Strip(building.left, building.height));
            res.append(new Strip(building.right, 0));
        }

        System.out.println(res.toString());
        SkyLine merged = mergeSkyline(res);

        System.out.println("+ Merged: " + merged.toString());
        return res;
    }


    public static SkyLine mergeSkyline(SkyLine skyLine) {
        if (skyLine.arr.size() <= 1) {
            return skyLine;
        }

        // Split the array in half
        int mid = skyLine.arr.size()/2;
        SkyLine first = new SkyLine(mid);
        SkyLine second = new SkyLine(skyLine.arr.size() - mid);

        int i;
        for (i = 0 ; i < mid; i++) {
            first.arr.add(skyLine.arr.get(i));
        }

        for (int j = mid; j < skyLine.arr.size(); j++) {
            //second.arr[j - mid] = skyLine.arr[j];
            second.arr.add(skyLine.arr.get(j));
        }

        // Sort each half
        mergeSkyline(first);
        mergeSkyline(second);

        // Merge the halves together, overwriting the original array
        return merge(first, second, skyLine);

    }

    private static SkyLine merge(SkyLine sl, SkyLine sr, SkyLine res) {
        System.out.println("+ Sl => " + sl.toString());
        System.out.println("+ Sr => " + sr.toString());

        // Create a resultant skyline with capacity as sum of two
        // skylines
        //SkyLine res = new SkyLine(sl.length + sr.length);

        // To store current heights of two skylines
        int h1 = 0, h2 = 0;

        // Indexes of strips in two skylines
        int i = 0, j = 0;


        while (i < sl.arr.size() && j < sr.arr.size()) {

            if (sl.arr.get(i).left < sr.arr.get(j).left) {
                int x1 = sl.arr.get(i).left;
                h1 = sl.arr.get(i).height;

                // Choose height as max of two heights
                int maxh = Math.max(h1, h2);

                System.out.println("+ Skyline now() - Len = " + res.arr.size()
                + ", Capacity = " + res.capacity
                + ", " + res.noOfStrips);

                res.append(new Strip(x1, maxh));
                i++;
            }
            else {
                int x2 = sr.arr.get(j).left;
                h2 = sr.arr.get(j).height;
                int maxh = Math.max(h1, h2);
                res.append(new Strip(x2, maxh));
                j++;
            }
        }

        // If there are strips left in this skyline or sr
        // skyline
        while (i < sl.arr.size()){
            res.append(sl.arr.get(i));
            i++;
        }
        while (j < sr.arr.size()) {
            res.append(sr.arr.get(j));
            j++;
        }
        return res;
    }

}