package com.muks.IntrvAlgorithms.SnakeAndLadderGame;

/*
 * Created by mukthar.ahmed on 1/30/16.
 */

public class GameBoard {
    public BoardNode[] GAME_BOARD = new BoardNode[100];

    // Non-static initializer
    {
        for (int i = 0; i < 100; i++) {
            GAME_BOARD[i] = new BoardNode(i+1);
        }
        addLaddersUp();
        addSnakedDown();
    }


    // Constructor
    public GameBoard() {}


    // Yeppieee, Ladders, to step-up the board
    private void addLaddersUp() {
        getBoardNode(4).setLadder(getBoardNode(14));
        getBoardNode(9).setLadder(getBoardNode(31));
        getBoardNode(20).setLadder(getBoardNode(38));
        getBoardNode(4).setLadder(getBoardNode(14));
        getBoardNode(28).setLadder(getBoardNode(84));
        getBoardNode(4).setLadder(getBoardNode(14));
        getBoardNode(40).setLadder(getBoardNode(59));
        getBoardNode(51).setLadder(getBoardNode(67));
        getBoardNode(63).setLadder(getBoardNode(81));
        getBoardNode(71).setLadder(getBoardNode(91));

    }   // end addLaddersUp();


    // Hizz, you got snake bite down the board nodes :-)
    private void addSnakedDown() {
        getBoardNode(17).setSnake(getBoardNode(7));
        getBoardNode(54).setSnake(getBoardNode(34));
        getBoardNode(64).setSnake(getBoardNode(60));
        getBoardNode(62).setSnake(getBoardNode(19));
        getBoardNode(87).setSnake(getBoardNode(24));
        getBoardNode(93).setSnake(getBoardNode(73));
        getBoardNode(95).setSnake(getBoardNode(75));
        getBoardNode(99).setSnake(getBoardNode(78));

    }


    // Get board node to add ladders and snakes
    public BoardNode getBoardNode(int i) {
        return GAME_BOARD[i-1];     // as the array is referenced by i-1 index #
    }




    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();

        int i = 17;
        System.out.println("Board Node = " + gameBoard.getBoardNode(i).toString());

        System.out.println("+ Node ID = " + gameBoard.getBoardNode(i).toString()
        + ", Ladder = " + gameBoard.getBoardNode(i).getLadderUp()
        + ", Snaked = " + gameBoard.getBoardNode(i).getSnakedDown());

    }

}
