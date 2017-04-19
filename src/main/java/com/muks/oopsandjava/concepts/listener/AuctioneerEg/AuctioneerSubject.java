package com.muks.oopsandjava.concepts.listener.AuctioneerEg;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 300000511 on 19/04/17.
 */
public class AuctioneerSubject {
    private List<AuctionListener> listeners = new ArrayList<>();
    private List<Integer> bids = new ArrayList<>();
    private int winningBid;

    public int getState() {
        return winningBid;
    }

    public void addBid(int bid) {
        this.bids.add(bid);
    }

    public void publish() {
        int i = 0;
        this.winningBid = bids.get(i);

        for (;i < bids.size(); i++) {
            if (this.winningBid < bids.get(i))
                this.winningBid = bids.get(i);
        }

        notifyAllObservers();

    }

    public void notifyAllObservers() {
        for (AuctionListener auctionListener : listeners) {
            auctionListener.listen();
        }
    }

    public void attach(AuctionListener auctionObservers){
        listeners.add(auctionObservers);
    }
}
