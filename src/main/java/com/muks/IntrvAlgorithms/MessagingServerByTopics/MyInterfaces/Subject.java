package com.muks.IntrvAlgorithms.MessagingServerByTopics.MyInterfaces;

/**
 * Created by mukthar.ahmed on 3/29/16.
 *
 * Base "topic" class
 */
public interface Subject {

    /** Register and de-register observers */
    public void register(Observer observer);
    public void deregister(Observer observer);


    /** Notify all observers */
    public void notifyObservers();

    /** Gets the updates on published msgs */
    public String getUpdates(Observer observer);

    /** To obtain the name of the topic */
    public String getName();
}
