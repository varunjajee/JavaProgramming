package com.muks.DSC.Rope;

import java.util.Scanner;

/**
 * Created by mukthar.ahmed on 2/17/16.
 *
 * TestCallable class
 *
 **/
public class TestingRope {

    /** Class RopeTest **/
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Rope rope = new Rope();
        System.out.println("Rope Testing");


        /**  Perform rope operations  **/
        while(true) {

            System.out.println("\nSupported Rope Operations\n");
            System.out.println("0. Exit() ");
            System.out.println("1. concat ");
            System.out.println("2. get character at index");
            System.out.println("3. substring");
            System.out.println("4. clear");


            int choice = scan.nextInt();
            scan.nextLine();

            switch (choice) {
                case 0:
                    System.out.println("+ Exit called.");
                    System.exit(0);
                    break;
                case 1:
                    System.out.println("(Choice - 1) Enter string to concat: ");
                    String line = scan.nextLine();
                    rope.concat(line);

                    break;
                case 2:
                    System.out.println("(Choice - 2)Enter index");
                    System.out.println("Character at index = " + rope.indexAt(scan.nextInt()));

                    break;
                case 3:
                    System.out.println("(Choice - 3)Enter integer start and end limit");
                    System.out.println("Substring : " + rope.substring(scan.nextInt(), scan.nextInt()));

                    break;
                case 4:
                    System.out.println("\n(Choice - 4)Rope Cleared\n");
                    rope.makeEmpty();

                    break;
                default:
                    System.out.println("Wrong Entry \n ");
                    break;
            }


            /**  Display rope  **/
            System.out.print("\nRope : ");
            rope.print();

            //System.out.println("+ Height = " + Rope.isBalanced(rope.root) );

        }

    }
}
