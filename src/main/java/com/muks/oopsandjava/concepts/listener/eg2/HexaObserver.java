package com.muks.oopsandjava.concepts.listener.eg2;

/**
 * Created by 300000511 on 15/04/17
 *  - HexaObserver observer
 */
public class HexaObserver extends Observer{

    public HexaObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Hex String: " + Integer.toHexString( subject.getState() ).toUpperCase() );
    }
}