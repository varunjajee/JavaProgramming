package com.muks.DSC.BinaryTree.BST;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;
import java.util.TreeMap;

/*
 * Created by mukthar.ahmed on 1/7/16.
 */
public class AlgosBinarySearchTree {

    public static void printTopView(TreeNode root) {
        if (root == null) {
            return;
        }

        int hd = 0; // horizontal distance
        root.hd = 0;

        /* TreeMap which stores key value pair sorted on key value */
        Map<Integer, Integer> map = new TreeMap<>();

        /* Queue to store tree nodes in level order traversal */
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);


        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();

            hd = current.hd;
            map.put(hd, current.data);
            System.out.println("+ current = " + current.data + ", hd = " + hd);

            if (current.left != null) {
                current.left.hd = hd-1;
                queue.add(current.left);
            }

            if (current.right != null) {
                current.right.hd = hd+1;
                queue.add(current.right);
            }
        }


        System.out.println(map.toString());
        StringBuilder sb = new StringBuilder();
        for (Integer i : map.keySet()) {
            sb.append(map.get(i) + ", ");
        }

        System.out.println(sb.toString());
    }


    public static void verticalOrderIterative(TreeNode root) {
        if (root == null) { return; }
        int hd = 0;

        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        root.hd = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();

            hd = current.hd;
            System.out.println("+ Node = "  +current + ", hd = " + hd);
            if (map.containsKey(hd)) {
                map.get(hd).add(current.data);
            } else {
                map.put(hd, new ArrayList(Collections.singleton(current.data)));
            }

            if (current.left != null) {
                current.left.hd = hd-1;
                queue.add(current.left);
            }

            if (current.right != null) {
                current.right.hd = hd+1;
                queue.add(current.right);
            }
        }

        System.out.println(map.toString());
    }
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

        // store levels and their node datas
        HashMap<Integer, ArrayList<Integer>> levelOrderTree = new HashMap<>();
        ArrayList<Integer> nodedatas = new ArrayList<>();

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

            nodedatas.add(node.data);

            if(currLevelNodesQ.isEmpty()) {
                currLevelNodesQ = nextLevelNodesQ;
                nextLevelNodesQ = new LinkedList<>();

                levelOrderTree.put(verticalDepth, new ArrayList(Collections.singleton(nodedatas)));
                verticalDepth++;

                nodedatas = new ArrayList();
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
        - return data only if its a leaf node.
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


    /*  =========================================================================================
        Iteratively print tree in post order manner
    */
    public static void postOrderTraverseIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        while (current != null || stack.size() > 0) {
            if (current != null) {
                stack.add(current);
                current = current.right;
            }
            else {
                current = stack.pop();

                System.out.println( current.data );

                current = current.left;
            }
        }
    }


    /*  ========================================================================================
        Print only leave nodes

        Logic:
            - Traverse entire tree using recursion
            - While traversing, if we encounter a leaf node, then just print it.
     */
    public static void printLeaves(TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left == null & node.right == null) {
            System.out.println(node.data);
            return;
        }

        printLeaves(node.left);
        printLeaves(node.right);
    }

    public static int countLeaves(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left == null & node.right == null) {
            System.out.println(node.data);
            return node.data;
        }

        return countLeaves(node.left) + countLeaves(node.right);
    }

    // ================================================================================#######
    // print all the node data at a given level/depth of a BST
    public void nodesByDepth(TreeNode node, int depth) {

        if (node == null)
            return;

        if (depth == 1) {
            System.out.println(node.data);
            return;
        }

        nodesByDepth(node.left, depth - 1);
        nodesByDepth(node.right, depth - 1);

    }

    public static void leavesByDepth(TreeNode node, int depth, List<Integer> nodeList) {
        if (node == null)
            return;

        if (depth == 1) {
            if (node.left == null && node.right == null) {
                //System.out.println(node.data);
                nodeList.add(node.data);
            }
        }


        leavesByDepth(node.left, depth - 1, nodeList);
        leavesByDepth(node.right, depth - 1, nodeList);

    }	// leavesByDepth()


    /* Leave with depth */
    public void leavesWithDepth(TreeNode node) {
        System.out.println("\n+++ Leaves at tree level/depth: ");

        HashMap<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        List<Integer> nodeList = new ArrayList<Integer>();
        int ht = getTreeMaxHeight(node);


        for (int depth = 1; depth <= ht; depth++) {

            nodeList.clear();							// clear the list before iteration
            leavesByDepth(node, depth, nodeList);		// process leaf nodes

            if (!map.containsKey(depth)) {
                map.put(depth, new ArrayList<Integer>());
            }

            if (nodeList.size() == 0) {
                map.put(depth, null);
            } else {
                map.put(depth, nodeList);
            }

        }	// for()

        System.out.println("+ Leaf nodes at various levels: \n" + map.toString());
    }




    // ================================================================================
    
    // mirror or rotate a binary tree at its root
    public static void mirrorTree(TreeNode node) {
        if(node == null) {
            return;
        }

        mirrorTree(node.left);
        mirrorTree(node.right);

        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;

    }



    // ================================================================================
    public boolean isIdentical (TreeNode t1, TreeNode t2) {
        if ( (t1 == null) && (t2 == null) )
            return true;

        if ( (t1 != null) && (t2 == null)
                || (t1 == null) && (t2 != null) )
            return false;

        if (t1.data != t2.data) {
            return false;
        } else {
            return ( isIdentical(t1.left, t2.left) && isIdentical(t1.right, t2.right) );
        }

    }

    // ================================================================================#######
    // find is t2 is a subtree of t1
    public boolean containsTree (TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        } else {
            return subTree(t1, t2);
        }
    } // containsTree()


    // ================================================================================#######
    public boolean subTree(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return false;

        if (t1.data == t2.data) {
            return isIdentical(t1, t2);
        }

        return (subTree(t1.left, t2) || subTree(t1.right, t2) );

    } // subTree()



/*    // ================================================================================#########
    // Get postOrderPredecessor()
    public TreeNode[] par_array = new TreeNode[100];
    public TreeNode postOrderPredecessor (TreeNode node) {

        if (node == null) {
            return null;
        }

        else {
            if (node.right != null) {
                return node.right; 	//	1. if the node has right child then return the right child
                //return treeMaximum(node.left); 	// max value from the left subtree
            }

            if (node.left != null) {
                return node.left; 	//	1. if the node has right child then return the right child
                //return treeMaximum(node.left); 	// max value from the left subtree
            }

            TreeNode y = BinarySearchTree.getParent(root, node);
            TreeNode x = node;
            while ( (y != null) && (x == y.left) ) { // turns false when "node" turns to be in the right subtree of its parent
                x = y;
                y = BinarySearchTree.getParent(root, y);
            }

            return y;

        }

    }*/


    // ================================================================================#########
    // Get the Lowest Common Ancestor of 2 nodes
    // from the node, traverse up till the root node, see if the nodes match while traversing up
    public static TreeNode LCA(TreeNode root, TreeNode a, TreeNode b){
        TreeNode left = null, right = null;
        if(root==null) {
            return root;
        }
        if(root==a || root==b) {
            return root;
        }
        left=LCA(root.left,a,b);
        right=LCA(root.right,a,b);

        if(left!=null && right!=null) {
            return root;
        }
        return (left!=null)?left:right;
    }


    public TreeNode findLCA(TreeNode root, TreeNode p, TreeNode q) {

        // no root no LCA.
        if(root == null) {
            return null;
        }

        // if either p or q is the root then root is LCA.
        if(root == p || root==q) {
            return root;
        } else {
            // get LCA of p and q in left subtree.
            TreeNode l = findLCA(root.left , p , q);

            // get LCA of p and q in right subtree.
            TreeNode r = findLCA(root.right , p, q);

            // if one of p or q is in leftsubtree and other is in right
            // then root it the LCA.
            if(l != null && r != null) {
                return root;
            }
            else {		// else if l is not null, l is LCA.
                TreeNode temp = (l != null) ? l:r;
                return temp;
            }

        }
    }




	/* ================================================================================##############
	 * 1. We will first find out the path of the two nodes from root using recursive path finding algorithm.
	 * 2. Now we will traverse simultaneously along the two paths till we find a mismatch.
	 * 3. Then we know the size of the two paths, so we can easily calculate the distance by the formula,
	 * 	  => length of path1 + length of path2 - 2*length of the common part
	 *
	 */

    private static int findDistanceBtwn2Nodes(TreeNode root, int val1, int val2) {
        List<TreeNode> path1 = new ArrayList<TreeNode>();
        List<TreeNode> path2 = new ArrayList<TreeNode>();

        findPath(root, val1, path1);
        findPath(root, val2, path2);

        System.out.println("\n+ size-path1: " + path1.size() + " - " + "size-path2: " + path2.size());

        if (path1.size() == 0 || path2.size() == 0) {
            return -1;
        }

        int index = 0;
        for (; index < path1.size(); index++) {

            System.out.println(path1.get(index).data + " != " + path2.get(index).data);

            if (path1.get(index) != path2.get(index)) {
                break;
            }

        }

        System.out.println("\n + size-path1: " + path1.size() + " - " + "size-path2: " + path2.size() + " index: " + index);
        return path1.size() + path2.size() - 2 * index;

    }

    // method to fetch path to the given node
    private static boolean findPath(TreeNode root, int value, List<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(root);

        if (root.data == value) {
            return true;
        }

        if (findPath(root.left, value, path) || findPath(root.right, value, path)) {
            return true;
        }

        path.remove(root);
        return false;

    }





}   // end class
