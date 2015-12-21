package com.muks.oopsandjava.concepts.threads.semaphore.singleconsumer;

/**
 * Created by mukthar.ahmed on 11/9/15.
 */
public class TestSemaphore {

    public static void main(String[] args) {
        ProductQueue q = new ProductQueue();
        Producer producer = new Producer(q);
        Consumer consumer = new Consumer(q);

        //start statements are NOT required as they are coded to start the moment instantiated
//        producer.start();
//        consumer.start();
    }
}
