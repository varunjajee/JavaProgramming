package com.muks.IntrvAlgorithms.MessagingServer;

/*
 * Created by mukthar.ahmed on 1/30/16.
 */

public class TestMessageServer {
    public static void main(String[] args) {
        MessagingQueue msgQ = new MessagingQueue();

        Thread t1 = new Thread(new PublisherProd(msgQ));
        Thread t2 = new Thread(new SubscriberCon(msgQ));

        t1.setName("Producer");
        t2.setName("Consume");

        t1.start();
        t2.start();

    }

}
