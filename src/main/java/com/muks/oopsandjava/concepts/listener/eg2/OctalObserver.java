package com.muks.oopsandjava.concepts.listener.eg2;

/**
 * Created by 300000511 on 15/04/17
 *      - OctalObserver observer
 */
public class OctalObserver extends Observer{

    public OctalObserver(Subject subject){
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) );
    }
}