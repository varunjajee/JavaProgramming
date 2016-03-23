package com.muks.DSC.BinaryTree.BST;

import apple.laf.JRSUIUtils;

import java.util.*;

/**
 * Created by mukthar.ahmed on 3/23/16.
 * BST based additional interview questions
 */
public class BstInterviewQuestions {

    public static void printDiagonalSum(TreeNode root) {
        System.out.println("\n=== Printing diagonal sum ====");
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


    /** Amazon intrv, find the path which has the sum of a given number
     * Eg: if sum = 22, sum of all the nodes traversed should be = 22
     * */
    public static boolean hasPathSum(TreeNode node, int sum) {
        if (node == null) { return false; }

        if ( node.data == sum && (node.left == null & node.right == null) ) {
            return true;
        }

        return hasPathSum(node.left, sum - node.data) || hasPathSum(node.right, sum - node.data);
    }


    static int minSumPath(TreeNode node) {
        if (node == null) { return 0; }

        int sum = node.data;

        int left_sum = minSumPath(node.left);
        int right_sum = minSumPath(node.right);

        if (left_sum >= right_sum) {
            sum += minSumPath(node.left);

        } else {
            sum += minSumPath(node.right);

        }

        return sum;
    }


    /** Print the path leading to max sum in a binary tree
     *  Logic:
     *      Keep track of maxSum till now and node leading to max sum
     * */
    static class MaxSumPath {
        int maxSum = 0;
        TreeNode maxLeaf = null;

        public void getMaxSumPath(TreeNode root) {
            maxSum(root, 0);
            path(root, maxLeaf);
        }

        public void maxSum(TreeNode root, int sum) {
            if (root != null) {
                sum = sum + root.data;
                if (sum > maxSum && root.left == null && root.right == null) {
                    maxLeaf = root;
                    maxSum = sum;
                }
                //	System.out.println("Sum " + sum);
                maxSum(root.left, sum);
                maxSum(root.right, sum);
            }
        }

        public Boolean path(TreeNode root, TreeNode leaf) {
            if (root == null) return false;
            if ((root == leaf) || path(root.left, leaf) || path(root.right, leaf)) {
                System.out.print(" " + root.data);
                return true;
            }
            return false;
        }

    }
}
