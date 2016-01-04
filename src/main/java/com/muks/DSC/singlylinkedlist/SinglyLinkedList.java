package com.muks.DSC.singlylinkedlist;

import java.util.List;
import java.util.NoSuchElementException;

/*
 * Created by mukthar.ahmed on 1/3/16.
 */
public class SinglyLinkedList {
    public Node head;
    public Node tail;

    /* Forcing a constructor to init head and tail variables */
    public SinglyLinkedList() {
        head = tail = null;
    }

    /*  Constructor creating linked list out of data values */
    public SinglyLinkedList(List<Object> linkedListData) {
        for ( Object val : linkedListData ) {
            this.insertDefault(val);
        }
    }


    // print entire linked list
    public String toString() {
        Node current = head;       // try to get head by using instance object 'this.head'

        if (current == null) {
            return "List is empty!";
        }

        StringBuilder sb = new StringBuilder("\nDisplay LinkedList: [ -HEAD -> ");
        while ( current != null ) {
            sb.append(current.data + " -> ");
            current = current.next;
        }

        sb.append("NULL");

        return sb.toString() + "- ]";

    } // end printLink()


    /* Insert node or create linked list */
    public void insertDefault(Object value) {
        Node node = new Node(value);
        node.next = null;

        if(head == null) {
            head = tail = node;
            System.out.println("Linked list created/initiated successfully!");
        }
        else {
            tail.next = node;
            tail = node;
            tail.next = null;
            System.out.println("Node inserted successfully!");
        }
    }


    /* insert in between */
    public void addNodeAfter(SinglyLinkedList linkedList, int toInsertAfter, Object nodeValue) {
        System.out.println("\nAdding another node after " + toInsertAfter);
        if (linkedList.head == null) {
            throw new NoSuchElementException("Linked List Empty Exception.");
        }

        Node current = linkedList.head;

        while (current.next != null) {
            if ( (Integer) current.data == toInsertAfter ) {
                System.out.println("- found - Current: " + current.data.toString());

                Node nodeToAdd = new Node(nodeValue);

                Node nextNode = current.next;
                current.next = nodeToAdd;
                current.next.next = nextNode;

            }
            else if (current.next == null) {    // reached end and still not found the value
                throw new NoSuchElementException("+ Search node not found.");

            }
            current = current.next;
        }
    }


    /* Insert node or create linked list */
    public void deleteByDefault() {     // this deletes tail node by default
        Node current = head;
        Node previous = null;

        if (head == null) {
            throw new NoSuchElementException("Linked List Empty Exception.");
        }
        else {
            while (current.next != null) {
                previous = current;
                current = current.next;
            }

            tail = previous;
            previous.next = null;

            System.out.println("Dropping node: " + previous.data);
        }
    }


    /* Finding the tail of the linked list. */
    public static Node findTail(Node first) {
        Node currentLink = first;

        if (currentLink.next == null) return currentLink;   // Logic: Tail is a point
        return findTail(currentLink.next); // recursive statement

    } // end findTail


    /* return the size by recursive */
    public int size(Node currentNode) {
        if (currentNode == null) return 0;
        return 1 + size(currentNode.next);
    }


    /* delete head node */
    public void deleteHead() {
        head = head.next;
        return;
    }


    /* Delete tail node */
    public void deleteTail() {
        Node current = head;
        Node previous = null;

        while (current.next != null) {
            previous = current;
            current = current.next;
        }

        previous.next = null;
    }


    /* Delete a node */
    public void deleteNode(int nodeDataToDrop) {

        Node current = head;
        Node previous = null;
        Node nextToNext = null;

        if (head == null) {
            throw new NoSuchElementException("+ Linked List Empty Exception.");
        }
        else if (head.next == null && (Integer) head.data == nodeDataToDrop) {
            head = null;
        }
        else if ((Integer) head.data == nodeDataToDrop) {
            this.deleteHead();
        }
        else {
            previous = current;
            current = current.next;
            nextToNext = current.next;

            while (current != null) {
                if ((Integer) current.data == nodeDataToDrop) {
                    previous.next = nextToNext;
                    return;
                }

                previous = current;
                current = current.next;
                if (current.next == null) {
                    throw new NoSuchElementException("+ Node Not Found Exception.");
                }
                nextToNext = current.next;
            }
        }

    }   // end deleteNode()


    /* ####### Additional Linked List Algo #######*/
    public static void makeIntersectingList(SinglyLinkedList mainList,
                                     SinglyLinkedList subList,
                                     int joinNode) {

        System.out.println("= Intersecting 2 lists..." + subList.tail.data);

        Node current = mainList.head;
        while (current.next != null) {
            if ((Integer) current.data == joinNode) {
                subList.tail.next = current;
            }

            current = current.next;
        }

    }   // end method


    // main logic of getting intersection point
    public static void getIntersectionPoint(SinglyLinkedList mainList, SinglyLinkedList subList) {
		/* 	Time complexity: O(m+n)
		 * 	Implementation details:
			1) Get count of the nodes in first list, let count be c1.
			2) Get count of the nodes in second list, let count be c2.
			3) Get the difference of counts d = abs(c1 � c2)
			4) Now traverse the bigger list from the first node till d nodes so that from here onwards both the lists have equal no of nodes.
			5) Then we can traverse both the lists in parallel till we come across a common node. (Note that getting a common node is done by comparing the address of the nodes)
		 */


        int sizeList1 = mainList.size(mainList.head);
        int sizeList2 = subList.size(subList.head);

        int d;
        if (sizeList1 > sizeList2) {
            d = sizeList1 - sizeList2;
            intersectingPoint(d, subList, mainList);
        } else {
            d = sizeList2 - sizeList1;
            intersectingPoint(d, mainList, subList);
        }

    }


    /* Get the point of intersection */
    public static boolean intersectingPoint(int diff, SinglyLinkedList mainList, SinglyLinkedList
            subList) {
        boolean isIntersecting = false;

        System.out.println("\nFinding intersection point of to linked lists." +
                "\n(1) " + mainList.toString() +
                "\n(2) " + subList.toString());

        Node current1 = mainList.head;
        for (int i = 0; i <= diff; i++) {
            current1 = current1.next;
        }

        if (subList.tail.next == current1) {
            System.out.println("+ Found the intersection point => " + current1);
            isIntersecting = true;
        } else {
            System.out.println("+ NO intersection of linked lists is found.");
        }

        return isIntersecting;
    }


    /* ######## ALGO: Reverse a linked list ####### */

    /* ========================================================================================
        Reverse linked list in iterative manner - reversing links
     */
    public static void reverse(SinglyLinkedList linkedList) {
        System.out.println("\n Reversing given linked list - "  + linkedList.toString());

        if (linkedList.head == null) {
            throw new NoSuchElementException("+ Linked List Empty Exception");
        }

        if (linkedList.head.next == null) {
            System.out.println("+ Single node linked list, skip reversing.");
        }

        Node newTail = null;
        Node current = linkedList.head;
        Node nextNode;
        while (current.next != null) {

            nextNode = current.next;
            System.out.println("Next: " + nextNode);

            current.next = newTail;
            newTail = current;
            current = nextNode;
            System.out.println("Current: " + current + ", NewTail: " + newTail);
        }
        current.next = newTail;

        linkedList.head = current;  // This line is important coz headless list will not be reversed

        System.out.println(linkedList.toString());
    }


    public void recursiveReverse(Node curr) {
        /* base case to terminate recursion
           Step 1 : If current is null, then its reverse of itself */
        if ( curr == null) {
            return;
        }

        /* Step 2 : If current.next = null, then we've reached tail and set tail element to head */
        if (curr.next == null) {
            head = curr;
            return;
        }

        /* Step 3 : traverse the entire list pushing it to stack */
        recursiveReverse(curr.next);

        // curr.next still points to the last element of reversed sub-list.
        // so move the curr to end.
        curr.next.next = curr;

        // point last curr to nil, (get rid of cycles)
        curr.next = null;

    }

}
