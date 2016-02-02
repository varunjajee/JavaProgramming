package com.muks.IntrvAlgorithms.SkyLine.Solve;

/*
 * Created by mukthar.ahmed on 2/2/16.
 */
public class Strip {
    public int left;  // x coordinate of left side
    public int height; // height

    public Strip(int l, int h) {
        left = l;
        height = h;
    }

    public void print() {
        System.out.println("(" + this.left + ", " + this.height + ")");
    }

}
