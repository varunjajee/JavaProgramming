package com.muks.DSC.Rope;

/**
 * Created by mukthar.ahmed on 2/17/16.
 *
 *  Public class for building "Rope" binary tree
 *
 **/


/* ToDo: Implement remove(), insert(), split() methods of rope for complete text editor features */

public class Rope {
    RopeNode root;

    public Rope() {
        root = new RopeNode("");
    }

    /** Function to clear rope **/
    public void makeEmpty() {
        root = new RopeNode("");
    }

    /** Function to concat an element **/
    public void concat(String str) {
        RopeNode nodeToAdd = new RopeNode(str);
        RopeNode newRoot = new RopeNode();

        newRoot.left = root;
        newRoot.right = nodeToAdd;

        newRoot.dataLength = newRoot.left.dataLength;

        if (newRoot.left.right != null) {
            newRoot.dataLength += newRoot.left.right.dataLength;
        }

        root = newRoot;

    }



    /** Function get character at a paricular index **/
    public char indexAt(int ind) {
        RopeNode tmp = root;

        if (ind > tmp.dataLength) {
            ind -= tmp.dataLength;

            return tmp.right.data.charAt(ind);
        }

        while (ind < tmp.dataLength)
            tmp = tmp.left;

        ind -= tmp.dataLength;

        return tmp.right.data.charAt(ind);

    }


    /** Function get substring between two indices **/
    public String substring(int start, int end) {
        String str = "";
        boolean found = false;

        RopeNode tmp = root;

        if (end > tmp.dataLength) {
            found = true;

            end -= tmp.dataLength;

            if (start > tmp.dataLength) {
                start -= tmp.dataLength;
                str = tmp.right.data.substring(start, end);

                return str;
            }
            else {
                str = tmp.right.data.substring(0, end);
            }

        }

        if (!found) {
            while (end <= tmp.dataLength) {
                tmp = tmp.left;
            }

            end -= tmp.dataLength;
            if (start >= tmp.dataLength) {
                start -= tmp.dataLength;
                str = tmp.right.data.substring(start, end) + str;

                return str;
            }

            str = tmp.right.data.substring(0, end);

        }

        tmp = tmp.left;

        while (start < tmp.dataLength) {
            str = tmp.right.data + str;
            tmp = tmp.left;
        }

        start -= tmp.dataLength;

        str = tmp.right.data.substring(start) + str;

        return str;
    }



    /** Function to print Rope
     *
     *  Priting entire rope string involves running a pre-order traversal with null checks at all
     *  level
     *
     * **/
    public void print() {
        ropePreOrderTraversal(root);
        System.out.println();
    }

    public void ropePreOrderTraversal(RopeNode ropeNode) {
        if (ropeNode != null) {
            ropePreOrderTraversal(ropeNode.left);

            if (ropeNode.data != null) {
                System.out.print(ropeNode.data);
            }

            ropePreOrderTraversal(ropeNode.right);
        }
    }



}
