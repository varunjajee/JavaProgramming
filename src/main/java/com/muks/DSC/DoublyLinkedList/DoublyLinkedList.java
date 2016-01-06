package com.muks.DSC.DoublyLinkedList;

import com.muks.DSC.linkedlist.LinkedList;

import java.util.NoSuchElementException;

/*
 *  Created by mukthar.ahmed on 1/6/16.
 *
 *  Class having Doubly linked list implementation
 *
 */
public class DoublyLinkedList extends LinkedList {
    private DNode head;
    private DNode tail;
    private DNode previousNode;
    private int size;

    /* Constructor
    	init 2 Sentinal/dummy nodes called (1) header & (2) trailer nodes,
    */
    public DoublyLinkedList() {
        head = tail = null;
    }


    @Override
    public String toString() {
        DNode current = head;

        if (current == null) throw new NoSuchElementException("+ DList is empty.");

        StringBuilder sb = new StringBuilder("+ Doubly Linked List: { -HEAD <-> ");
        while (current.next != null) {
            sb.append(current.data);
            sb.append(" <-> ");
            current = current.next;
        }
        sb.append(current.data + " <-> NULL-");

        return sb.toString();
    }

    @Override
    public void insertDefault(Object value) {
        DNode dnode = new DNode(value);

        if (head == null) {
            System.out.println("+ First node - " + dnode);
            head = tail = dnode;
            head.next = tail;
            tail.previous = head;
            tail.next = null;
        }
        else if (head == tail) {
            tail.next = dnode;
            tail = tail.next;
            tail.next = null;
            tail.previous = head;
        }
        else {
            previousNode = tail;
            tail.next = dnode;
            tail = tail.next;
            tail.next = null;
            previousNode.next = tail;
            tail.previous = previousNode;
        }
        size++;
    }

    @Override
    public void deleteDefault() {

    }

    @Override
    public void deleteNode(int nodeValue) {

    }

    @Override
    public void deleteTail() {

    }



}   // end class
