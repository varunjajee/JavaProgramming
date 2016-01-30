package com.muks.IntrvAlgorithms.SkyLine;

/**
 * Created by mukthar.ahmed on 1/29/16.
 */
// SkyLine:  To represent Output (An array of strips)
public class SkyLine {
    public Strip[] arr;   // Array of strips
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
    public SkyLine(int cap) {
        capacity = cap;
        arr = new Strip[cap];
        noOfStrips = 0;
    }

    // Function to add a strip 'st' to array
    public void append(Strip st) {
        // Check for redundant strip, a strip is
        // redundant if it has same height or left as previous
        if (noOfStrips > 0 && arr[noOfStrips -1].height == st.height)
            return;

        if (noOfStrips > 0 && arr[noOfStrips -1].left == st.left) {
            arr[noOfStrips -1].height = Math.max(arr[noOfStrips -1].height, st.height);
            return;
        }

        arr[noOfStrips] = st;
        noOfStrips++;
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
}