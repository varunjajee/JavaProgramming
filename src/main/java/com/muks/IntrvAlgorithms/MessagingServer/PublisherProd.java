package com.muks.IntrvAlgorithms.MessagingServer;

/*
 * Created by mukthar.ahmed on 1/30/16.
 */
public class PublisherProd implements Runnable {
    MessagingQueue mq;

    public PublisherProd(MessagingQueue queue) {
        this.mq = queue;
    }

    @Override
    public void run() {

        for (int i = 0; i < 10; i++) {
            String msg = "Message-" + i;
            try {
                mq.put(msg);

            } catch (Exception e) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }

    }

}


