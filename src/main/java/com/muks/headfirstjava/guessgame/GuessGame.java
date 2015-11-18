package com.muks.headfirstjava.guessgame;

/**
 * Created by mukthar.ahmed on 12/09/15.
 */
public class GuessGame {
    // declaring player variables here
    Player p1;
    Player p2;
    Player p3;

    public void startTheGame() {
        p1 = new Player();
        p1.setName("John");

        p2 = new Player();
        p2.setName("Jonny");

        p3 = new Player();
        p3.setName("Janardhan");

        boolean p1IsRight, p2IsRight, p3IsRight;
        p1IsRight = p2IsRight = p3IsRight = false;

        int realNumber = (int) (Math.random() * 10);
        System.out.println("+ Hey, I've thought of a random number between 0 to 9...");

        while (true) {
            System.out.println("+ Correct answer = " + realNumber + ", lets see who has guessed "
                + "right...");

            // make the players to guess
            p1.guess();
            p2.guess();
            p3.guess();

            System.out.println("Here we go with the guesses...");

            // Compare the guessesedNumber by players with the realNumber
            if (p1.guessedNubmer == realNumber) {
                p1IsRight = true;

            } else if (p2.guessedNubmer == realNumber) {
                p2IsRight = true;

            } else if (p3.guessedNubmer == realNumber) {
                p3IsRight = true;

            }

            System.out.println("");
            if (p1IsRight || p2IsRight || p3IsRight) {
                if (p1IsRight) {
                    System.out.println("+ Winner: " + p1.getPlayerName());
                }
                if (p2IsRight) {
                    System.out.println("+ Winner: " + p2.getPlayerName());
                }
                if (p3IsRight) {
                    System.out.println("+ Winner: " + p3.getPlayerName());
                }
                System.out.println("+ Done with the game +");
                break;

            } else {
                System.out.println("\n+ Ah, no player could make it, playes will have to retry "
                    + "again.\n");

            }
        }
    }
}
