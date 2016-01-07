package com.muks.DSC.DoublyLinkedList;

import com.muks.DSC.LinkedList.LinkedList;

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
    private static int size;

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


    /*  ========================================================================================
        Non default action : Inserting the value at head and move head to previous */

    public boolean insertAtHead(Object value) {
        DNode dNode = new DNode(value);

        if (head == null) {
            System.out.println("+ First node - " + dNode);
            head = tail = dNode;
            head.next = tail;
            tail.previous = head;

            tail.next = null;
            head.previous = null;
        }
        else {
            DNode movingPointer = head;
            head.previous = dNode;
            head = head.previous;
            head.next = movingPointer;
            head.previous = null;
        }

        size++;         // size counter

        return true;
    }   // end insert

    /*  =======================================================
        Assigned to default is - Inserting the node at the after the tail node
     */
    @Override
    public void insertDefault(Object value) {
        DNode dnode = new DNode(value);

        if (head == null) {
            System.out.println("+ First node - " + dnode);
            head = tail = dnode;
            head.next = tail;
            tail.previous = head;
            tail.next = null;
            head.previous = null;
        }
        else {
            previousNode = tail;
            tail.next = dnode;
            tail = tail.next;
            tail.next = null;
            previousNode.next = tail;
            tail.previous = previousNode;
        }

        size++;     // size counter

    }   // end insert



    @Override
    public void deleteDefault() {
        DNode prev = tail.previous;
        tail = tail.previous;
        tail.next = null;
    }

    @Override
    public void deleteNode(int nodeValue) {
        DNode curr = head;

        DNode prev = null;
        while (curr != null && (Integer) curr.data != nodeValue) {
            prev = curr;
            curr = curr.next;
        }

        prev.next = curr.next;
        curr.next.previous = prev;
    }

    @Override
    public void deleteTail() {
        // as same as default delete.
    }


    /*  ======================================================================================
        Reverse a doubly linked list

        Steps:
        (1) init a temp node
        (2) curr = head
        (3) while curr != null ->
        (4) assign -> tmp = with curr.prev
        (5) curr.prev = curr.next           -> swaping links
        (5) curr.next = tmp                 -> assign back the next pointer or re-establish
        (6) advance curr pointer

     */
    public static void reverseDLL(DoublyLinkedList list) {
        if (list.head == null) throw new NoSuchElementException("+ List is empty.");

        DNode tmp = null;
        DNode current = list.head;


        int i = 1;
        //Go until the end of the list is reached
        while (current !=  null) {          // Step - 2
            //Update temp to remember what came before the current node
            tmp = current.previous;         // Step - 3 (vice-versa gives ERROR)

            System.out.println("\n+ temp = " + tmp +
                    " : curr.p = curr.next : " + current.previous + " = " + current.next);
            current.previous = current.next;    // Switch the previous and next pointers
            current.next = tmp;

            System.out.println("+ temp = " + tmp +
                    " : curr.p = curr.next : " + current.previous + " = " + current.next);

            //Advance current to point to the next node in the list, which is now stored in
            // current.prev
            current = current.previous;


            if (tmp != null) {
                System.out.println("Temp = " + tmp.data);
                System.out.println("+ New Head = " + tmp.previous);
                list.head = tmp.previous;
            }

        }

        System.out.println("-- " + list.toString());
    }


    public int getSize() {
        return size;
    }



}   // end class
