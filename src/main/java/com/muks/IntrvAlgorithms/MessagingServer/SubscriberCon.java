package com.muks.IntrvAlgorithms.MessagingServer;



/*
 * Created by mukthar.ahmed on 1/30/16.
 */
public class SubscriberCon implements Runnable {
    MessagingQueue mq;

    public SubscriberCon(MessagingQueue queue) {
        this.mq = queue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("+ Msg Consumed = " + mq.take());
        }
    }
}
