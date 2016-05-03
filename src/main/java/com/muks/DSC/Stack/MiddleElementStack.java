package com.muks.DSC.Stack;

import java.util.EmptyStackException;

/**
 * Created by mukthar.ahmed on 5/3/16.
 *
 * Implement a stack which besides, the usual push, pop and top, has an extra operation.
 * It returns the middle element of the stack in constant time.
 * Example:
 * Stack      State        GetMiddle()
 * ========================================
 * Push(1)    (1)               1
 * Push(2)    (2,1)             2
 * Push(3)    (3,2,1)           2
 * Push(4)    (4,3,2,1)         3
 * Push(5)    (5,4,3,2,1)       3
 * Pop()      (4,3,2,1)         3
 * Pop()      (3,2,1)           2
 * Pop()      (2,1)             2
 * Pop()      (1)               1
 * Pop()      null              null
 *
 */
public class MiddleElementStack {

    static class Stack {
        class Node {
            int value;

            Node next;
            Node prev;

            public Node(int val) {
                this.value = val;
                this.next = null;
                this.prev = null;
            }
        }

        /** Stack code */
        Node head;
        Node middle;
        int size;

        public Stack() {
            this.head = null;
            this.middle = null;
            size = 0;
        }


        public void push(int val) {
            size++;
            if(head == null) {
                head = new Node(val);
                middle = head;
            } else {
                Node node = new Node(val);
                node.next = head;
                head.prev = node;
                head = node;

                if(size % 2 == 0) {
                    middle = middle.prev;
                }
            }
        }

        public int pop() {
            size--;

            if (size == 0) {
                head = null;

                return -1;

            } else {
                int retVal = head.value;
                head = head.next;
                head.prev = null;

                if(size % 2 == 1) {
                    middle = middle.next;
                }

                return retVal;
            }
        }

        public int popMid() {
            if (head == null) {
                throw new EmptyStackException();
            }

            int rVal = middle.value;

            if (middle.prev != null) {
                middle.prev.next = middle.next;
            }
            if (middle.next != null) {
                middle.next.prev = middle.prev;
            }

            if (size % 2 == 1) {
                // deleted middle.
                middle = middle.prev;
            } else {
                middle = middle.next;
            }

            if (middle == null) {
                head = null;
            }
            size--;

            return rVal;
        }


        public int getMiddle() {
            return middle.value;
        }

    }


    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);

        stack.push(3);
        System.out.println("# mid = " + stack.getMiddle());
        stack.push(4);
        stack.push(5);
        //stack.push(6);


        System.out.println("# mid = " + stack.getMiddle());

        System.out.println("\n# pop'd mid = " + stack.popMid());
        System.out.println("# Middle = " + stack.getMiddle());

        System.out.println("\n# pop'd mid = " + stack.popMid());
        System.out.println("# Middle = " + stack.getMiddle());

        System.out.println("\n# pop'd mid = " + stack.popMid());
        System.out.println("# Middle = " + stack.getMiddle());

    }

}
