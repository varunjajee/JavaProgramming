package com.muks.ola.SnakeAndLadderGame;

/*
 * Created by mukthar.ahmed on 1/30/16.
 */

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Player implements Runnable {
    private ThreadLocal<Integer> PLAYER_THRESHOLD = new ThreadLocal<>();

    //int PLAYER_THRESHOLD = 5;       // ToDo: setting it low for testing purpose
    private ThreadLocal<Integer> ROUNDS = new ThreadLocal<>();

    BoardNode CURRENT;
    GameBoard gameBoard = new GameBoard();

    // Constructor
    public Player() {

        CURRENT = gameBoard.getBoardNode(1);
    }



    public void run() {
        PLAYER_THRESHOLD.set(5);
        ROUNDS.set(0);

        System.out.println("\n+ Player - " + Thread.currentThread().getName()
                + ", Check if player can proceed: ");

        System.out.println("+ Rounds: " + ROUNDS.get() );
        System.out.println("Threshold: " + PLAYER_THRESHOLD.get());

        for (int i = 0; i <= 200; i++) {
            System.out.println(" YES, " + Thread.currentThread().getName() + " can proceed...");
            playGame();
        }

        System.out.print(" GAME OVER MY BOYS - "
                + Thread.currentThread().getName() );

    }


    private synchronized void playGame() {
        ROUNDS.set(ROUNDS.get()+1);                      // increment rounds by 1
        int diced = Dice();                 // Dice it

        // ToDo: Debug purpose
        System.out.println(Thread.currentThread().getName()+ " has Dice = " + diced
                + ", Current Node = " + this.CURRENT.ID
                + ", Total Rounds Played = " + ROUNDS.get());

        // Move board by:
        int originalNodeVal = this.CURRENT.ID;
        int currentMove = diced + originalNodeVal;

        // If some1 standing at 99, exceeds 100, then no-move
        BoardNode toNode;
        if (currentMove > 99) {
            toNode = gameBoard.getBoardNode(originalNodeVal);
        }
        else {

            System.out.println("+ Current Move: " + currentMove);
            toNode = gameBoard.getBoardNode(currentMove);

            if (toNode.getLadderUp() != null) {
                toNode = toNode.getLadderUp();
            }

            if (toNode.getSnakedDown() != null) {
                toNode = toNode.getSnakedDown();
            }


            this.CURRENT = toNode;
            System.out.println("\n+ " + Thread.currentThread().getName() + " is at - "
                    + this.CURRENT.toString());


            // Ending the game if either of the player reached - 100
            if (this.CURRENT.ID == 100) {
                Thread.interrupted();
            }
        }

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

        Thread p2 = new Thread(player);
        p2.setName("Robbin");

//        p1.start();
//        p2.start();



        /* =====================================================================================
            Use executor service to control the works in terms of
                1. No. of worker threads
                2. Worker threads shutdown once done.
         */
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(p1);
        executorService.execute(p2);

        executorService.shutdown();     // showdown all worker threads

        long waitTime = 1000;
        try {
            executorService.awaitTermination(waitTime, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }

}
