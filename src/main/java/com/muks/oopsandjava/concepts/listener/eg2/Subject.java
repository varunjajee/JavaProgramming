package com.muks.oopsandjava.concepts.listener.eg2;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by 300000511 on 15/04/17
 *     - Subject class, which collects all the listeners and notifies all of them when object state change happens
 */
public class Subject {
    private List<Observer> observers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
