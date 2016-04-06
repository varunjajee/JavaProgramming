package com.muks.oopsandjava.concepts.threads.d_prodconsumerproblem.a_ByCustomeQueue;

/*
 * Created by mukthar.ahmed on 22/06/15.
 * http://www.java2s.com/Code/Java/Threads/Animplementationofaproducerandconsumerthatusesemaphorestocontrolsynchronization.htm
 */
public class Consumer extends Thread {
    ProductQueue prodQ;

    public Consumer (ProductQueue q) {
        this.prodQ = q;
        new Thread(this, "Consumer Thread/d_prodconsumerproblem").start();
    }

    public void run() {
        for (int i = 0; i < 20; i++) {
            prodQ.get();
        }
    }

}
