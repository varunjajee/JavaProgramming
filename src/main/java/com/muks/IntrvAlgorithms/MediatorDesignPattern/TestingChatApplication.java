package com.muks.IntrvAlgorithms.MediatorDesignPattern;

import com.muks.IntrvAlgorithms.MediatorDesignPattern.Abstraction.User;

/**
 * Created by mukthar.ahmed on 3/29/16.
 */
public class TestingChatApplication {
    public static void main(String[] args) {

        MyChatMediator familyGroup = new MyChatMediator("family");

        User u1 = new User("user#1", familyGroup);
        User u2 = new User("user#2", familyGroup);
        User u3 = new User("user#3", familyGroup);


        u1.send("# Welcome to family group....");
    }
}
