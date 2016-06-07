package com.muks.oopsandjava.concepts.threads.d_prodconsumerproblem.b_ByBlockingQueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/*
 * Created by mukthar.ahmed on 1/21/16.
 */
public class ProducerConsumerPattern {


    public static void main(String args[]) {

        //Creating shared object
        BlockingQueue sharedQueue = new LinkedBlockingQueue();

        //Creating Producer and Consumer Thread
        Thread prodThread = new Thread(new Producer(sharedQueue));
        Thread consThread = new Thread(new Consumer(sharedQueue));

        //Starting producer and Consumer thread
        prodThread.start();
        consThread.start();
    }

}

//Producer Class in java
class Producer implements Runnable {

    private final BlockingQueue sharedQueue;

    public Producer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            try {
                System.out.println("Produced: " + i);
                sharedQueue.put(i);
            } catch (InterruptedException ex) {
                System.out.println(Producer.class.getName());
            }
        }

        sharedQueue.add(-1);    /** Indicating demand to stop consuming */
    }

}

//Consumer Class in Java
class Consumer implements Runnable {

    private final BlockingQueue sharedQueue;

    public Consumer(BlockingQueue sharedQueue) {
        this.sharedQueue = sharedQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer val = (Integer) sharedQueue.take();
                if (val == -1) {    /** Indicating that producer and demand work is completed */
                    break;
                }
                System.out.println("Consumed: " + val);
            } catch (InterruptedException ex) {
                System.out.println(Consumer.class.getName());
            }
        }
    }


}

