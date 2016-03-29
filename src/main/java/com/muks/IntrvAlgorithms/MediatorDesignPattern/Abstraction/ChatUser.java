package com.muks.IntrvAlgorithms.MediatorDesignPattern.Abstraction;

/**
 * Created by mukthar.ahmed on 3/29/16.
 *
 *
 *      "ChatUser" object abstraction
 *
 *
 */
public abstract class ChatUser {
    private String userName;
    private ChatMediator chatMediatorName;

    public ChatUser(String name, ChatMediator chatMediator) {
        this.userName = name;
        this.chatMediatorName = chatMediator;

        try {
            this.chatMediatorName.addUser(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ChatMediator getMediator() { return this.chatMediatorName; }

    public abstract void sendMessage(String msg);

    public abstract void receiveMessage(String msg);

    public String getName() { return this.userName; }

}
