package com.muks.DSC.SinglyLinkedList;

/*
    - Created by mukthar.ahmed on 1/3/16.

    Note:
    - Head and Tail nodes are called "Sentinal" nodes
 */

public class Node {
    public Object data;
    //public Node first;
    public Node next;

    public Node() {}
    public Node(Object value) {
        this.data = value;
    }

    public String toString() {
        return "{" + data + "} ";
    }
}
