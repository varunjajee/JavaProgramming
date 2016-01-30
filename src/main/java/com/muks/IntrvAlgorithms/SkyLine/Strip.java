package com.muks.IntrvAlgorithms.SkyLine;

/*
 * Created by mukthar.ahmed on 1/29/16.
 */
public class Strip {
    public int left;  // x coordinate of left side
    public int height; // height

    public Strip(int l, int h) {
        left = l;
        height = h;
    }

    public String toString() {
        return "(Left: " + this.left + ", Height: " + this.height + ")";
    }

}
