package com.muks.oopsandjava.concepts.threads.blocking_nonblocking_algo.implementation;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by mukthar.ahmed on 4/5/16.
 * <p>
 * - Concurrent Queue implementation using advanced CAS
 */


public class ConcurrentLinkedQueue<E> {
    /** Node class */
    class Node<E> {
        final E data;
        final AtomicReference<Node<E>> next;

        Node(E data, AtomicReference<Node<E>> next) {
            this.data = data;
            this.next = next;
        }
    }


    /** Concurrent linked-queue implementation starts here
     * Start with head = tail = dummy node/ null node
     * */
    private AtomicReference<Node<E>> head = new AtomicReference<>(new Node<>(null, null));
    private AtomicReference<Node<E>> tail = head;

    public boolean put(E item) {
        Node<E> newNode = new Node<E>(item, null);

        while (true) {
            Node<E> currTail = tail.get();
            Node<E> currTailNext = currTail.next.get();

            if ( currTail == tail.get() ) {
                if ( currTailNext  == null ) {      /** Quiescent state, resting state */
                    tail.compareAndSet(currTail, newNode);  /** Successfully added tail node state */
                    return true;
                }
            }
            else {      /** Intermediate state, try move to updated tail. help another enqueuer  */
                tail.compareAndSet(currTail, currTailNext);
            }
        }
    }


    public E get() {
        while (true) {
            Node<E> currHead = head.get();
            Node<E> currHeadNext = currHead.next.get();
            Node<E> currTail = tail.get();


            if ( currHead == head.get() ) {     /** No thread has touch this yet */
                if ( currHead == currTail ) {
                    if ( currHeadNext == null ) {   /** Empty queue encountered */
                        return null;
                    }

                    tail.compareAndSet(currTail, currHeadNext);     /** Intermediate state */
                }
            }
            else {
                E nextItem = currHeadNext.data;
                if ( head.compareAndSet(currHead, currHeadNext) ) {     /** Try to move head */
                    return nextItem;
                }
            }

        }
    }


}
