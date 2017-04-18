package com.muks.oopsandjava.concepts.listener.eg2;

/**
 * Created by 300000511 on 15/04/17
 *      - BinaryObserver observer
 */
public class BinaryObserver extends Observer{

    public BinaryObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) );
    }
}