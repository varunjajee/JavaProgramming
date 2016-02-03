package com.muks.IntrvAlgorithms.SnakeAndLadderGame;

/*
 * Created by mukthar.ahmed on 1/30/16.
 */
public class BoardNode {
    public int ID;
    private BoardNode LADDER;
    private BoardNode SNAKE;

    // Constructor which initiates the node
    public BoardNode(int id) {
        this.ID = id;
        LADDER = null;
        SNAKE = null;
    }

    public String toString() {
        return "[" + ID + "]";
    }


    // public setters
    public void setLadder(BoardNode ladderNode) {
        this.LADDER = ladderNode;
    }

    public void setSnake(BoardNode snakedNode) {
        this.SNAKE = snakedNode;
    }


    // public getters
    public BoardNode getLadderUp(){
        return LADDER;
    }

    public BoardNode getSnakedDown(){
        return SNAKE;
    }

}   // end BoardNode
