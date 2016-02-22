package com.muks.DSC.Rope;

/* Created by mukthar.ahmed on 2/17/16.

   Node of a rope data structure
 */

public class RopeNode {
    RopeNode left, right;
    String data;
    int dataLength;

    /** Constructor **/
    public RopeNode(String data) {
        this.data = data;
        left = null;
        right = null;
        dataLength = data.length();
    }

    /** Constructor **/
    public RopeNode() {
        data = null;
        left = null;
        right = null;
        dataLength = 0;
    }

}   // end class RopeNode()

