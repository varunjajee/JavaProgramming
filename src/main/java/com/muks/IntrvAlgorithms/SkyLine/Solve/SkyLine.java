package com.muks.IntrvAlgorithms.SkyLine.Solve;

/*
 * Created by mukthar.ahmed on 2/2/16.
 */


public class SkyLine {
    public Strip[] strips;
    public int index;

    public SkyLine(int totalStrips) {
        this.strips = new Strip[totalStrips];
        index = -1;
    }


    public void print() {
        for (Strip strip : this.strips) {
            System.out.println(" " + strip);
        }
    }

    public void append(Strip currStrip) {
        System.out.println("");
        System.out.println("+ Appending @ index = " + index);
        System.out.print("+ Adding strip = ");
        currStrip.print();

        if (index == -1) {
            System.out.println("newly added");

            strips[++index] = currStrip;
            System.out.println("+ fresh");

        }
        else if (strips[index].height == currStrip.height) {
            System.out.println("+ Skip adding, \"same height\"");

        }
        else if (strips[index].left == currStrip.left) {
            System.out.println("+ Skip adding, \"same left\"");

        } else {
            strips[++index] = currStrip;
            System.out.println("+ Added SUCCESSFULLY.");
        }
    }


    static SkyLine findSkyline(Building arr[], int l, int h) {
        if (l == h) {
            System.out.println("+ Low = " + l);
            SkyLine res = new SkyLine(2);
            res.append(new Strip(arr[l].left, arr[l].height));
            res.append(new Strip(arr[l].right, 0));
            return res;
        }

        int mid = (l + h)/2;

        // Recur for left and right halves and merge the two results
        SkyLine sl = findSkyline(arr, l, mid);
        SkyLine sr = findSkyline(arr, mid+1, h);

        SkyLine res = sl.Merge(sr);

        // Return merged skyline
        return res;
    }


    SkyLine Merge(SkyLine other) {
        // Create a resultant skyline with capacity as sum of two
        // skylines
        SkyLine res = new SkyLine(this.strips.length + other.strips.length);

        // To store current heights of two skylines
        int h1 = 0, h2 = 0;

        // Indexes of strips in two skylines
        int i = 1, j = 1;
        while (i < this.strips.length && j < other.strips.length) {

            // Compare x coordinates of left sides of two skylines and put the smaller one in result
            if (this.strips[i].left < other.strips[j].left) {
                int x1 = this.strips[i].left;
                h1 = this.strips[i].height;

                // Choose height as max of two heights
                int maxh = Math.max(h1, h2);

                res.append(new Strip(x1, maxh));
                i++;
            }
            else {
                int x2 = other.strips[j].left;
                h2 = other.strips[j].height;
                int maxh = Math.max(h1, h2);
                res.append(new Strip(x2, maxh));
                j++;
            }
        }

        // If there are strips left in this skyline or other
        // skyline
        while (i < this.strips.length) {
            res.append(this.strips[i]);
            i++;
        }
        while (j < other.strips.length) {
            res.append(other.strips[j]);
            j++;
        }
        return res;
    }
}
