package com.muks.DSC.BinaryTree.BST;

/*
 * Created by mukthar.ahmed on 1/6/16.
 */

public class TreeNode {
    public int data;
    public int hd;  // horizontal distance of a node from root node
    public int vd; // vertical distance of the node from root node

    public TreeNode left, right;

    public TreeNode() {}

    public TreeNode(int nodeValue) {
        this.data = nodeValue;
    }

    public String toString() {
        return "["+ data + "]";
    }

}   // end class
