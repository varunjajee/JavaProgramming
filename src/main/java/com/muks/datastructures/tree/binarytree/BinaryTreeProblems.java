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
        HashMap<Integer, ArrayList<Integer>> hMap = new HashMap<>();

        int hd = 0;
        verticleOrderTraversal(root, hd, hMap);

        System.out.println(hMap.toString());
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
    public static void printLevelOrder(BNode root) {
        if (root == null) return;

        Queue<BNode> queue = new LinkedList<>();


    }


    /* ==================================================================================
     Print tree nodes in level order traversal
    */
    // BFS - Breadth First Search
    public static void levelOrderTraversal(BNode root) {
        System.out.println("+ Level order traversal:");
        HashMap<Integer, ArrayList<Integer>> hMap = new HashMap<>();
        int vd = 0; // vd = verticle distance or level

        if (root == null) {
            System.out.println("+ Tree is EMPTY.");
        }
        else {

            Queue<BNode> queue = new LinkedList<BNode>();
            queue.add(root);
            if (hMap.get(vd) == null) {
                hMap.put(vd, new ArrayList<Integer>(root.getValue()));
            } else {
                hMap.get(vd).add(root.getValue());
            }

            while (queue.peek() != null) {
                vd++;
                // remove() and poll() are same just that remove() throws exception when queue is empty
                BNode tmpNode = queue.remove();
                System.out.println(tmpNode.getValue());

                if (hMap.get(vd) == null) {
                    hMap.put(vd, new ArrayList<Integer>(tmpNode.getValue()));
                } else {
                    hMap.get(vd).add(tmpNode.getValue());
                }

                if (tmpNode.left != null) {
                    queue.add(tmpNode.left);
                    hMap.get(vd).add(tmpNode.left.getValue());
                }

                if (tmpNode.right != null) {
                    queue.add(tmpNode.right);
                    hMap.get(vd).add(tmpNode.right.getValue());
                }


            }
        }

        System.out.println("+ Final output: " + hMap.toString());
    }



}   // end class
