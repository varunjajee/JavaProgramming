package com.muks.datastructures.tree.binarytree;

/*
 * Created by mukthar.ahmed on 17/06/15.
 */

import java.util.*;

public class BinaryTreeProblems {

    /* ==================================================================================
     Print tree nodes in verticle order
     DFS - Depth First Search
    */
    public static void printVerticleOrder(BNode root) {
        System.out.println("\n# Print Verticle Order Traversal #");
        HashMap<Integer, ArrayList<Integer>> hMap = new HashMap<>();

        int hd = 0;
        verticleOrderTraversal(root, hd, hMap);

        System.out.println("+ Verticle Order: " + hMap.toString() + "\n");
    }

    public static void verticleOrderTraversal(BNode node, int hd,
        HashMap<Integer, ArrayList<Integer>> hMap) {

        if (node == null) {
            return;
        }

        // keep populating hashmap based on the hd distance travelled
        if (hMap.get(hd) == null) {
            hMap.put(hd, new ArrayList(Collections.singleton( node.getValue() )));
        } else {
            hMap.get(hd).add(node.getValue());
        }

        verticleOrderTraversal(node.left, hd-1, hMap);
        verticleOrderTraversal(node.right, hd+1, hMap);

    }

    /* ==================================================================================
     Print tree nodes in level order traversal
    */
    // BFS - Breadth First Search
    public static void printLevelOrder(BNode root) {
        System.out.println("# Print - Level order traversal #");

        HashMap<Integer, ArrayList<Integer>> levelOrderTree = new HashMap<>();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        ArrayList<Integer> nodeValues = new ArrayList<>();

        int vd = 0;
        if(root == null)
            return;

        LinkedList<BNode> current = new LinkedList<>();
        LinkedList<BNode> next = new LinkedList<>();
        current.add(root);

        levelOrderTree.put(vd, new ArrayList<Integer>(root.getValue()));

        while(!current.isEmpty()) {
            BNode node = current.remove();

            if(node.left != null)
                next.add(node.left);

            if(node.right != null)
                next.add(node.right);

            nodeValues.add(node.getValue());
            if(current.isEmpty()) {
                current = next;
                next = new LinkedList<>();
                al.add(nodeValues);

                levelOrderTree.put(vd,  new ArrayList(Collections.singleton( nodeValues )));
                vd++;

                nodeValues = new ArrayList();
            }

        }

        System.out.println("+ All nodes: " + al.toString());
        System.out.println("+ Level Order: " + levelOrderTree.toString());

    }


}   // end class
