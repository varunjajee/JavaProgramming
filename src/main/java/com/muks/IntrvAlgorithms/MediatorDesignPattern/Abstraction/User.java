package com.muks.IntrvAlgorithms.MediatorDesignPattern.Abstraction;

/**
 * Created by mukthar.ahmed on 3/29/16.
 */
public class User extends ChatUser {

    public User(String name, ChatMediator chatMediator) {
        super(name, chatMediator);
    }



    public void send(String msg) {
        System.out.println("# Publishing Msg: " + msg);
        this.getMediator().publishMessage(msg);
    }

    @Override
    public void receive(String msg) {
        System.out.println("# " + this.getName() + ", Received Msg: " + msg);

    }
}
