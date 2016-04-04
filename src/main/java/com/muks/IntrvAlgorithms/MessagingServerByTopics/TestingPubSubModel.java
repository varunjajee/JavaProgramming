package com.muks.IntrvAlgorithms.MessagingServerByTopics;

/**
 * Created by mukthar.ahmed on 3/29/16.
 * <p>
 * - TestCallable class for instrumenting publisher - subscriber model
 * <p>
 * Design pattern: "Observer design" internally using "ChatMediator pattern" or JMS (Java Messaging server) like
 * ApacheMQ
 */
public class TestingPubSubModel {
    public static void main(String[] args) {


        MyTopic topic = new MyTopic("click");

        /** Creating observers */
        MyTopicSubscriber observer1 = new MyTopicSubscriber(topic);
        MyTopicSubscriber observer2 = new MyTopicSubscriber(topic);
        MyTopicSubscriber observer3 = new MyTopicSubscriber(topic);


        /** Registering observers */
        topic.register(observer1);
        topic.register(observer2);
        topic.register(observer3);

//        /** Attach observer to topic || subject */
//        observer1.setTopic(topic);
//        observer2.setTopic(topic);
//        observer3.setTopic(topic);


        observer1.update();

        topic.postMessage("#Click: New Click Message");

    }
}
