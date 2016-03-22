package com.muks.DSC.BinaryTree.BST;

import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * Created by mukthar.ahmed on 3/23/16.
 * BST based additional interview questions
 */
public class BstInterviewQuestions {

    public static void printDiagonalSum(TreeNode root) {

        HashMap<Integer, List<TreeNode>> nodeList = new HashMap<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();

        int vd = 0; /** root.vd = 0 */
        root.vd = 0;

        queue.add(root);

        while ( !queue.isEmpty() ) {
            TreeNode curr = queue.remove();
            vd = curr.vd;
            
            while (curr != null) {
                int prevSum = (map.get(vd) == null) ? 0 : map.get(vd);
                map.put(vd, prevSum + curr.data);

                if (nodeList.get(vd) == null) {
                    nodeList.put(vd, new ArrayList<>(Arrays.asList(curr)));
                } else {
                    nodeList.get(vd).add(curr);
                }

                if (curr.left != null) {
                    curr.left.vd = vd + 1;
                    queue.add(curr.left);
                }

                curr = curr.right;
            }


        }

        System.out.println("+ Diagonal Sum Map: " + map.toString());
        System.out.println("+ Diagonal Nodes Map: "+ nodeList.toString());
    }
}
