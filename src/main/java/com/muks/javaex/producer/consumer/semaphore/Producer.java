package com.muks.javaex.producer.consumer.semaphore;

/*
 * Created by mukthar.ahmed on 07/07/15.
 */

class Producer implements Runnable {
    Queue q;

    Producer(Queue q) {
        this.q = q;
        new Thread(this, "Producer").start();
    }

    public void run() {
        for (int i = 0; i < 20; i++)
            q.put(i);
    }
}
