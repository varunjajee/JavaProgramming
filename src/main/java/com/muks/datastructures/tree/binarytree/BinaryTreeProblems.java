package com.muks.datastructures.tree.binarytree;

/*
 * Created by mukthar.ahmed on 17/06/15.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BinaryTreeProblems {

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

    public static void printVerticleOrder(BNode root) {
        HashMap<Integer, ArrayList<Integer>> hMap = new HashMap<>();

        int hd = 0;
        verticleOrderTraversal(root, hd, hMap);

        System.out.println(hMap.toString());

    }
}   // end class
