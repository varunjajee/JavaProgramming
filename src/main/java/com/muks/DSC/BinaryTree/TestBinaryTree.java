package com.muks.DSC.BinaryTree;

/*
 * Created by mukthar.ahmed on 1/6/16.
 */


public class TestBinaryTree {


    public static void main(String[] args) {


        BinarySearchTree bst = new BinarySearchTree(5);
        bst.insert(bst.root, 1);
        bst.insert(bst.root, 2);
        bst.insert(bst.root, 3);
        bst.insert(bst.root, 4);
        bst.insert(bst.root, 6);
        bst.insert(bst.root, 7);
        bst.insert(bst.root, 8);
        bst.insert(bst.root, 9);

//        System.out.println("\n\n");
//        System.out.println(bst.root.data);
//        System.out.println(bst.root.left.data + ", " + bst.root.right.data);
//        System.out.println(bst.root.left.left.data);
//        BinarySearchTree.inOrderTraversal(bst.root);


        int[] treeNodes = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        TreeNode myTree = BinarySearchTree.sortedArrayToBST(treeNodes, 0, treeNodes.length - 1);
//        System.out.println("+ Tree With Root =>\n\t\t\t\t" + myTree.toString());
//        System.out.println("\t\t" + myTree.left + "\t\t\t\t" + myTree.right);
//        System.out.println("\t" + myTree.left.left + "\t\t" + myTree.left.right);
//        System.out.println("" + myTree.left.left.left+ "\t\t\t" + myTree.left.right.right);


//        System.out.println("+ Parent-1 = "
//                + BinarySearchTree.getParent(myTree, myTree, 2));
//
//        System.out.println("+ Parent 2 = "
//                + BinarySearchTree.getParent(myTree, myTree.right.left));
//
//
//        System.out.println("+ Successor (" + myTree.left.right.right + ") = "
//                            + BinarySearchTree.getSuccessor(myTree, myTree.left.right.right));
//
//        System.out.println("+ Predecessor (" + myTree.right.left + ") = "
//                            + BinarySearchTree.getPredecessor(myTree, myTree.right.left));
//
//        BinarySearchTree.deleteNode(myTree, myTree.left.right.right);
//        BinarySearchTree.inOrderTraversal(myTree);


//        System.out.println("\n+ Sum ecluding leaves = "
//                + AlgosBinarySearchTree.getSumExcludingLeaves(myTree));
//
//        System.out.println("\n+ Sum of leaves ONLY = "
//                + AlgosBinarySearchTree.getLeavesSum(myTree));
//
//        System.out.println("+ Max = " + AlgosBinarySearchTree.getTreeMaxHeight(myTree));
//        System.out.println(" Min = " + AlgosBinarySearchTree.getTreeMaxHeight(myTree));
//        System.out.println("+ Is balanced = " + AlgosBinarySearchTree.isBalancedTree(myTree));

        System.out.println("---");
        System.out.println("+ 2nd largest element = ");
                AlgosBinarySearchTree.findKthLargest(myTree, 7);
        AlgosBinarySearchTree.findNthLargetst(myTree, 7);

        //System.out.println("===== " + AlgosBinarySearchTree.postOrder(myTree, 2));

    }



}   // end class
