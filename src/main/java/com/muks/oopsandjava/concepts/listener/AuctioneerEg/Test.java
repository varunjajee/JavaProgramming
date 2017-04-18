package com.muks.oopsandjava.concepts.listener.AuctioneerEg;

/**
 * Created by 300000511 on 19/04/17.
 */
public class Test {
    public static void main(String[] args) {
        AuctioneerSubject subject = new AuctioneerSubject();
        new ListenerRCB(subject);
        new ListenerMI(subject);

        subject.addBid(10);
        subject.addBid(19);

        subject.publish();
    }
}
