package com.muks.IntrvAlgorithms.MediatorDesignPattern.Abstraction;

/**
 * Created by mukthar.ahmed on 3/29/16.
 *
 *
 *      "ChatMediator" abstract class - since we have to have some minor implementation
 *
 */

public abstract class ChatMediator {

    public abstract void publishMessage(String msg);

    public abstract void addUser(ChatUser name) throws Exception;
}
