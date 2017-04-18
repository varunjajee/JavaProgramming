package com.muks.oopsandjava.concepts.listener.eg1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 300000511 on 15/04/17
 *
 *  - Initiater class
 */
public class Initiater {
    private List<HelloListener> listeners = new ArrayList<>();

    public void addListener(HelloListener toAdd) {
        listeners.add(toAdd);
    }

    public void sayHello() {
        System.out.println("Hello!!");

        // Notify everybody that may be interested.
        for (HelloListener hl : listeners)
            hl.someoneSaidHello();
    }
}
