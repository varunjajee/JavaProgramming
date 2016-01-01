package com.muks.DSC.queue;

/*
 * Created by mukthar.ahmed on 1/1/16.
 */

public class TestQueue {

    public static void main(String[] args) {
        Queue queue = new Queue(3);
        try {
            queue.enqueue(1);
            //queue.dequeue();
            queue.enqueue(2);
            //queue.dequeue();
            queue.enqueue(3);


            queue.display();

//            queue.dequeue();
//            queue.dequeue();
//            queue.dequeue();
            //queue.dequeue();  // this will trigger "queue empty" exception

//            System.out.println("+ Peak() : " + queue.peek());
//            System.out.println("Is queue empty = " + queue.isEmpty() + ", size=" + queue.getSize());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
