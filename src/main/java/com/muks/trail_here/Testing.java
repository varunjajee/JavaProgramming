package com.muks.trail_here;


import java.util.Scanner;
import java.util.Stack;

class Testing {

    public static void main(String[] args) {
        /**
         % 3 - Fizz
         % 5 - Buzz
         % 3 & %5 - FizzBuzz

         */

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();

        for (int i = 1; i <= input; i++) {
            if (i % 3 == 0) {
                System.out.println("Fizz");
            }
            else if (i % 5 == 0) {
                System.out.println("Buzz");
            }
            else if ( (i % 3 == 0) || (i % 5 == 0) ) {
                System.out.println("FizzBuzz");
            }
            else {
                System.out.println(i);
            }
        }
    }


}