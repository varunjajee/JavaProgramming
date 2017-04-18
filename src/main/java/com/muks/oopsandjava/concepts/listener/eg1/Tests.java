package com.muks.oopsandjava.concepts.listener.eg1;

/**
 * Created by 300000511 on 15/04/17.
 */
public class Tests {

    public static void main(String[] args) {
        Initiater initiater = new Initiater();
        Responder responder = new Responder();

        initiater.addListener(responder);

        initiater.sayHello();  // Prints "Hello!!!" and "Hello there..."
    }

}
