package com.muks.oopsandjava.concepts.guessgame;

/**
 * Created by mukthar.ahmed on 12/09/15.
 */
public class Player {
    int guessedNubmer = 0;
    private String playerName = "";

    public void setName(String name) {
        this.playerName = name;
    }

    public String getPlayerName() {
        return this.playerName;
    }

    public void guess() {
        guessedNubmer = (int) (Math.random() * 10);
        System.out.println(this.playerName + " guessed - " + guessedNubmer);
    }
}
