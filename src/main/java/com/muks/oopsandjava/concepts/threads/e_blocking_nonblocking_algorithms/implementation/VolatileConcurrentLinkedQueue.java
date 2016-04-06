package com.muks.oopsandjava.concepts.threads.e_blocking_nonblocking_algorithms.implementation;

/**
 * Created by mukthar.ahmed on 4/5/16.
 *
 *  - using updater / volatile "next" pointer instead of AtomicReference<>
 *      Link - http://www.itu.dk/courses/SPLG/E2012/splg2012-ps-3.pdf
 */


public class VolatileConcurrentLinkedQueue {

  /*  public class Node {
        final int data;
        volatile Node next;

        public Node(int data) {
            this.data = data;


        }
    }
    AtomicReferenceFieldUpdater<Node, Node> nextUpdater = AtomicReferenceFieldUpdater.newUpdater(Node.class, Node.class, "next");
    private Node head = new Node(null);
    private Node tail = head;

    public boolean put(int item) {
        Node newNode = new Node(item);

        while (true) {
            Node currTail = tail;
            Node currTailNext = currTail.next;

            if ( currTail == tail ) {
                if ( currTailNext == null ) {
                    if ( nextUpdater.compareAndSet(currTail, currTailNext, newNode) ) {
                        tail.compareAndSet(currTail, newNode);
                        return true;
                    }
                }
                else {
                    tail.compareAndSet(currTail, currTailNext);
                }
            }
        }
    }*/
}
