package com.muks.headfirstjava.threads.semaphore.singleconsumer;

import java.util.concurrent.Semaphore;

/*
 * Created by mukthar.ahmed on 07/07/15.
 */
public class ProductQueue {
    // We must start with Producer semaphore
    static Semaphore semProd = new Semaphore(1);

    // Start with consumer semaphore unavailable
    static Semaphore semCon = new Semaphore(0);

    int productId;

    void put(int n) {
        try {
            semProd.acquire();

            this.productId = n;
            System.out.println("Put: " + n);
            semCon.release();

        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
    }

    void get() {
        try {
            semCon.acquire();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException caught");
        }
        System.out.println("Got: " + productId);
        semProd.release();
    }
}
