package com.muks.javaex.producer.consumer.semaphore;

import java.util.concurrent.Semaphore;

/**
 * Created by mukthar.ahmed on 07/07/15.
 */
public class Queue {
    int value;

    static Semaphore semCon = new Semaphore(0);

    static Semaphore semProd = new Semaphore(1);

    void get() {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
        System.out.println("Got: " + value);
        semProd.release();
    }

    void put(int n) {
        try {
            semProd.acquire();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }

        this.value = n;
        System.out.println("Put: " + n);
        semCon.release();
    }
}
