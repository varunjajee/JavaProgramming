package com.muks.DSC.BinaryTree.BST.Algos;

/*
 * Created by mukthar.ahmed on 1/6/16.
 */


import com.muks.DSC.BinaryTree.BST.BinarySearchTree;
import com.muks.DSC.BinaryTree.BST.MyTrees;
import com.muks.DSC.BinaryTree.BST.TreeNode;

public class TestingBinaryTree {

    static TreeNode targetLeaf = null;
    static int maxSum = 0;

    public static void main(String[] args) {

//        /** zig-zag or spiral traversal */
//        // Answer : 1 2 3 4 5 6 7
//        TreeTraversals.zigZagView();
//
//        List<TreeNode> list = new ArrayList<>();
//        TreeTraversals.printRootToLeafPaths();

//        // Answer : 2 1 3 6
//        AlgosBinarySearchTree.isBinarySearchTree();


//        //BstInterviewQuestions.printDiagonalSum( MyTrees.getDiagonalTree().root );
//        //System.out.println("+ Found = " + BstInterviewQuestions.hasPathSum( MyTrees.getDiagonalTree().root, 9));
//
//        //System.out.println("+ Min path sum = " + BstInterviewQuestions.minSumPath(MyTrees.getDiagonalTree().root) );
//        //BstInterviewQuestions.GetMaxSumPath.rootNode = MyTrees.getDiagonalTree().root;
//
//        BstInterviewQuestions bstIntrv = new BstInterviewQuestions();
//        BstInterviewQuestions.MaxSumPath maxSumPath = new BstInterviewQuestions.MaxSumPath();
//        maxSumPath.getMaxSumPath(MyTrees.getDiagonalTree().root);

        // ====== end print diagonal    ============


//        AlgosBinarySearchTree.printBottomView(MyTrees.getBST().root);
//        AlgosBinarySearchTree.printTopView(MyTrees.getBST().root);


//
//        BinarySearchTree bst = MyTrees.getBST2();
//        BinarySearchTree bst2 = MyTrees.getBST3();
//        System.out.println("=> " + bst2.root + " => " + bst2.root.right.right);
//        //System.out.println(AlgosBinarySearchTree.checkIfLeavesAreAtSameLevel(bst.root));
//        System.out.println(AlgosBinarySearchTree.compareLeavesOfTwoTrees(bst.root, bst2.root));
//
//        System.out.println("+ Has same leaves: " +
//            AlgosBinarySearchTree.compareLeavesOfTwoTrees(bst.root, bst2.root));


//        BinarySearchTree bst = new BinarySearchTree(12);
//        bst.root.left = new TreeNode(10);
//        bst.root.right = new TreeNode(30);
//        bst.root.right.right = new TreeNode(40);
//        bst.root.right.left = new TreeNode(25);
//
        //AlgosBinarySearchTree.printLeftView(bst.root);

//        BinarySearchTree bst = new BinarySearchTree(1);
//        bst.root.left = new TreeNode(2);
//        bst.root.left.left = new TreeNode(4);
//        bst.root.left.right = new TreeNode(5);
//        bst.root.right = new TreeNode(3);
//        bst.root.right = new TreeNode(3);
//        bst.root.right.right = new TreeNode(7);
//        bst.root.right.right.right = new TreeNode(8);
//        bst.root.right.left = new TreeNode(6);
//
//        AlgosBinarySearchTree.printRightView(bst.root);
//        //AlgosBinarySearchTree.printLevelOrder(bst.root);

//        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        TreeNode btree = BinarySearchTree.createBalancedTree(arr);
//        AlgosBinarySearchTree.nodesByDepth(btree, 2);
//        AlgosBinarySearchTree.leavesWithDepth(bst.root);

        //AlgosBinarySearchTree.isBinarySearchTree(btree);


        //System.out.println("+ Root = " + btree.data);
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


        BinarySearchTree boundyTree = MyTrees.getBoundryTree();





//        List<TreeNode> path = new ArrayList<>();
//        AlgosBinarySearchTree.nodePathFinder(boundyTree.root, 10, path);
//        System.out.println(path.toString());

        //TreeTraversals.PrintBoundryOfTree boundryTraversal = new TreeTraversals.PrintBoundryOfTree();
        //boundryTraversal.printBoundry(boundyTree);

        //TreeTraversals.printRightView(boundyTree.root);

        //TreeTraversals.printBoundrySingleTraversal(boundyTree.root);
    }


}   // end class
