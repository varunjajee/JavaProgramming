package com.muks.DSC.Queue;

/*
 * Created by mukthar.ahmed on 1/1/16.
 */

public class TestQueue {

    public static void main(String[] args) {
//        Queue Queue = new Queue(3);
//        TestingBlockingAlgo {
//            Queue.enqueue(1);
//            //Queue.dequeue();
//            Queue.enqueue(2);
//            //Queue.dequeue();
//            Queue.enqueue(3);
//
//
//            Queue.display();
//
////            Queue.dequeue();
////            Queue.dequeue();
////            Queue.dequeue();
//            //Queue.dequeue();  // this will trigger "Queue empty" exception
//
////            System.out.println("+ Peak() : " + Queue.peek());
////            System.out.println("Is Queue empty = " + Queue.isEmpty() + ", size=" + Queue.getSize());
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }


        QueueByStack Q = new QueueByStack();
        Q.enqueue(1);
        Q.enqueue(2);
        Q.enqueue(3);
        Q.enqueue(4);

        System.out.println("\n+ Dequeue = ["
                + Q.dequeue() + ", " + Q.dequeue() + ", " + Q.dequeue() + ", " + Q.dequeue()
        + "]");

    }
}
