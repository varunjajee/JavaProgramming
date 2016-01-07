package com.muks.DSC.Queue;

import java.util.NoSuchElementException;

/**
 * Created by mukthar.ahmed on 1/2/16.
 */
public class QueueX {
    protected int Queue[] ;
    protected int front, rear, size, len;

    /* Constructor */
    public QueueX(int n) {
        size = n;
        len = 0;
        Queue = new int[size];
        front = -1;
        rear = -1;
    }

    /*  Function to check if Queue is empty */
    public boolean isEmpty() {
        return front == -1;
    }

    /*  Function to check if Queue is full */
    public boolean isFull() {
        return front==0 && rear == size -1 ;
    }

    /*  Function to get the size of the Queue */
    public int getSize() { return len; }

    public int peek() {
        if (isEmpty())
            throw new NoSuchElementException("Underflow Exception");

        return Queue[front];
    }

    /*  Function to insert an element to the Queue */
    public void insert(int i) {
        if (rear == -1) {
            front = 0;
            rear = 0;
            Queue[rear] = i;
        }
        else if (rear + 1 >= size) {
            throw new IndexOutOfBoundsException("Overflow Exception");
        }
        else if ( rear + 1 < size) {
            Queue[++rear] = i;
        }
        len++ ;
    }

    /*  Function to remove front element from the Queue */

    public int remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Underflow Exception");
        } else  {
            len-- ;
            int ele = Queue[front];
            if ( front == rear)  {
                front = -1;
                rear = -1;
            }  else {
                front++;
            }
            return ele;
        }
    }

    /*  Function to display the status of the Queue */

    public void display() {
        System.out.print("\nQueue = ");
        if (len == 0) {
            System.out.print("Empty\n");
            return ;
        }

        for (int i = front; i <= rear; i++) {
            System.out.print(Queue[i] + " ");
        }
        System.out.println();

    }
}
