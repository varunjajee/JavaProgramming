package com.muks.IntrvAlgorithms.MessagingServerByTopics;

import com.muks.IntrvAlgorithms.MessagingServerByTopics.MyInterfaces.Observer;
import com.muks.IntrvAlgorithms.MessagingServerByTopics.MyInterfaces.Subject;

/**
 * Created by mukthar.ahmed on 3/29/16.
 *
 *
 *          "Subscriber" class implementation
 *
 *
 */


public class MyTopicSubscriber implements Observer {

    private Subject topic;

    public MyTopicSubscriber(Subject topicName) {
        this.topic = topicName;
    }

    @Override
    public void update() {
        String publishedMsg = topic.getUpdates(this);
        if (publishedMsg != null) {
            System.out.println("# " + this.topic.getName() + ", Consumed Msg: \"" + publishedMsg + "\"");
        }
        else {
            System.out.println("# No message to consume.");
        }
    }

    @Override
    public String getName() {
        return null;
    }
}
