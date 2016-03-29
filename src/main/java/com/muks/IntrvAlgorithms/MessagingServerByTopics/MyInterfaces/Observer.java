package com.muks.IntrvAlgorithms.MessagingServerByTopics.MyInterfaces;

/**
 * Created by mukthar.ahmed on 3/29/16.
 *
 *
 *           interface for "subscriber" class
 *
 */


public interface Observer {

    /** Method - Used by the Subject class, to update the observer */
    public void update();

    public String getName();
}
