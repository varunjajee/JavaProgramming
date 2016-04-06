package com.muks.oopsandjava.concepts.threads.d_prodconsumerproblem.ByCustomeQueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/*
 * Created by mukthar.ahmed on 07/07/15.
 */
public class ProductQueue {
    // We must start with Producer prodconsumer problem
    static Semaphore semProd = new Semaphore(1);

    // Start with consumer d_prodconsumerproblem unavailable
    static Semaphore semCon = new Semaphore(0);

    Queue<Integer> productQ = new LinkedList<>();

    void put(int n) {
        try {
            semProd.acquire();

            productQ.add(n);        // adding elements into the product-Q

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

        System.out.println("Got: " + productQ.remove());

        semProd.release();
    }
}
