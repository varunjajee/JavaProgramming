package com.muks.DSC.BinaryTree.BST.Trees;

import com.muks.DSC.BinaryTree.BST.BinarySearchTree;
import com.muks.algo.SearchAlgo.BinarySearch;

/**
 * Created by mukthar.ahmed on 3/25/16.
 *
 * Class exposing all the required trees to practise algorithms
 */
public class MyTrees {

    public static BinarySearchTree getZigZagTree() {
        /** Get diagonal sum */
        BinarySearchTree zigZagTree = new BinarySearchTree(1);
        zigZagTree.root.left = new TreeNode(2);
        zigZagTree.root.right = new TreeNode(3);

        zigZagTree.root.left.left = new TreeNode(7);
        zigZagTree.root.left.right = new TreeNode(6);

        zigZagTree.root.right.left = new TreeNode(5);
        zigZagTree.root.right.right = new TreeNode(4);

        return zigZagTree;
    }


    public static BinarySearchTree getBST() {
        /** Tree for Top view */
        BinarySearchTree bst = new BinarySearchTree(1);
        bst.root.left = new TreeNode(2);
        bst.root.right = new TreeNode(3);
        bst.root.left.left = new TreeNode(4);
        bst.root.left.right = new TreeNode(5);

        bst.root.right.right = new TreeNode(7);
        bst.root.right.left = new TreeNode(6);
        return bst;
    }

    public static BinarySearchTree getDiagonalTree() {
        /** Get diagonal sum */
        BinarySearchTree diagonalTree = new BinarySearchTree(1);
        diagonalTree.root.left = new TreeNode(2);
        diagonalTree.root.right = new TreeNode(3);

        diagonalTree.root.left.left = new TreeNode(9);
        diagonalTree.root.left.right = new TreeNode(6);
        diagonalTree.root.left.right.left = new TreeNode(11);

        diagonalTree.root.left.left.right = new TreeNode(10);

        diagonalTree.root.right.right = new TreeNode(5);
        diagonalTree.root.right.left = new TreeNode(4);
        diagonalTree.root.right.left.left = new TreeNode(12);
        diagonalTree.root.right.left.right = new TreeNode(7);

        return diagonalTree;
    }

    public static BinarySearchTree getBST2() {
        BinarySearchTree bst = new BinarySearchTree(5);
        bst.insert(bst.root, 1);
        bst.insert(bst.root, 9);
        bst.insert(bst.root, 6);
        bst.insert(bst.root, 7);
        bst.insert(bst.root, 8);
        return  bst;
    }

    public static BinarySearchTree getBST3() {
        BinarySearchTree bst2 = new BinarySearchTree(5);
        bst2.insert(bst2.root, 1);
        bst2.insert(bst2.root, 9);
        bst2.insert(bst2.root, 8);
    }
}
