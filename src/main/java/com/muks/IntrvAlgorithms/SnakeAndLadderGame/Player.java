package com.muks.IntrvAlgorithms.SnakeAndLadderGame;

/*
 * Created by mukthar.ahmed on 1/30/16.
 */

import java.util.Random;

public class Player implements Runnable {
    int PLAYER_THRESHOLD = 15;       // ToDo: setting it low for testing purpose
    int ROUNDS;
    BoardNode CURRENT;
    GameBoard gameBoard = new GameBoard();

    // Constructor
    public Player() {
        this.ROUNDS = 0;
        this.CURRENT = gameBoard.getBoardNode(1);

        System.out.println("+ " + Thread.currentThread().getName() + " will be starting at "
        + this.CURRENT.toString());
    }



    public void run() {
        System.out.println("\n+ Player - " + Thread.currentThread().getName()
                + ", Check if player can proceed: ");
        try {
            Thread.sleep(Dice());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (ROUNDS <= this.PLAYER_THRESHOLD) {  // check on total rounds threshold
            System.out.println(" YES, " + Thread.currentThread().getName() + " can proceed...");
            playGame();
        }
        else {
            System.out.print(" NO, player " + Thread.currentThread().getName() + "'s GAME OVER.");

        }
    }


    private synchronized void playGame() {
            this.ROUNDS++;                      // increment rounds by 1

            int diced = Dice();                 // Dice it

            // ToDo: Debug purpose
            System.out.println("+ Dice = " + diced
                    + ", Current Node = " + this.CURRENT.ID
                    + ", Total Rounds Played = " + this.ROUNDS);

            // Move board by:
            int currentMove = diced + this.CURRENT.ID;
            System.out.println("+ Current Move: " + currentMove);

            BoardNode toNode = gameBoard.getBoardNode(currentMove);
            if (toNode.getLadderUp() != null) {
                toNode = toNode.getLadderUp();
            }

            if (toNode.getSnakedDown() != null) {
                toNode = toNode.getSnakedDown();
            }

            this.CURRENT = toNode;
            System.out.println("\n+ " + Thread.currentThread().getName() + " is at - "
                    + this.CURRENT.toString());

    }

    private static int Dice() {
        int max = 6;
        int min = 1;
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }



    public static void main(String[] args) {
        Player player = new Player();
        Thread p1 = new Thread(player);
        p1.setName("Rob");
//
//        Thread p2 = new Thread(player);
//        p2.setName("Robbin");

        p1.start();
//        p2.start();

    }

}
