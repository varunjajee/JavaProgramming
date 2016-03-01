package com.muks.DSC.DoublyLinkedList;

/*
 * Created by mukthar.ahmed on 1/6/16.
 */

import com.muks.DSC.singlylinkedlist.Node;

public class DNode extends Node{
    public Object data;
    public DNode next;
    public DNode previous;

    public DNode(Object value) {
        data = value;
    }

    public String toString() { return "{" + data + "} "; }
}
