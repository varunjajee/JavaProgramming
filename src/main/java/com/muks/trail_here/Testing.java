package com.muks.trail_here;


import java.util.Queue;

class TestingStack {
    int[] stack;
    int size, top, total;

    public TestingStack(int capacity) {
        size = capacity;
        stack = new int[size];
        top = -1;
    }

    public void push(int elem) {
        if (top + 1 == size) {
            throw new IndexOutOfBoundsException("Can't push \"" + elem + "\", Stack full exception");
        }
        total++;
        stack[++top] = elem;
    }

    public int pop() {
        if (top == -1) {
            throw new IndexOutOfBoundsException("Stack empty exception");
        }
        total--;
        return stack[top--];
    }

    public void print() {
        for (int i = 0; i < total; i++) {
            System.out.print(" "  + stack[i]);
        }
    }

    Queue<Integer> q1;
    Queue<Integer> q2;
    public void pushByQueue(int elem) {
        if (top+1 == size) {
            throw new IndexOutOfBoundsException("Stack is out of its capacity");
        }

        if (q1.isEmpty()) {
            q1.add(elem);
        }
        else {
            while (!q1.isEmpty()) {
                q2.add(q1.remove());
            }

            q1.add(elem);

            while (!q2.isEmpty()) {
                q1.add(q2.remove());
            }
        }
    }

    public static void main(String[] args) {
        TestingStack stack = new TestingStack(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.print();
    }

}