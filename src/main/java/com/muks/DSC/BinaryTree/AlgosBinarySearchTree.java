package com.muks.DSC.BinaryTree;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*
 * Created by mukthar.ahmed on 1/7/16.
 */
public class AlgosBinarySearchTree {

    /* ==================================================================================
     Print tree nodes in verticle order
     DFS - Depth First Search
    */
    public static void printVerticleOrder(TreeNode root) {
        System.out.println("\nPrint Verticle Order Traversal");
        HashMap<Integer, ArrayList<Integer>> hMap = new HashMap<>();

        int horizDepth = 0;
        verticleOrderTraversal(root, horizDepth, hMap);

        System.out.println("+ Verticle Order: " + hMap.toString() + "\n");
    }

    public static void verticleOrderTraversal(TreeNode node, int horizDepth,
                                              HashMap<Integer, ArrayList<Integer>> hMap) {

        // base case
        if (node == null) {
            return;
        }

        // keep populating hashmap based on the horizDepth distance travelled
        if (hMap.get(horizDepth) == null) {
            hMap.put(horizDepth, new ArrayList(Collections.singleton( node.data )));
        } else {
            hMap.get(horizDepth).add(node.data);
        }

        verticleOrderTraversal(node.left, horizDepth-1, hMap);
        verticleOrderTraversal(node.right, horizDepth+1, hMap);

    }

    /*  ==================================================================================
        Level order traversal : Printing nodes at each leve of BST

        // BFS - Breadth First Search
    */
    public static void printLevelOrder(TreeNode root) {
        System.out.println("\n+ Print - Level order traversal.");

        // store levels and their node values
        HashMap<Integer, ArrayList<Integer>> levelOrderTree = new HashMap<>();
        ArrayList<Integer> nodeValues = new ArrayList<>();

        int verticalDepth = 0;  // init tree root level = 0

        // base case
        if(root == null)
            return;

        // nodes at current level
        Queue<TreeNode> currLevelNodesQ = new LinkedList<>();
        currLevelNodesQ.add(root);

        // nodes at next level
        Queue<TreeNode> nextLevelNodesQ = new LinkedList<>();


        levelOrderTree.put(verticalDepth, new ArrayList<Integer>(root.data));

        while(!currLevelNodesQ.isEmpty()) {
            TreeNode node = currLevelNodesQ.remove();

            if(node.left != null)
                nextLevelNodesQ.add(node.left);

            if(node.right != null)
                nextLevelNodesQ.add(node.right);

            nodeValues.add(node.data);

            if(currLevelNodesQ.isEmpty()) {
                currLevelNodesQ = nextLevelNodesQ;
                nextLevelNodesQ = new LinkedList<>();

                levelOrderTree.put(verticalDepth, new ArrayList(Collections.singleton(nodeValues)));
                verticalDepth++;

                nodeValues = new ArrayList();
            }

        }

        System.out.println("+ Level Order: " + levelOrderTree.toString());

    }   // end printLevelOrder()



    /*  =====================================================================================
        Find the sum of all nodes other excluding leaf nodes

        Logic:
            - traverse all the nodes of a tree and track the sum, skip sum when leaf node.
     */
    public static int getSumExcludingLeaves(TreeNode node) {
        if ((node == null ) || (node.left == null & node.right == null) ) {
            return 0;
        }

        return node.data + (getSumExcludingLeaves(node.left) + getSumExcludingLeaves(node.right));
    }



    /*  ==========================================================================================
     Sum of leaf nodes only

     Logic:
        - return value only if its a leaf node.
     */
    public static int getLeavesSum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null & node.right == null) {
            return node.data;
        }

        return (getLeavesSum(node.left) + getLeavesSum(node.right));
    }

    /*  =========================================================================================
        Definition: A tree is said to be balanced if the
            -> difference ( max height and min height ) <= 1
     */
    public static boolean isBalancedTree (TreeNode node) {
        if (node == null) return true;

        int maxHeight = getTreeMaxHeight(node);
        int minHeight = getTreeMinHeight(node);

        return ( maxHeight - minHeight <= 1 );
    }

    /* Get tree's Max height */
    public static int getTreeMaxHeight(TreeNode node) {
        if (node == null)
            return 0;

        int leftDepth = getTreeMaxHeight(node.left);
        int rightDepth = getTreeMaxHeight(node.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    /* Get tree's Min height */
    public static int getTreeMinHeight(TreeNode node) {
        if (node == null)
            return 0;

        int leftDepth = getTreeMaxHeight(node.left);
        int rightDepth = getTreeMaxHeight(node.right);

        return Math.min(leftDepth, rightDepth) + 1;
    }

    /* ==========================================================================================
        Find K-th largest element
     */
//    public static int findKthLargest(TreeNode currentNode, int k) {
//        if (currentNode == null) {
//            return 0;
//        }
//
//        int counter = 0;
//        while (currentNode != null) {
//            if (counter < k) {
//                findKthLargest(currentNode.right, k);
//            }
//            counter++;
//            if (counter == k) {
//                return currentNode.data;
//            }
//            else {
//                findKthLargest(currentNode.left, k);
//            }
//
//        }
//        return currentNode.data;
//    }


    public static int postOrder(TreeNode current, int k) {
        Stack<TreeNode> largest = new Stack<>();

        while (current != null) {
            k--;
            System.out.println("k = " + k + ", node = " + current.data);
            if (k == 0) {
                return current.data;
            }
            if (current.right != null) {
                current = current.right;
            }
            else {
                current = current.left;
            }

        }
        return current.data;
    }


    /*  ================================================================================
        Recursively find N-th largest element in the tree
     */
    public static int findNthLargetst(TreeNode node, int k) {

        if (node == null) {
            return k;
        }

        k = findNthLargetst(node.right, k);

        k--;
        if (k == 0) {
            System.out.println("+ Node = " + node.data);
            return 0;
        }

        k = findNthLargetst(node.left, k);
        return k;
    }


    /*  ========================================================================================
        Iteratively find the k-th largest element in the tree by keeping track using a stack
     */
    public static void findKthLargest(TreeNode node, int k) {

        Stack<TreeNode> resStack = new Stack<>();

        TreeNode current = node;

        while (resStack.size() > 0 || current != null) {
            if (current != null) {
                //System.out.println("+++ current: " + current.data);
                resStack.add(current);
                current = current.right;

            } else {
                current = resStack.pop();

                //System.out.println("+ k = " + k + ", current = "  + current.data);
                k--;

                if(k == 0) {
                    System.out.println("+ Kth: " + k + ", Smallest element is = "  + current.data);
                    return;
                }

                current = current.left;
            }
        }

    }

}   // end class
