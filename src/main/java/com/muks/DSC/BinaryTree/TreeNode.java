package com.muks.DSC.BinaryTree;

/*
 * Created by mukthar.ahmed on 1/6/16.
 */

public class TreeNode {
    public int data;
    public TreeNode left, right;

    public TreeNode() {}

    public TreeNode(int nodeValue) {
        this.data = nodeValue;
    }

    public String toString() {
        return "{"+ data + "}";
    }

}   // end class
