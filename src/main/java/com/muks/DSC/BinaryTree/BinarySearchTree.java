package com.muks.DSC.BinaryTree;

/*
 * Created by mukthar.ahmed on 1/6/16.


                        a
                    |       |
                b               c
            |               |       |
        d       e       f       g       h


    -   Root        -> A is the Root
    -   Parent      -> b is the parent of d & e
    -   Ancestor    -> a is the ancestor of d & e
    -   Descendents  -> d & e are descendents of a
    -   Siblings    -> b & c are siblings as they have same parent
    -   Children    -> d & e are childrens of b
    -   Leaf        -> d, e, f, g, h as they do not have any children

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
        Insert a rootNode to BST
     */
    public void insert(TreeNode rootNode, int value) {
        /* If no root rootNode, then create one and return */
        if (rootNode == null) {
            rootNode = new TreeNode(value);
        }
        else {

            if (value < rootNode.data) {
                if (rootNode.left != null)
                    insert(rootNode.left, value);
                else
                    rootNode.left = new TreeNode(value);

            }
            else if (value > rootNode.data) {
                if (rootNode.right != null)
                    insert(rootNode.right, value);
                else
                    rootNode.right = new TreeNode(value);

            }
            else {
                System.out.println("+ The value - \"" + value + "\" already exists.");

            }
        }

        size++;

    }   // end insert()


    // ========================== getParent() by recursion ==========================
    public static TreeNode getParent(TreeNode parent, TreeNode node, int value) {
        if (node == null) {
            return null;
        }

        if (node.data != value) {
            parent = getParent(node, node.left, value);

            // If parent is still not found, then the base case will return null. Then move to right
            if (parent == null) {
                parent = getParent(node, node.right, value);
            }
        }

        return parent;
    }

    // ========================== getParent() by iteration ==========================
    public static TreeNode getParent(TreeNode rootNode, TreeNode node) {

        TreeNode parent = null;
        TreeNode current = rootNode;

        while (true) {
            if (current == null) {
                return null;
            }
            else if (current == node) {
                break;
            }
            else if (node.data < current.data) {
                parent = current;
                current = current.left;
            }
            else  if (node.data > current.data) {
                parent = current;
                current = current.right;
            }
        }

        return parent;

    }

    /*  ===========================================================================================
        Min of BST tree

        Minimum is found as the left most node of the left sub tree.
        Steps:
            check if root.left != null and traverse towards left most sub tree
     */
    public static TreeNode getMinimum(TreeNode root) {
        if (root == null) {
            return root;
        }

        if (root.left != null) {
            return getMinimum(root.left);
        }

        return root;
    }


    /*  ===========================================================================================
        Max
    */
    public static TreeNode getMaximum(TreeNode root) {
        if (root == null) {
            return root;
        }

        if (root.right != null) {
            return getMinimum(root.right);
        }

        return root;
    }


    /*  ===========================================================================================
        Get Successor

        Defination:
            -   Given 'x' find a node with smallest key greator than key(x)

        Case-1:
            Right sub tree is not null
                -   Minimum of right sub tree is successor


        Case-2:
            Null Right sub tree
                - Using 2 pointers, move will a situation where node is parent.left;
                    node = parent;
                    parent = parent(node)
    */
    public static TreeNode getSuccessor(TreeNode rootNode, TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            return getMinimum(node.right);
        }

        TreeNode parentNode = getParent(rootNode, node);
        while (parentNode != null && node != parentNode.left) {
            node = parentNode;
            parentNode = getParent(rootNode, parentNode);
        }

        return parentNode;
    }



    // ============
    public static TreeNode getPredecessor(TreeNode rootNode, TreeNode node) {
        if (node == null) {
            return null;
        }

        if (node.left != null) {
            return getMaximum(node.left);
        }

        TreeNode parent = getParent(rootNode, node);
        while (parent != null && node != parent.right) {
            node = parent;
            parent = getParent(rootNode, node);
        }

        return parent;
    }

    /*  ===========================================================================================
        Delete a node from BST keeping the search property


        Case - 1 : Leaf node - no child
                - Parent.left || parent.right = null

        Case - 2 : One child
                    - parent.left = node.left || parent.left = node.right
                    - parent.right = node.left || parent.right = node.right

        Case - 3 : Two child
                - if node to delete is towards right of root, find minimum (successor) and set
                current node to its successor and delete the current node.
                OR
                - if node to delete is towards left of root, find max (predecessor) and set
                current node to its predecessor and delete the current node

     */
    public static void deleteNode(TreeNode rootNode, TreeNode nodeToDelete) {

        /* Case-1 : where node is a leaf node */
        if (nodeToDelete.left ==  null && nodeToDelete.right == null) {
            System.out.println("\n+ Case # 1: Deleting a leaf node: " + nodeToDelete.toString());

            TreeNode parent = getParent(rootNode, nodeToDelete);
            if (nodeToDelete == parent.left) {
                parent.left = null;
            }
            else if (nodeToDelete == parent.right) {
                parent.right = null;
            }
        }   // end case-1

        else if (nodeToDelete.left == null || nodeToDelete.right == null) {
            System.out.println("+ Case # 2: Deleting a node having 1 child/subtree - " +
                    nodeToDelete.toString());

            TreeNode parent = getParent(rootNode, nodeToDelete);

            if (nodeToDelete.left != null) {
                if (nodeToDelete == parent.left) {
                    parent.left = nodeToDelete.left;
                }
                else {
                    parent.right = nodeToDelete.left;
                }
            }
            else if (nodeToDelete.right != null) {
                if (nodeToDelete == parent.right) {
                    parent.right = nodeToDelete.right;
                }
                else {
                    parent.right = nodeToDelete.left;
                }
            }

        }   // end case-2

        else {
            System.out.println("+ Case # 3: Deleting a node having left subtree & right subtree " +
                    " - " + nodeToDelete.toString());
            TreeNode successor = getSuccessor(rootNode, nodeToDelete);
            TreeNode tmp = successor;
            deleteNode(rootNode, successor);

            nodeToDelete.data = tmp.data;

        }   // end case-3

    }




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
