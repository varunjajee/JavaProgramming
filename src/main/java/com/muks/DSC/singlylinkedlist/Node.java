package com.muks.DSC.SinglyLinkedList;

/*
    - Created by mukthar.ahmed on 1/3/16.

    Note:
    - Head and Tail nodes are called "Sentinal" nodes
 */

public class Node<E> {
    public E data;
    public Node next;

    public Node() {}
    public Node(E value) {
        this.data = value;
    }

    public String toString() {
        return "{" + data + "} ";
    }
}
