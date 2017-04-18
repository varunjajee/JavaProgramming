package com.muks.oopsandjava.concepts.listener.eg2;

/**
 * Created by 300000511 on 15/04/17
 *
 *     - an abstract Observer pattern
 *
 */
public abstract class Observer {
    protected Subject subject;
    public abstract void update();
}