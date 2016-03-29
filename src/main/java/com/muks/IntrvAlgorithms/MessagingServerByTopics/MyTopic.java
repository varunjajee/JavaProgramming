package com.muks.IntrvAlgorithms.MessagingServerByTopics;

import com.muks.IntrvAlgorithms.MessagingServerByTopics.MyInterfaces.Observer;
import com.muks.IntrvAlgorithms.MessagingServerByTopics.MyInterfaces.Subject;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Created by mukthar.ahmed on 3/29/16.
 *
 *      "Topic" class implementation
 */


public class MyTopic implements Subject{

    private String name;
    private List<Observer> observerList;
    private String message;         /** NULl by default */
    private boolean hasChanged;     /** FALSE by default */
    private final Object MUTEX = new Object();  /** Used to have synchronised entry of observers */

    public MyTopic(String topicName) {
        this.name = topicName;
        observerList = new ArrayList<>();
    }

    public String getName() { return "[" + this.name + "]"; }

    public void register(Observer observer) {
        if (observer == null) {
            throw new NullPointerException("+ Observer is NULL.");
        }

        synchronized (MUTEX) {      /** Used to have synchronised entry of observers */
            if (!observerList.contains(observer)) {
                observerList.add(observer);
            } else {
                System.out.println("# Observer: " + observer.getName());
            }
        }
    }

    public void deregister(Observer observer) {
        synchronized (MUTEX) {
            if (observerList.contains(observer)) {
                observerList.remove(observer);
            } else {
                throw new NoSuchElementException("# Observer: " + observer.getName() + ", does NOT exists.");
            }
        }
    }

    @Override
    public void notifyObservers() {

        List<Observer> allObservers = null;

        synchronized (MUTEX) {
            if ( !hasChanged )
                return;

            /** Fetch observers within synchronised block, so that msgs are published to only registered subscribers
                till this point. New ones will NO */
            allObservers = new ArrayList<>(this.observerList);

            for (Observer observer : allObservers) {
                observer.update();
            }

            hasChanged = !hasChanged;
        }

    }

    /** Used to fetch the published msg, pulled by Observer object */
    @Override
    public String getUpdates(Observer observer) {
        return this.message;
    }

    public void postMessage(String msg) {
        System.out.println("# Message Posted: " + msg);
        this.message = msg;
        hasChanged = true;
        notifyObservers();
    }
}

