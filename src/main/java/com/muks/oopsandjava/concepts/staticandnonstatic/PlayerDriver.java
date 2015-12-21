package com.muks.oopsandjava.concepts.staticandnonstatic;

/*
 * Created by mukthar.ahmed on 10/16/15.
 */
public class PlayerDriver {

    public static void main(String[] args) {
        System.out.println("+ String with " + Player.playerCount + " players..");
        Player player0 = new Player("Mukthar");
        System.out.println("+ Player # " + Player.playerCount + " is " + player0.getPlayerName());

        Player player1 = new Player("Tiger Woods");
        System.out.println("+ Player # " + Player.playerCount + " is " + player1.getPlayerName());

        String str = String.format("I have %,.2f bugs to fix...", 34523.8012300);
        System.out.println("\n+ Formatted string: " + str);
    }

}
