package com.muks.headfirstjava.staticandnonstatic;

/*
 * Created by mukthar.ahmed on 10/16/15.
 */
public class Player {
    static int playerCount = 0;
    private static String playerName;

    public Player(String name) {
        playerName = name;
        playerCount++;
    }

    public String getPlayerName() {
        return playerName;
    }
}
