package com.muks.IntrvAlgorithms.ChainedLinkedList;

/*
 * Created by mukthar.ahmed on 2/10/16.

    1 -> 2 -> 3 -> 4
    |         |
    v         V
    9->10     7->20->22
    |
    V
    11->55

    Output: given me the flatten list

    1->9->11->10->2->3->7->20->22->4

 */

public class ChainedLinkedList {

    ChainNode head, tail;
    ChainNode next;

    public ChainedLinkedList() {}

    public void insert(int val) {
        ChainNode newNode = new ChainNode(val);
        newNode.next = null;

        if (head == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public ChainNode getNode(int val) {
        ChainNode curr = head;
        while (curr != null && curr.data != val) {
            curr = curr.next;
        }

        return curr;
    }

    public void print() {
        StringBuilder sb = new StringBuilder();
        ChainNode curr = this.head;
        while (curr != null) {
            sb.append(" -> " + curr.data);
            curr = curr.next;
        }
        System.out.println("\nLinkedlist: " + sb.toString());
    }

    public static void main(String[] args) {
        ChainedLinkedList mainList = new ChainedLinkedList();
        mainList.insert(1);
        mainList.insert(2);
        mainList.insert(3);
        mainList.insert(4);
        mainList.print();

        ChainedLinkedList chain1 = new ChainedLinkedList();
        chain1.insert(9);
        chain1.insert(10);
        chain1.print();

        // Chain (1) of main to next link head
        System.out.println("+ getNode(" + mainList.getNode(1).data + ")");
        mainList.getNode(1).chainedHead = chain1.head;

        ChainedLinkedList chain2 = new ChainedLinkedList();
        chain2.insert(11);
        chain2.insert(55);
        chain2.print();


        System.out.println("+ getNode(" + chain1.getNode(9).data + ")");
        chain1.getNode(9).chainedHead = chain2.head;


        ChainedLinkedList chain3 = new ChainedLinkedList();
        chain3.insert(7);
        chain3.insert(20);
        chain3.insert(22);
        chain3.print();

        System.out.println("+ getNode(" + mainList.getNode(3).data + ")");
        mainList.getNode(3).chainedHead = chain3.head;


        System.out.println("+ Running DFS: ");
        depthFirstTraversal(mainList.head);

    }

    public static void depthFirstTraversal(ChainNode node) {
        if (node == null) return;

        System.out.println(node.data);
        depthFirstTraversal(node.chainedHead);
        depthFirstTraversal(node.next);
    }



    class ChainNode {
        int data;
        ChainNode next;
        ChainNode chainedHead;

        public ChainNode(int dt) {
            this.data = dt;
        }
    }

} // end class

