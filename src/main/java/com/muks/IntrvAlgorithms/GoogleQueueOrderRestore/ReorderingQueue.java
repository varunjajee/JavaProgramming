package com.muks.IntrvAlgorithms.GoogleQueueOrderRestore;

import java.util.Arrays;
import java.util.Comparator;

/**
    Link = http://stackoverflow.com/questions/19174796/puzzle-find-the-order-of-n-persons-standing-in-a-line-based-on-their-heights
 * Created by mukthar.ahmed on 2/15/16.

     Solution:
        - Sort input people based on height

        - Use rope data structure with the below rules;
          It's like a binary tree except that each node maintains the number of nodes in the left
          subtree+1 for itself. Whenever a new number is inserted, if the value is smaller than
          the node's node-Value it goes to the left otherwise right. When it goes to the right,
          the value of the node is decreased by the value of the branch node.


        Code logic:
        - For each person being added as rope node;
            - If curr node value < root node value; then added the node to left and increment
              root node value

            - else;
                 if root.right == null; just add the node
                 or
                 recurse with



 */
public class ReorderingQueue {

    public static void main(String[] args) {
        // Raw Input # 2
        int[][] queue = { {6, 0},  {4, 0}, {3, 2}, {2, 2}, {1, 4}, {5, 0} };

        /**
         * int[] heights = {6, 4, 3, 2, 1, 5};
         * int[] frontCounts = {0, 0, 2, 2, 4, 0};
         */

        initPeople(queue);

    }   // end main



    /* Sorting 2 dimentional array */
    public static int[][] sortQueue(int[][] queue) {
        Arrays.sort(queue, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o2[0], o1[0]);
            }
        });

        return queue;
    }


    // Root method to get the ordering
    // private static void initPeople(int[] heights, int[] frontCount) {
    private static void initPeople(int[][] queue) {

        Sorting.reverseSort(queue);     // reverse sort the entire queue based on height

        // Create Person objects from their heights and front-count
        Person[] people = new Person[queue.length];
        for (int i = 0; i < queue.length; i++) {
            people[i] = new Person(queue[i][0], queue[i][1]);
        }

        for (int i = 0; i < people.length; i++) {
            System.out.print(" " + people[i].toString());
        }

        // Push people/Person objects to rope
        RopeNode root = new RopeNode(people[0]);
        for (int i = 1; i < people.length; i++) {
            insert(root, people[i]);
        }


        System.out.println("\n\n" + root.toString());
        System.out.println(root.left.toString());
        System.out.println(root.left.right.toString());

//        System.out.println("\n" + root.toString());
//        System.out.println("\n" + root.toString());
//        System.out.println("\n" + root.toString());
//        System.out.println("\n" + root.toString());
//        System.out.println("\n" + root.toString());

        System.out.println("+ Final queue ordering is : ");
        inorderTraversal(root);

    }

    /* Simple in-order traversal */
    private static void inorderTraversal(RopeNode node) {
        if (node == null) return;

        inorderTraversal(node.left);
        System.out.print( " " + node.person.height );
        inorderTraversal(node.right);

    }

    /* Inserting into rope */
    private static void insert(RopeNode root, Person p) {
        insert(root, p, p.frontCount);
    }

    private static void insert(RopeNode root, Person p, int nodeValue) {
        if (nodeValue < root.nodeValue) {
            if (root.left == null)
                root.left = new RopeNode(p);

            else
                insert(root.left, p, nodeValue);

            root.nodeValue++;   // increment the node value to counter the number of child nodes
        }
        else {
            if (root.right == null)
                root.right = new RopeNode(p);

            else
                insert(root.right, p, nodeValue - root.nodeValue);
        }
    }


    /* RopeNode class to have the node object */
    static class RopeNode {
        int nodeValue;
        Person person;
        RopeNode left, right;

        public RopeNode(Person p) {
            this.nodeValue = 1;
            this.person = p;
        }

        public String toString() {
            return "[pH: " + person.height
                    + ", pFC: " + person.frontCount
                    + ", NodeValue: " + nodeValue + "]";
        }
    }

    /* Generating Person class */
    static class Person {
        int height;
        int frontCount;

        public Person(int h, int fc) {
            this.height = h;
            this.frontCount = fc;
        }

        public String toString() {
            return "(H: " + height + ", FC: " + frontCount + ")";
        }
    }

}   // end class
