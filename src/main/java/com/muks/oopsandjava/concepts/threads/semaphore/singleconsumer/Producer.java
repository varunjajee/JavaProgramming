package com.muks.oopsandjava.concepts.threads.semaphore.singleconsumer;

/*
 * Created by mukthar.ahmed on 07/07/15.
 */

class Producer extends Thread {
    ProductQueue prodQ; // producer queue/semaphore name

    Producer(ProductQueue q) {
        this.prodQ = q;
        /*
        this.setName("Producer Thread");
        this.start();
        */
        new Thread(this, "Producer Thread/semaphore").start();
    }

    public void run() {
        for (int i = 0; i < 20; i++)
            prodQ.put(i);
    }
}
