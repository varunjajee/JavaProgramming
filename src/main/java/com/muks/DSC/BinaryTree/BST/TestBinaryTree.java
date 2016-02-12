package com.muks.DSC.BinaryTree.BST;

/*
 * Created by mukthar.ahmed on 1/6/16.
 */


public class TestBinaryTree {


    public static void main(String[] args) {


        BinarySearchTree bst = new BinarySearchTree(5);
        bst.insert(bst.root, 1);
        bst.insert(bst.root, 9);
        bst.insert(bst.root, 6);
        bst.insert(bst.root, 7);
        bst.insert(bst.root, 8);

        BinarySearchTree bst2 = new BinarySearchTree(5);
        bst2.insert(bst2.root, 1);
        bst2.insert(bst2.root, 9);
        bst2.insert(bst2.root, 8);


        System.out.println("=> " + bst2.root + " => " + bst2.root.right.right);

        System.out.println("+ Has same leaves: " +
        AlgosBinarySearchTree.compareLeavesOfTwoTrees(bst.root, bst2.root));


//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        TreeNode btree = BinarySearchTree.createBalancedTree(arr);
//        System.out.println("+ Root = " + btree.data);
//        System.out.println(
//                btree.data + "\n" +
//                        btree.left + "\n" + btree.left.left + ", " + btree.left.right + "\n"
//                +  btree.left.right.right + ", " +  btree.left.right.left + "\n"
//                + btree.left.right.left.left + ", " + btree.left.right.left.right + "\n"
//        );
//
//        AlgosBinarySearchTree algosBinarySearchTree = new AlgosBinarySearchTree();
//        Stack<TreeNode> nStack = new Stack<>();
//        TreeNode leaf = algosBinarySearchTree.findLeafHelper(btree.left, nStack);
//        System.out.println("+ Leaf: " + leaf.data);

//        AlgosBinarySearchTree.DepthFirstSearch(btree);
//        AlgosBinarySearchTree.dfs(btree);
//
//        AlgosBinarySearchTree.BreadthFirst(btree);
//        AlgosBinarySearchTree.printLevelOrder(btree);



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

//        System.out.println("---");
//        System.out.println("+ 2nd largest element = ");
//                AlgosBinarySearchTree.findKthLargest(myTree, 7);
//        AlgosBinarySearchTree.findNthLargetst(myTree, 7);


        //AlgosBinarySearchTree.printTopView(myTree);

//        BinarySearchTree.inOrderTraversal(myTree);
//        AlgosBinarySearchTree.mirrorTree(myTree);

//        List<TreeNode> mylist = new ArrayList<>();
//        BinarySearchTree.inOrderTraversal(myTree);
//        AlgosBinarySearchTree.findPath(myTree, 6, mylist);
//        System.out.println(mylist.toString());

//        System.out.println("+ LCA = "
//                + AlgosBinarySearchTree.findLowestCommonAncestor(myTree, 1, 4) );

//        System.out.println("+ Distance between 2 nodes, 1 & 9 = "
//                + AlgosBinarySearchTree.findDistanceBtwn2Nodes(myTree, 1, 9) );


        //System.out.println("===== " + AlgosBinarySearchTree.postOrder(myTree, 2));

    }



}   // end class
