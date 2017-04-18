package com.muks.oopsandjava.concepts.listener.eg1;

/**
 * Created by 300000511 on 15/04/17
 *
 *  - Responder class
 *
 */


public class Responder implements HelloListener {
    @Override
    public void someoneSaidHello() {
        System.out.println("Hello there...");
    }
}