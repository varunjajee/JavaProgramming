package com.muks.oopsandjava.concepts.listener.eg2;

/**
 * Created by 300000511 on 15/04/17.
 *  - Test class
 */
public class Testing {
    public static void main(String[] args) {
        Subject subject = new Subject();

        new HexaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);

        System.out.println("First state change: 15");
        subject.setState(15);
        System.out.println("Second state change: 10");
        subject.setState(10);
    }
}
