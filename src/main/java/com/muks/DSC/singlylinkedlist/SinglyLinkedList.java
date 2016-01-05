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


    /* Check if empty */
    public boolean isEmpty(Node headNode) {
        return head == null;
    }


    /* print entire linked list */
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






    // ############# ############# ############# ############# ############# ###############
    /*  ====================================================================================
        Singly linked list based algorithms
     */
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


    /* ==========================================================================================
        Recursively , reverse a linked list.
     */
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


    /*  By recursion - Find tail node */
    public static Node findTailRecursively(Node current) {
        // base case, return the node if node.next == null (which is the tail)
        if (current.next == null)
            return current;

        return findTailRecursively(current.next);
    }


    /* Make a singly linked list as a cyclic linked list.*/
    public static void makeCyclicLinkedList(Node headNode, int cyclicAt) {
        System.out.println("\nCircular Linked List: Interconnecting a linked list for circular");

        Node current = headNode;
        Node loopNode = null;
        Node tailNode = findTail(headNode);

        int count = 3;
        while (current.next != null) {
            count--;
            if (count == 0) {
                loopNode = current;
                break;
            }

            //System.out.println("+++ Tail: " + current.data1);
            current = current.next;
        }

        tailNode.next = loopNode;
        System.out.println(loopNode.data + "; loop next: " + tailNode.next.data);

    }


    /*  ========================================================================================
        (1) Find if linked list is circular or not
        (2) Find the meeting point
        (3) Find the start and end point of the circular linked list.
     */
    public static void circularLinkedListMeetingPoint(SinglyLinkedList linkedList) {
        System.out.println("+ Determining a circular linked list");
        Node p1 = linkedList.head;  // SLOW moving pointer
        Node p2 = linkedList.head;  // FAST moving pointer

        while (p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;

            if (p1 == p2) {     // this determines the circular point of a linked list
                break;
            }
        }

        // find the start and end point of the circular linked list
        p1 = linkedList.head;
        while (p1.next != p2.next) {
            p1 = p1.next;
            p2 = p2.next;
        }
        System.out.println("+ p1 => start point: " + p1.next.data + ", p2 => end point: "+ p2.data);

    }


    /*  =======================================================================================
        - Segregate even and odd
            - even towards left of the list and odd towards right
            - Their order should remain the same as in the input
     */
    public static void segregateEvenAndOdd(SinglyLinkedList linkedList) {

        Node curr = linkedList.head;
        Node end = linkedList.head;
        Node prev = null;

        /* Get pointer to last Node */
        while (end.next != null)
            end = end.next;

        Node new_end = end;

        // Consider all odd nodes before getting first eve node
        while ((Integer) curr.data %2 !=0 && curr != end) {
            new_end.next = curr;
            curr = curr.next;
            new_end.next.next = null;
            new_end = new_end.next;
        }

        // do following steps only if there is an even node
        if ((Integer) curr.data %2 ==0) {
            linkedList.head = curr;

            // now curr points to first even node
            while (curr != end) {
                if ((Integer) curr.data % 2 == 0) {
                    prev = curr;
                    curr = curr.next;
                }
                else {
                    /* Break the link between prev and curr*/
                    prev.next = curr.next;

                    /* Make next of curr as null */
                    curr.next = null;

                    /*Move curr to end */
                    new_end.next = curr;

                    /*Make curr as new end of list */
                    new_end = curr;

                    /*Update curr pointer */
                    curr = prev.next;
                }
            }
        }

        /* We have to set prev before executing rest of this code */
        else prev = curr;

        if (new_end != end && (Integer) end.data %2 != 0)
        {
            prev.next = end.next;
            end.next = null;
            new_end.next = end;
        }

        System.out.println(linkedList.toString());

    }


    /*  ===========================================================================================
        Steps:
        1) Traverse till first even node. While doing so, keep pushing odd nodes after the orig-tail
        2) if the node found is even;
            2.1) point the head to current node and...
            2.2) if current is even, while "iterating till orig-tail"
                    2.2.1) advance pointers.
                else
            2.3) if current is odd
                    2.3.1) break linkes and point prev.next to curr.next
                    2.3.2) Update tail node and move tail pointer
                    2.3.3) Advance current pointer using "prev.next"
            2.4) At last, if the orig-tail is found to be odd yet then move orig-tail node to the
             end of new tail and set orig-tail.next to null
     */

    public static void evenAndOdd (SinglyLinkedList linkedList ) {
        System.out.println("\n+ Segregate even and odd +" +
                "\nOriginal list: " + linkedList.toString());

        /* fix the tail node for reference to add other nodes to the end */

        Node current = linkedList.head;
        Node origTail = linkedList.tail;
        Node newTailNode = linkedList.tail;
        Node prevNode = null;

        // STEP-1
        // move the first odd node to end of the linked list
        while ( (Integer) current.data % 2 != 0 && current != origTail ) {
            newTailNode.next = current;
            current = current.next;
            newTailNode.next.next = null;
            newTailNode = newTailNode.next;

        }


        if ((Integer) current.data % 2 == 0) {
            // STEP - 2.1
            linkedList.head = current;  // add head pointer back to current node
            System.out.println("\nIntermittent : " + linkedList.toString());

            // STEP - 2.2
            while (current != origTail) {
                if ( (Integer) current.data % 2 == 0 ) {    // STEP - 2.2
                    prevNode = current;
                    current = current.next;     // STEP - 2.2.1

                }
                else {
                   /* Break the link between prev and curr*/
                    prevNode.next = current.next;       // STEP - 2.3.1

                    /* Make next of curr as null */
                    current.next = null;                // STEP - 2.3.1

                    /* tail pointing towards curr as new tail node */
                    newTailNode.next = current;         // STEP - 2.3.2

                    newTailNode = current;              // STEP - 2.3.2

                    /* Advance the current pointer */
                    current = prevNode.next;            // STEP - 2.3.3

                }

            }

        }

        // STEP - 2.4
        if (newTailNode != origTail && (Integer) origTail.data % 2 != 0) {
            prevNode.next = origTail.next;
            origTail.next = null;
            newTailNode.next = origTail;
        }

        System.out.println("+ modified : " + linkedList.toString());



    }   // end segregateEvenAndOdd()


    /* ====================================================================================
        finding the middle by using 2 pointers
        1 - hopping one step at a time and
        2 - hopping 2 steps at a time
        */
    public static void findMiddleOfLinkedlist(SinglyLinkedList linkedList) {
        Node p1 = linkedList.head;
        Node p2 = linkedList.head;

        while (p2.next != null) {
            p2 = p2.next;

            if (p2.next != null) {
                p2 = p2.next;
                p1 = p1.next;
            }
        }

        System.out.println("Mid of list (P1) = " + p1 + ", P2 = " + p2);
    }


    // ===========================================================================================
	/*
	 * To delete node without using many other pointers possible only "when the node is at the center"
	 */
    public static void deleteWhenOnlyNodeProvide ( Node node ) {
        if ( (node == null) || (node.next== null) )
            return;

        node.data = node.next.data;
        node.next = node.next.next;
    }


    /*  ==========================================================================================
        // Delete duplicate nodes of a singly linked list.

        Steps / Logic:
        (1) traversing from head to tail,
        (2) if curr.data == next.data then,
        (3) de-link, curr.next = curr.next.next and re-arrange links accordingly
        (4) if curr.data != next.data then, just advance the pointers.
     */
    public static void deleteDuplicatesOnSorted(SinglyLinkedList linkedList) {
        System.out.println("+ Deleting duplicate nodes from sorted linked list +");

        if (linkedList.head == null
                || linkedList.head.next == null) {
            throw new NoSuchElementException("+ Single node list, NO duplicates found.");
        }


        Node curr = linkedList.head;
        Node nextNode = curr.next;

        while (curr != null) {
            if ((Integer) curr.data != (Integer) nextNode.data) {
                curr = curr.next;
                nextNode = curr.next;
            }
            else {
                curr.next = curr.next.next;
                curr = curr.next;

            }
        }

        System.out.println("+ Deleted duplciated : " + linkedList.toString());

    }   // end deleteDuplicatesOnSorted()


    /*  ========================================================================================
        Deleting duplciates from a un-sorted linked list

        Logic: While iterating from head to tail, have a running pointer, which traverses till curr
        Steps:
        (1) prev = head, curr = head.next
        (2) while -> curr != null
        (3) runner starting from head
        (4) while
                -> runner.data != curr.data, keep moving runner pointer till it co-insides with curr
                -> if not, runner.data == curr.data, de-link current using prev.next = curr.next

        (5) later out of 2nd while, move curr = curr.next
     */
    public static void deleteUnSortedDuplicates(SinglyLinkedList linkedList) {
        if (linkedList.head == null
                || linkedList.head.next == null) {
            throw new NoSuchElementException("+ Not to be deleted.");
        }

        Node prev = linkedList.head;
        Node curr = prev.next;
        Node runner;

        while (curr != null) {
            runner = linkedList.head;

            while (runner != curr) {
                if ((Integer) runner.data != (Integer) curr.data) {
                    runner = runner.next;
                }
                else {
                    prev.next = curr.next;
                    curr = curr.next;
                }
            }

            prev = curr;
            curr = curr.next;
        }

        System.out.println("+ After deletion : "  + linkedList.toString());
    }


}   // end of class SinglyLinkedList()
