package com.muks.DSC.BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * Created by mukthar.ahmed on 1/7/16.
 */
public class AlgosBinarySearchTree {

    /* ==================================================================================
     Print tree nodes in verticle order
     DFS - Depth First Search
    */
    public static void printVerticleOrder(TreeNode root) {
        System.out.println("\n# Print Verticle Order Traversal #");
        HashMap<Integer, ArrayList<Integer>> hMap = new HashMap<>();

        int hd = 0;
        verticleOrderTraversal(root, hd, hMap);

        System.out.println("+ Verticle Order: " + hMap.toString() + "\n");
    }

    public static void verticleOrderTraversal(TreeNode node, int hd,
                                              HashMap<Integer, ArrayList<Integer>> hMap) {

        if (node == null) {
            return;
        }

        // keep populating hashmap based on the hd distance travelled
        if (hMap.get(hd) == null) {
            hMap.put(hd, new ArrayList(Collections.singleton( node.data )));
        } else {
            hMap.get(hd).add(node.data);
        }

        verticleOrderTraversal(node.left, hd-1, hMap);
        verticleOrderTraversal(node.right, hd+1, hMap);

    }

    /* ==================================================================================
     Print tree nodes in level order traversal
    */
    // BFS - Breadth First Search
    public static void printLevelOrder(TreeNode root) {
        System.out.println("# Print - Level order traversal #");

        HashMap<Integer, ArrayList<Integer>> levelOrderTree = new HashMap<>();
        ArrayList<ArrayList<Integer>> al = new ArrayList<>();
        ArrayList<Integer> nodeValues = new ArrayList<>();

        int vd = 0;
        if(root == null)
            return;

        LinkedList<TreeNode> current = new LinkedList<>();
        LinkedList<TreeNode> next = new LinkedList<>();
        current.add(root);

        levelOrderTree.put(vd, new ArrayList<Integer>(root.data));

        while(!current.isEmpty()) {
            TreeNode node = current.remove();

            if(node.left != null)
                next.add(node.left);

            if(node.right != null)
                next.add(node.right);

            nodeValues.add(node.data);
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


}
