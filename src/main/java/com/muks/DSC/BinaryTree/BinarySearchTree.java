package com.muks.DSC.BinaryTree;

/*
 * Created by mukthar.ahmed on 1/6/16.
 */


public class BinarySearchTree {
    public TreeNode root;
    public TreeNode parent;
    public int size;


    public BinarySearchTree() {
        root = new TreeNode();
    }

    public BinarySearchTree(int value) {
        root = new TreeNode(value);
        size++;

        System.out.println("\n+ Initialized Binary Search BinaryTree +");
        System.out.println("+ Root = " + root.toString() + ", Root.Left = NULL, Root.Right = NULL");
    }


    /*  ==============================================================================
        This constructor expects a sorted list of integers to build a tree
     */


    /*  =======================================================================================
        Creates a binary search tree using a sorted int[]

        Logic:
            - Using recursion (Base case, start pointer crosses end pointer)
            using binary search logic;
                - Left sub tree
                - Root
                - Right sub tree
     */
    public static TreeNode sortedArrayToBST(int[] num) {
        if (num.length == 0)
            return null;

        return sortedArrayToBST(num, 0, num.length - 1);
    }

    public static TreeNode sortedArrayToBST(int[] num, int start, int end) {
        if (start > end)
            return null;

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(num[mid]);
        root.left = sortedArrayToBST(num, start, mid - 1);
        root.right = sortedArrayToBST(num, mid + 1, end);

        return root;
    }


    /*
    // Binary tree from a sorted LinkedList
    public TreeNode sortedListToBST(int start, int end) {
        if (start > end)
            return null;

        // mid
        int mid = (start + end) / 2;

        TreeNode left = sortedListToBST(start, mid - 1);
        TreeNode root = new TreeNode(h.val);
        h = h.next;
        TreeNode right = sortedListToBST(mid + 1, end);

        root.left = left;
        root.right = right;

        return root;
    }
    */


    /* Get total nodes of the BST */
    public int getBstSize() { return size; }


    /*  =======================================================================================
        Insert a node to BST
     */
    public void insert(TreeNode node, int value) {
        System.out.println("fi = " + node.data);

        /* If no root node, then create one and return */
        if (node == null) {
            node = new TreeNode(value);
        }
        else {
            TreeNode current = node;

            if (value < node.data) {
                if (node.left != null)
                    insert(node.left, value);
                else
                    node.left = new TreeNode(value);

            }
            else if (value > node.data) {
                if (node.right != null)
                    insert(node.right, value);
                else
                    node.right = new TreeNode(value);

            }
            else {
                System.out.println("+ The value - \"" + value + "\" already exists.");

            }
        }

        size++;

    }   // end insert()



    /*  ===========================================================================================
        InOrder Traversal
        Steps:
            1 - Left sub tree
            2 - Root
            3 - Right sub tree
     */
    public static void inOrderTraversal(TreeNode printNode) {

       if (printNode == null) {
           return;
       }

        inOrderTraversal(printNode.left);
        System.out.println(printNode.data);
        inOrderTraversal(printNode.right);
    }


    /*  ===========================================================================================
      PreOrder Traversal
      Steps:
          1 - Root
          2 - Left sub tree nod
          3 - Right sub tree
   */
    public static void preOrderTraversal(TreeNode printNode) {
        if (printNode == null) {
            return;
        }

        System.out.println(printNode.data);
        inOrderTraversal(printNode.left);
        inOrderTraversal(printNode.right);
    }

    /*  ===========================================================================================
      PostOrder Traversal
      Steps:
          1 - Left sub tree nod
          2 - Right sub tree
          3 - Root
    */
    public static void postOrderTraversal(TreeNode printNode) {
        if (printNode == null) {
            return;
        }

        inOrderTraversal(printNode.left);
        inOrderTraversal(printNode.right);
        System.out.println(printNode.data);
    }


}   // end class
