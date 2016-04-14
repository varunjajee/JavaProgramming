package com.muks.DSC.Stack;

/**
 * Created by mukthar.ahmed on 3/7/16.
 *
 * Link: http://www.programcreek.com/2014/02/leetcode-min-stack-java/
 *
 */
public class MinStack {
    class Node {
        int value;
        public int min;
        Node next;

        Node(int x) {
            value = x;
            next = null;
            min = x;
        }

        public String toString() {
            return "[Val=" + value + ", Min=" + min + "]";
        }
    }

    Node head;
    public void push(int x) {
        if (head == null) {
            head = new Node(x);
        }
        else {
            Node newNode = new Node(x);
            newNode.min = Math.min(head.min, x);
            newNode.next = head;
            head = newNode;
        }
    }

    public Node pop() {
        if (head == null) {
            throw new IndexOutOfBoundsException("+ Stack is empty.");
        }

        Node rValue = head;
        head = head.next;

        return rValue;
    }

    public Node top() {
        if (head == null)
            return null;

        return head;
    }

    public int getMin() {
        if (head == null)
            return Integer.MIN_VALUE;

        return head.min;
    }


    public void print() {
        Node curr = head;
        while (curr != null) {
            System.out.print(" -> " + curr);
            curr = curr.next;
        }
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(3);
        minStack.push(0);
        minStack.push(5);
        minStack.push(9);

        minStack.print();

        System.out.println("\n" + minStack.pop());
        System.out.println("+ Top-Min = " + minStack.top().min);

        System.out.println(minStack.pop());
        System.out.println("+ Top-Min = " + minStack.top().min);


        System.out.println(minStack.pop());
        System.out.println("+ Top-Min = " + minStack.top().min);

        System.out.println(minStack.pop());
        System.out.println("+ Top-Min = " + minStack.top().min);

    }
}
