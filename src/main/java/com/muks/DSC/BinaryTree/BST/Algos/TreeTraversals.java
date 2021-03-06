package com.muks.DSC.BinaryTree.BST.Algos;

import com.muks.DSC.BinaryTree.BST.BinarySearchTree;
import com.muks.DSC.BinaryTree.BST.MyTrees;
import com.muks.DSC.BinaryTree.BST.TreeNode;

import java.util.*;

/**
 * Created by mukthar.ahmed on 3/25/16.
 * <p>
 * All tree traversal based algorithms
 */
public class TreeTraversals {

    /**
     * Q - Prints all paths to leaf
     * Note:
     * A new array list is created in the recursive calls (Steps 3 and 4) because we do not want to share the same
     * array list in left and right subtree calls as the paths will be different.
     */
    public static void printRootToLeafPaths() {
        TreeNode root = MyTrees.getZigZagTree().root;
        if (root == null) {
            return;
        }
        List<TreeNode> path = new ArrayList<>();
        printRootToLeafPaths(root, path);
    }

    private static void printRootToLeafPaths(TreeNode root, List<TreeNode> path) {
        path.add(root);

        if (root.left == null && root.right == null) {
            System.out.println(path.toString());
            return;
        }
        printRootToLeafPaths(root.left, new ArrayList<>(path));
        printRootToLeafPaths(root.right, new ArrayList<>(path));
    }


    /**
     * // http://www.java2blog.com/2014/08/spiralzigzag-level-order-traversal-of.html
     * Spiral or Zig-Zag order tree traversal
     */
    public static void zigZagView() {
        TreeNode root = MyTrees.getZigZagTree().root;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        boolean directionFlag = true;

        while (!stack.isEmpty()) {
            Stack<TreeNode> tempStack = new Stack<>();

            while (!stack.isEmpty()) {
                TreeNode curr = stack.pop();
                System.out.print(" " + curr.data);     /** print here */

                if (!directionFlag) {
                    if (curr.left != null) {
                        tempStack.add(curr.left);
                    }

                    if (curr.right != null) {
                        tempStack.add(curr.right);
                    }

                } else {
                    if (curr.right != null) {
                        tempStack.add(curr.right);
                    }

                    if (curr.left != null) {
                        tempStack.add(curr.left);
                    }
                }
            }

            directionFlag = !directionFlag;     /** Flip direction flag */
            System.out.println("\nTemp peel=" + tempStack.toString());
            stack = tempStack;
            System.out.println("\nStack = " + stack.toString());
        }
    }


    /**
     * Given a binary tree, print the left view
     * global variable "MAX"
     */
    private static int MAX = 0;             // IMPORTANT variable

    public static void printLeftView(TreeNode root) {
        System.out.println("+ Printing left view: ");

        int startLevel = 1;
        leftViewUtil(root, startLevel);
    }

    private static void leftViewUtil(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        //System.out.println("+ Max = " + MAX + ", Level = " + level);
        if (MAX < level) {
            System.out.print(" " + node);
            MAX = level;
        }

        leftViewUtil(node.left, level + 1);
        leftViewUtil(node.right, level + 1);
    }


    /**
     * =============================================================================================
     * Given a binary tree, print the RIGHT view
     * <p>
     * global variable "MAX"
     */
    static int MAX_LEVEL = 0;

    public static void printRightView(TreeNode root) {
        System.out.println("+ Printing right view: ");

        int startLevel = 1;
        rgtViewUtil(root, startLevel);
    }

    private static void rgtViewUtil(TreeNode node, int level) {
        if (node == null) {
            return;
        }

        if (MAX_LEVEL < level) {
            System.out.print(" " + node);
            MAX_LEVEL = level;
        }

        rgtViewUtil(node.right, level + 1);
        rgtViewUtil(node.left, level + 1);
    }


    /**
     * Printing bottom view and top view of a binary tree
     * <p>
     * Logic is same for both top and bottom view.
     * <p>
     * TOP view - add ONLY first visited node to the map
     * BOTTOM view - keep over writing the node to the map val so that only the last visited node is available
     */
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

            if (!map.containsKey(hd)) {
                map.put(hd, current.data);
                System.out.println("+ current = " + current.data + ", hd = " + hd);
            }

            if (current.left != null) {
                current.left.hd = hd - 1;
                queue.add(current.left);

            }

            if (current.right != null) {
                current.right.hd = hd + 1;
                queue.add(current.right);
            }
        }

        System.out.println(map.toString());
    }

    public static void printBottomView(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeMap<Integer, Integer> mapTopView = new TreeMap<>();

        // create a Queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();

        int hd = 0;         // add root with level 0 (create a Queue item pack)
        root.hd = hd;
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode tnode = queue.remove();

            hd = tnode.hd;

            System.out.print(tnode.data + "   ");
            mapTopView.put(hd, tnode.data);

            // add the left and right children of visiting nodes to the Queue
            if (tnode.left != null) {
                tnode.left.hd = hd - 1;
                queue.add(tnode.left);
            }
            if (tnode.right != null) {
                tnode.right.hd = hd + 1;
                queue.add(tnode.right);
            }
        }

        System.out.println(mapTopView.toString());

    }


    /**
     * Logic:
     *  - logic for both, level and vertical order traversal, remains same
     *      - based on queue and breadth first traversal
     *
     *  - Level Order = increment at (curr.left.vd = curr.vd + 1) & (curr.right.vd = curr.vd + 1)
     *  - Vertical Order = (curr.left.hd = curr.left - 1) & (curr.right.hd = curr.hd + 1)
     *
     */
    public static void LevelOrderTraversal(TreeNode root) {

        HashMap<Integer, List<TreeNode>> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        int vd = 0;

        root.vd = 0;
        queue.add(root);

        while ( !queue.isEmpty() ) {
            TreeNode curr = queue.remove();
            vd = curr.vd;

            if ( map.containsKey(vd) ) {
                map.get(vd).add(curr);
            }
            else {
                map.put(vd, new ArrayList(Collections.singleton(curr)));
            }


            if (curr.left != null) {
                curr.left.vd = curr.vd + 1;
                queue.add(curr.left);
            }

            if (curr.right != null) {
                curr.right.vd = curr.vd + 1;
                queue.add(curr.right);
            }
        }

        System.out.println("# Queue: " + map.toString());
    }


    public static void verticcalOrderTraversal(TreeNode root) {

        HashMap<Integer, List<TreeNode>> map = new HashMap<>();

        Queue<TreeNode> queue = new LinkedList<>();
        int hd = 0;

        root.hd = hd;
        queue.add(root);

        while ( !queue.isEmpty() ) {
            TreeNode curr = queue.remove();
            hd = curr.hd;

            if ( map.containsKey(hd) ) {
                map.get(hd).add(curr);
            }
            else {
                map.put(hd, new ArrayList(Collections.singleton(curr)));
            }

            if (curr.left != null) {
                curr.left.hd = curr.hd - 1;
                queue.add(curr.left);
            }
            if (curr.right != null) {
                curr.right.hd = curr.hd + 1;
                queue.add(curr.right);
            }
        }

        System.out.println("# Map: " + map.toString() );

    }

    /*  ============================= Depth first traversal ================================ */
    public static void DepthFirstSearch(TreeNode root) {
        System.out.println("\n+ Print - Depth First Search");

        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            System.out.println(node.data + " ");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

    }

    /**
     * Preorder or DFS - Depth first
     */
    public static void dfs(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");

        dfs(root.left);
        dfs(root.right);
    }


    /*  ================================================================================== */
    public static void BreadthFirst(TreeNode root) {
        System.out.println("\n\n+ Breadth First Search + ");
        if (root == null) {
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.remove();

            System.out.print(curr.data + " ");
            if (curr.left != null) {
                queue.add(curr.left);
            }
            if (curr.right != null) {
                queue.add(curr.right);
            }
        }

    }

    /**
     * =========================================================================================
     * Iteratively print tree in post order manner
     */
    public static void postOrderTraverseIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();

        TreeNode current = root;
        while (current != null || stack.size() > 0) {
            if (current != null) {
                stack.add(current);
                current = current.right;
            } else {
                current = stack.pop();
                System.out.println(current.data);
                current = current.left;
            }
        }
    }


    static class PrintBoundryOfTree {
        /** Answer: 20 8 22 4 10 14 25
         * */

        public static void printBoundry(BinarySearchTree bst) {
            System.out.println("\n Boudary traversal...");
            if (bst.root != null) {
                System.out.print(" " + bst.root.data);
                printLeftmostNodes(bst.root.left);
                printRightmostNodes(bst.root.right);
                printLeafNodes(bst.root);
            }
        }

        public static void printLeftmostNodes(TreeNode node) {
            if (node != null) {
                if (node.left != null) {
                    System.out.print(" " + node.data);
                    printLeftmostNodes(node.left);
                }
                else if (node.right != null){
                    System.out.print(" " + node.data);
                    printLeftmostNodes(node.right);
                }

                /** Do not print leaf else it will be duplicate print */
            }

        }
        private static void printRightmostNodes(TreeNode node) {

            if (node !=  null) {
                if (node.right != null) {
                    System.out.print(" " + node.data);
                    printRightmostNodes(node.right);
                }
                else if (node.left != null) {
                    System.out.print(" " + node);
                    printRightmostNodes(node.left);
                }
            }
        }

        private static void printLeafNodes(TreeNode node) {
            if (node == null) {
                return;
            }

            if (node.left == null && node.right == null) {
                System.out.print(" " + node.data);
            }

            printLeafNodes(node.left);
            printLeafNodes(node.right);
        }
    }

    /**
     * Function to print corner node at each level
     *  - Same as print boundary question but does it in 1 pass
     */
    static void printBoundrySingleTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);    // null node to mark as separator between levels

        boolean isFirst = false;    // if isFirst = true then left most node of that level will be printed
        boolean isOne = false;      // if isOne = true then that level has only one node
        int last = 0;               // last will store right most node of that level   */

        // Do level order traversal of Binary Tree
        while (!queue.isEmpty()) {

            TreeNode temp = queue.remove();             // dequeue the front node from the queue

            // if isFirst is true, then temp is leftmost node
            if ( isFirst ) {
                System.out.print(" " + temp.data);

                if (temp.left != null)
                    queue.add(temp.left);

                if (temp.right != null)
                    queue.add(temp.right);

                // make isFirst as false and one = 1
                isFirst = false;
                isOne = true;
            }

            // Else if temp is a separator between two levels
            else if (temp == null) {
                if (queue.size() >= 1)
                    queue.add(null);    /** inserting level separator */

                /** first node = true because next node will be leftmost node of that level */
                isFirst = true;

                // printing last node, only if that level
                // doesn't contain single node otherwise
                // that single node will be printed twice
//                if (!isOne)
                System.out.print(" " + last);
            }
            else {
                last = temp.data;   // Store current key as last

                // Here we are making isOne = false to signify that level has more than one node
                isOne = false;
                if (temp.left != null) {
                    queue.add(temp.left);
                }

                if (temp.right != null) {
                    queue.add(temp.right);
                }
            }
        }
    }


}
