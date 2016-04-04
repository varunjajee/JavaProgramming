package com.muks.oopsandjava.concepts.threads.blocking_nonblocking_algo.implementation;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by mukthar.ahmed on 4/4/16.
 *
 *  - Concurrent stack using non-blockin algorithm
 */

public class ConcurrentStack<E> {
    class Node<E> {         /** Node class, defining node object */
        final E data;
        Node<E> next;

        Node(E data) {
            this.data = data;
        }
    }

    /** head node definition */
    AtomicReference<Node<E>> head = new AtomicReference<>();

    /**
     * head.compareAndSet(oldHead, newHead);
     *  - What this does is, compares oldHead to be the current head, if true or are same, then updates with the new
     *  head and returns TRUE.
     *
     *  - If the compareAndSet() method returns false, then it re-executes do{ } statement again
     *
     * @param item
     */

    public void push(E item) {
        Node<E> newHead = new Node<>(item);
        Node<E> oldHead;

        do {
            oldHead = head.get();
            newHead.next = oldHead;
        } while ( !head.compareAndSet(oldHead, newHead) );
    }


    public Node<E> pop() {
        Node<E> oldHead;
        Node<E> newHead;

        do {
            oldHead = head.get();
            if (oldHead == null) {      /** edge case for empty stack */
                return null;
            }

            newHead = oldHead.next;
        } while ( !head.compareAndSet(oldHead, newHead) );

        return oldHead;

    }


    public void toPrint() {
        if (head == null) {
            System.out.println("# Stack is empty!");
        }

        Node<E> curr = head.get();
        while (curr != null) {
            System.out.print(" " + curr.data);
            curr = curr.next;
        }
    }

}
