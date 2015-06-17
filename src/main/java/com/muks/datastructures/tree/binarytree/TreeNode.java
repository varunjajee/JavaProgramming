package com.muks.datastructures.tree.binarytree;

/*
http://www.codepuppet.com/2013/10/30/binary-tree-implementation-in-java/
 */
public class TreeNode {
    int value;
    TreeNode parent;
    TreeNode left;
    TreeNode right;

    // Constructors
    public TreeNode(int value) {
        this.value = value;
        //parent = left = right = null;
    }

    public TreeNode(int value, TreeNode left, TreeNode right) {
        this.left = left;
        this.right = right;
        this.value = value;
    }


    // getters
    public int getValue() {
        return value;
    }

    public TreeNode getLeft() {
        return left;
    }

    public TreeNode getRight() {
        return right;
    }

    public TreeNode getParent() {
        return parent;
    }

    // setters
    public void setValue(int value) {
        this.value = value;
    }

    public void setLeft(TreeNode node) {
        left = node;
    }

    public void setRight(TreeNode node) {
        right = node;
    }

    public void setParent(TreeNode node) {
        parent = node;
    }

}
