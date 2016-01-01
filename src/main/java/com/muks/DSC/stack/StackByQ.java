package com.muks.DSC.stack;

import com.muks.DSC.queue.Queue;

/*
 * Created by mukthar.ahmed on 1/2/16.
 */
public class StackByQ {
    private Queue q1, q2;


    public StackByQ(int size) {
        q1 = new Queue(size, "Q-1");
        q2 = new Queue(size, "Q-2");
    }

    public void push(Object element) {
        System.out.println("\nPush request of - (" + element + ")");
        if (q1.isEmpty()) {
            try {
                q1.enqueue(element);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else {
            int len = q1.getSize();
            System.out.println("+ Q-1, size=" + len);

            //while (q1.getSize() != 0) {
            for (int i = 0; i < len; i++) {
                try {
                    q2.enqueue(q1.dequeue());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            try {
                q1.enqueue(element);

                //while(q2.getSize() != 0) {
                for (int i = 0; i < len; i++) {
                    q1.enqueue(q2.dequeue());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public Object pop() throws Exception {
        if (q1.getSize() == 0)
            throw new Exception("Underflow Exception");

        return q1.dequeue();
    }

    public static void main(String[] args) {
        StackByQ stackByQ = new StackByQ(3);
        stackByQ.push(1);
        stackByQ.push(2);
        stackByQ.push(3);

        try {
            System.out.println(stackByQ.pop() + " -> " + stackByQ.pop()
                    + " -> " + stackByQ.pop()
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
