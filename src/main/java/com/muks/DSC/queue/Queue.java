package com.muks.DSC.queue;

/*
 * Created by mukthar.ahmed on 1/1/16.
 *
 * - Operates as FIFO
 * - Enqueue - inserting elements at the rearIndex of the Queue
 * - Dequeue - removing/poping out elements from the frontIndex of the Queue
 * - peek( ) function is oftenly used to return the value of first element without dequeuing it.
 *
 */

import java.util.NoSuchElementException;

public class Queue {
    private int capacity;
    private Object[] queue;
    private String name = "Q1";
    private int frontIndex, rearIndex, totalItems;

    public Queue(int size) {
        capacity = size;
        queue = new Object[size];  // init Queue with the required size

        // set total elements
        frontIndex = -1;
        rearIndex = -1;
        totalItems = 0;

        System.out.println("+ Queue: Initialized Queue with size - " + size
                + ", length - " + queue.length );
    }   // end constructor

    public Queue(int size, String name) {
        this.name = name;
        capacity = size;
        queue = new Object[size];  // init Queue with the required size

        // set total elements
        frontIndex = -1;
        rearIndex = -1;
        totalItems = 0;

        System.out.println("+ Queue: Initialized Queue with size - " + size
                + ", length - " + queue.length );
    }   // end constructor


    // Put an item to the "END OF THE" Queue
    public void enqueue(Object queueItem) throws Exception {
        if (rearIndex + 1 >= capacity) {
            throw new IndexOutOfBoundsException("Overflow Exception");
        }
        else if (rearIndex == -1) {
            frontIndex = 0;
            rearIndex = 0;
            queue[rearIndex] = queueItem;

        } else {
            queue[++rearIndex] = queueItem;

        }

        totalItems++;

        System.out.println(name + " => Inserting at rear index - " + rearIndex + ", value=" +
                queueItem);
    }


    // pop element from "FRONT" of the Queue
    public Object dequeue() throws Exception {
        StringBuilder sb = new StringBuilder(name
                + " => Dequeue: Front=" + frontIndex + ", Rear=" + rearIndex);

        if (isEmpty()) {
            throw new NoSuchElementException("Underflow Exception");
        } else  {
            totalItems-- ;
            Object ele = queue[frontIndex];
            if ( frontIndex == rearIndex)  {
                frontIndex = -1;
                rearIndex = -1;

            }  else {
                frontIndex++;
            }
            sb.append(", Pop out value=" + ele);
            System.out.println(sb.toString());
            return ele;
        }
    }


    public Object peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Underflow Exception");
        }
        return queue[frontIndex];
    }

    public boolean isEmpty() {
        return frontIndex == -1 || totalItems == 0;
    }

    public boolean isFull() {
        return frontIndex == 0 && rearIndex == capacity -1 ;
    }

    public int getSize() { return totalItems; }

    public void display() {
        System.out.print("\nQueue = ");
        if (totalItems == 0) {
            System.out.print("Empty\n");
            return ;
        }

        for (int i = frontIndex; i <= rearIndex; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();

    }
}
