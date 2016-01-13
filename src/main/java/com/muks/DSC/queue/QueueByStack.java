package com.muks.DSC.Queue;

import java.util.Stack;

/**
 * Created by mukthar.ahmed on 1/12/16.
 */
public class QueueByStack {
    private Integer[] Queue;
    private int size;

    public QueueByStack() {

    }

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void enqueue(Integer elem) {
        System.out.println("\n=> " + elem);
        if (stack1.isEmpty()) {
            stack1.push(elem);
            System.out.println("+ Init : " + stack1.toString());
        }
        else {
            System.out.println("stack-1 = " + stack1.toString() + ", len = " + stack1.size());
            while (!stack1.empty()) {
                Integer p = stack1.pop();
                System.out.println("- pop'd = " + p);
                stack2.push(p);
            }

            System.out.println("stack-2 = " + stack2.toString() + ", len = " + stack2.size());

            stack1.push(elem);
            System.out.println("\nstack-1 = " + stack1.toString());

            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
            System.out.println("+ Finally, stack-1 = " + stack1.toString());
        }

    }

    public Integer dequeue() {
        return stack1.pop();
    }
}
