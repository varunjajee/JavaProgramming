package com.muks.DSC.BinaryTree;

/*
 * Created by mukthar.ahmed on 1/6/16.
 */


public class TestBinaryTree {


    public static void main(String[] args) {


//        BinarySearchTree bst = new BinarySearchTree(9);
//        bst.insert(bst.root, 10);
//        bst.insert(bst.root, 5);
//        bst.insert(bst.root, 1);
//        bst.insert(bst.root, 11);
//        bst.insert(bst.root, 6);
//        bst.insert(bst.root, 2);
//
//        System.out.println("\n\n");
////        System.out.println(bst.root.data);
////        System.out.println(bst.root.left.data + ", " + bst.root.right.data);
////        System.out.println(bst.root.left.left.data);
//        BinarySearchTree.inOrderTraversal(bst.root);


        int[] treeNodes = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        TreeNode myTree = BinarySearchTree.sortedArrayToBST(treeNodes, 0, treeNodes.length - 1);
        System.out.println("+ Tree With Root = " + myTree.toString());
        BinarySearchTree.inOrderTraversal(myTree);


    }



}   // end class
