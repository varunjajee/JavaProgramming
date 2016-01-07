package com.muks.DSC.Queue;

/*
 * Created by mukthar.ahmed on 1/1/16.
 */

public class TestQueue {

    public static void main(String[] args) {
        Queue queue = new Queue(3);
        try {
            queue.enqueue(1);
            //Queue.dequeue();
            queue.enqueue(2);
            //Queue.dequeue();
            queue.enqueue(3);


            queue.display();

//            Queue.dequeue();
//            Queue.dequeue();
//            Queue.dequeue();
            //Queue.dequeue();  // this will trigger "Queue empty" exception

//            System.out.println("+ Peak() : " + Queue.peek());
//            System.out.println("Is Queue empty = " + Queue.isEmpty() + ", size=" + Queue.getSize());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
