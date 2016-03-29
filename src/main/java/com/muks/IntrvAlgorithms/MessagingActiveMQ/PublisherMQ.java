package com.muks.IntrvAlgorithms.MessagingActiveMQ;

/**
 * Created by mukthar.ahmed on 3/29/16.
 */


import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

public class PublisherMQ {

    private ConnectionFactory factory = null;
    private Connection connection = null;
    private Session session = null;
    private Destination destination = null;
    private MessageProducer producer = null;


    public void sendMessage() {
        try {
            /** default broker URL is : tcp://localhost:61616 */
            factory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_BROKER_URL);
            connection = factory.createConnection();
            connection.start();

            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            destination = session.createQueue("MYTOPIC");

            producer = session.createProducer(destination);
            TextMessage message = session.createTextMessage();
            message.setText("PublisherMq: Hello, Sending sample msg!");
            producer.send(message);
            System.out.println("Sent: " + message.getText());

            // connection.close();  /** This drops the connection */

        } catch (JMSException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        PublisherMQ sender = new PublisherMQ();
        sender.sendMessage();
    }


}

