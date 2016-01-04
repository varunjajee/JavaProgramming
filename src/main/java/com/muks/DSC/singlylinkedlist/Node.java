package com.muks.DSC.singlylinkedlist;

/*
 * Created by mukthar.ahmed on 1/3/16.
 */
public class Node {
    public Object data;
    public Node first;
    public Node next;

    public Node(Object value) {
        this.data = value;
    }

    public String toString() {
        return "{" + data + "} ";
    }
}
