//package com.muks.IntrvAlgorithms;
//
///*
// * Created by mukthar.ahmed on 2/10/16.
// */
//public class ChainedLinkedList {
//
//    /*
//
//1 -> 2 -> 3 -> 4
//|         |
//v         V
//9->10     7->20->22
//|
//V
//11->55
//
//Output: given me the flatten list
//
//1->9->11->10->2->3->7->20->22->4
//
//*/
//
//    class Node {
//        int data;
//        boolean isVisisted;
//
//        public Node(int dt) {
//            this.data = dt;
//        }
//    }    // end class
//
//
//    class ChainedTree {
//        Node next;
//        Node chain;
//
//        public ChainedTree() {
//        }
//
//        public void printTree(ChainNode node) {
//            // base case
//            if (node.chain == null && node.next == null) {
//                //System.out.println(node.data);
//                return;
//            }
//
//            if (node.chain == null && node.next != null) {
//                System.out.println(node.next.data);
//                return;
//            }
//            else if (node.chain != null && node.next == null) {
//                System.out.println(node.chain.data);
//                return;
//            }
//
//            System.out.println(node.data);
//            printTree(node.chain);
//            printTree(node.next);
//
//
//
//            System.out.println(node.data);
//            if (node.chain != null) {
//                printTree(node.chain);
//            }
//            else {
//                printTree(node.next);
//            }
//
//
//        }
//
//    } // end class
//}
