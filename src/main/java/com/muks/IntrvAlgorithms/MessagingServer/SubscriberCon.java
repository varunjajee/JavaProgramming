package com.muks.ola.MessagingServer;



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

            try {
                System.out.println("+ Msg Consumed = " + mq.take());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


}
