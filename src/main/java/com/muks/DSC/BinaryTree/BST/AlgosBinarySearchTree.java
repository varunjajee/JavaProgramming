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

            else if (current.right != null) {
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

            // adding to the traverse       map
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

    /*  ==================================================================================
      Level order traversal : Printing nodes at each leve of BST

      // BFS - Breadth First Search
  */
    public static void printLevelOrder(TreeNode root) {
        System.out.println("\n+ Print - Level order traversal.");

        // base case
        if(root == null)
            return;


        // store levels and their node datas
        HashMap<Integer, ArrayList<Integer>> levelOrderTree = new HashMap<>();
        ArrayList<Integer> allNodes = new ArrayList<>();


        // nodes at current level
        Queue<TreeNode> currQ = new LinkedList<>();
        currQ.add(root);

        // nodes at next level
        Queue<TreeNode> nextQ = new LinkedList<>();

        int verticalDepth = 0;  // init tree root level = 0
        levelOrderTree.put(verticalDepth, new ArrayList<Integer>(root.data));

        while(!currQ.isEmpty()) {
            TreeNode node = currQ.remove();

            if(node.left != null)
                nextQ.add(node.left);

            if(node.right != null)
                nextQ.add(node.right);

            allNodes.add(node.data);

            if(currQ.isEmpty()) {
                currQ = nextQ;
                nextQ = new LinkedList<>();

                levelOrderTree.put(verticalDepth, new ArrayList(Collections.singleton(allNodes)));
                verticalDepth++;

                allNodes = new ArrayList();
            }

        }

        System.out.println("+ Level Order: " + levelOrderTree.toString());

    }   // end printLevelOrder()


    /* ==================================================================================
     Print tree nodes in verticle order
     DFS - Depth First Search
    */
//    public static void printVerticleOrder(TreeNode root) {
//        System.out.println("\nPrint Verticle Order Traversal");
//        HashMap<Integer, ArrayList<Integer>> hMap = new HashMap<>();
//
//        int horizDepth = 0;
//        verticleOrderTraversal(root, horizDepth, hMap);
//
//        System.out.println("+ Verticle Order: " + hMap.toString() + "\n");
//    }
//

//    public static void verticleOrderTraversal(TreeNode node, int horizDepth,
//                                              HashMap<Integer, ArrayList<Integer>> hMap) {
//
//        // base case
//        if (node == null) {
//            return;
//        }
//
//        // keep populating hashmap based on the horizDepth distance travelled
//        if (hMap.get(horizDepth) == null) {
//            hMap.put(horizDepth, new ArrayList(Collections.singleton( node.data )));
//        } else {
//            hMap.get(horizDepth).add(node.data);
//        }
//
//        verticleOrderTraversal(node.left, horizDepth-1, hMap);
//        verticleOrderTraversal(node.right, horizDepth+1, hMap);
//
//    }




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


    /* ================================================================================
    (1)  Call Mirror for left-subtree    i.e., Mirror(left-subtree)
    (2)  Call Mirror for right-subtree  i.e., Mirror(right-subtree)
    (3)  Swap left and right subtrees.
          temp = left-subtree
          left-subtree = right-subtree
          right-subtree = temp
     */
    
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


	/* ============================================================================================
	    - Distance(X, Y) = Distance(root, X) + Distance(root, Y) — 2 x (Distance(root to LCA(X,Y) )

	    => Eg:
	        Distance(root, 20) = 2
            Distance(root, 45) = 3
            LCA(20, 45) = 10
            Distance(root, 10) = 1

            Finally => Distance(20,45) = 2+3 — 2*1 = 3
	 */

    public static int findDistanceBtwn2Nodes(TreeNode root, int val1, int val2) {
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        List<TreeNode> path3 = new ArrayList<>();

        findPath(root, val1, path1);
        findPath(root, val2, path2);

        int lca = findLowestCommonAncestor(root, val1, val2);
        findPath(root, lca, path3);

        System.out.println("\n"
                + "+ size-path1: " + path1.size()
                + " - " + "size-path2: " + path2.size()
                + " - " + "size-path3: " + path3.size());

        if (path1.size() == 0 || path2.size() == 0) {
            return -1;
        }

        return path1.size() + path2.size() - 2 * path3.size();

    }   // end


    /* =======================================================================================
        Logic: to fetch path to a given node from root
        - Finds the path from root node to given node of the tree, while traversing, store all
        the traversed nodes into Vector<TreeNode> or List<TreeNode>

        - Return true if path exists otherwise false with returning root node back
     */
    static boolean findPath(TreeNode root, int value, List<TreeNode> path) {
        if (root == null) {
            return false;
        }

        path.add(root);     // Add the node to path traversed List<TreeNode>

        if (root.data == value) { //if found, return true and the list will have all nodes traversed
            return true;
        }

        if (findPath(root.left, value, path) || findPath(root.right, value, path)) {
            return true;
        }

        /* Even till here, if node not found, remove root node as well and
         return empty List<TreeNode> with size = 0
        */

        path.remove(root);
        return false;
    }



    // =========================================================================================
    /*
        Following is simple O(n) algorithm to find LCA of n1 and n2.
            1) Find path from root to n1 and store it in a vector or array.
            2) Find path from root to n2 and store it in another vector or array.
            3) Traverse both paths till the values in arrays are same. Return the common element
            just before the mismatch.
     */
    static int findLowestCommonAncestor(TreeNode root, int p, int q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();

        if (!findPath(root, p, pathP) || !findPath(root, q, pathQ)) {
            return -1;
        }

        /* Compare the paths to get the first different value */
        int i;
        for (i = 0; i < pathP.size() && i < pathQ.size() ; i++) {
            System.out.println(" - " +pathP.get(i) + " = " + pathQ.get(i));
            if (pathP.get(i) != pathQ.get(i)) {
                break;
            }
        }

        return pathP.get(i-1).data;

    }   // end



}   // end class
