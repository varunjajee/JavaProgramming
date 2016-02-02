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

        // Check for redundant currStrip, a currStrip is
        // redundant if it has same height or left as previous
//        System.out.println(index);
//        index++;
        System.out.println("+ index = " + index);
        int updatedHeight;
        if (index == -1) {
            strips[++index] = currStrip;

        }
        else if (strips[index].height == currStrip.height) {

//            System.out.println("+ strip len = " + this.strips.length);
//            System.out.println("Current index = "+ index);
//            System.out.println(index-1);
//            System.out.println(this.strips[index].height + " == " + currStrip.height);

            System.out.println("+ Skip adding, \"same height\"");
            return;
        }
        else if (strips[index].left == currStrip.left) {
            //updatedHeight = Math.max(strips[index -1].height, currStrip.height);
            System.out.println("+ Skip adding, \"same left\"");

        }

//        System.out.println("+ Strip len = " + strips.length);
//        System.out.println("+ Index = " + index);

        strips[index] = currStrip;
    }
}
