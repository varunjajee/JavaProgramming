package com.muks.oopsandjava.concepts.listener.AuctioneerEg;

/**
 * Created by 300000511 on 19/04/17.
 */
public class ListenerRCB extends AuctionListener {

    public ListenerRCB(AuctioneerSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void listen() {
        System.out.println("Winning bid was - " + subject.getState());
    }
}
