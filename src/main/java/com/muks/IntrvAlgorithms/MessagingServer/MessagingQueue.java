package com.muks.IntrvAlgorithms.MessagingServer;

import java.util.concurrent.Semaphore;

/*
 * Created by mukthar.ahmed on 1/30/16.
 */
public class MessagingQueue {
    String[] msgQueue = new String[5];
    int index = 0;

    // We must start with Producer prodconsumer problem
    static Semaphore semProd = new Semaphore(1);    // where 1 is the permit of semaphore

    // Start with consumer prodconsumerproblem unavailable
    static Semaphore semCon = new Semaphore(0);


    public void put(String msg) {
        try {
            semProd.acquire();      // quite a write lock

            System.out.println("+ Writing msg = " + msg);
            msgQueue[++index] = msg;

            semProd.release();      // Let the consumer get going

            semCon.release();       // invoke subscriber

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public String take() {
        String msgToReturn = null;

        try {
            semCon.acquire();       // acquire a read lock
            msgToReturn = msgQueue[index--];

            semProd.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return msgToReturn;
    }
}
