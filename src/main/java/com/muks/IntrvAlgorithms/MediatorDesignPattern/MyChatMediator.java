package com.muks.IntrvAlgorithms.MediatorDesignPattern;

import com.muks.IntrvAlgorithms.MediatorDesignPattern.Abstraction.ChatMediator;
import com.muks.IntrvAlgorithms.MediatorDesignPattern.Abstraction.ChatUser;
import com.sun.tools.internal.ws.wsdl.framework.DuplicateEntityException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mukthar.ahmed on 3/29/16.
 *
 *  - "ChatMediator" implementation
 */
public class MyChatMediator extends ChatMediator {

    private List<ChatUser> groupUsers;
    private String groupName;

    public MyChatMediator(String name) {
        this.groupName = name;
        groupUsers = new ArrayList<>();
    }


    public String getName() { return this.groupName; }


    @Override
    public void publishMessage(String msg) {
        for (ChatUser user : groupUsers) {
            user.receiveMessage(msg);
        }
    }

    @Override
    public void addUser(ChatUser username) throws Exception {
        if ( !groupUsers.contains(username) ) {
            groupUsers.add(username);
        }
        else {
            throw new Exception("# User is already a part of the group.");
        }

    }
}
