package com.muks.DSC.stack;

/*
 * Created by mukthar.ahmed on 1/1/16.
 *
 * - Operates on LIFO principle
 * - 2 operations are allowed,
 *      - push - inserting the element at the top
 *      - pop - removing/pop'ing out elements from the top
 *
 *
 * Usage / Applications
 *  - Most common usages:
 *      -   To reverse a word. Insert all elements in right order and pop out for reversal
 *      -   "Undo" mechanism of any text editor.
 *
 *  - Backtracking purposes/usages, all use stack where most recent changes are to be tracked.
 *
 *  - Language processing usages
 *      - spaces for parameters and local variables are created internally using stack
 *      - compiler syntax checks for matching braces is implemented using stack
 *      - support for recursion (is developed using stack)
 */

public class Stack {
    private Object[] stack;
    private int capacity, stackSize;
    private int topIndex = -1;

    public Stack(int size) {
        stack = new Object[size];
        this.capacity = size;
        this.stackSize = 0;
    }

    public void push(Object element) throws Exception {
//        if (topIndex == capacity -1) {
        if (stackSize == capacity) {
            throw new Exception("Stack full exception");
        }

        StringBuilder sb = new StringBuilder("Pushing value=" + element + ", @ Top index=" +
                topIndex + ", Capacity="+ capacity );
        System.out.println(sb.toString());

        stack[++topIndex] = element;
        stackSize++;
    }

    public Object pop() throws Exception {
        if (stackSize == 0) {
            throw new Exception("Stack empty exception");
        }
        stackSize--;
        return stack[topIndex--];
    }

    public int getSize() { return stackSize; }

    public void printStack(Stack stack) {
        System.out.println("\n### Printing stack of size=" + stack.getSize() + " ###");
        StringBuilder sb = new StringBuilder();

        int i = stack.getSize();
        while(i > 0) {
            try {
                Object p = stack.pop();
                sb.append(p);
            } catch (Exception e) {
                e.printStackTrace();
            }

            if (i != 1) {
                sb.append(" -> ");
            }
            i--;
        }

        System.out.println(sb.toString());

    }
}
