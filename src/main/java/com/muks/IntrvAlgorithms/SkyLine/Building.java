package com.muks.IntrvAlgorithms.SkyLine;

/*
 * Created by mukthar.ahmed on 1/29/16.
 */
public class Building {
    public int left, right, height;

    public Building(int l, int r, int h) {
        this.left = l;
        this.right = r;
        this.height = h;
    }

    public String toString() {
        return "(Left: " + this.left + ", Right: " + this.right + ") - Height: "  + this.height;
    }
}
