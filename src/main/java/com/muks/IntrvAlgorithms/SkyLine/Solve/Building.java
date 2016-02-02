package com.muks.IntrvAlgorithms.SkyLine.Solve;

/*
 * Created by mukthar.ahmed on 2/2/16.
 */
public class Building {
    public int left, right, height;

    public Building(int l, int r, int h) {
        this.left = l;
        this.right = r;
        this.height = h;
    }

    public void print() {
        System.out.print(" (" + this.left + ", " + this.right + ", "  + this.height + ")");
    }
}
