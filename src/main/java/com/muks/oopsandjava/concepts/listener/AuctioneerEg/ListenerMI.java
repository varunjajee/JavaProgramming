package com.muks.oopsandjava.concepts.listener.AuctioneerEg;

/**
 * Created by 300000511 on 19/04/17.
 */
public class ListenerMI extends AuctionListener {

    public ListenerMI(AuctioneerSubject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void listen() {
        System.out.println(this.getClass().getName() + ", Winning bid was - " + subject.getState());
    }

}
