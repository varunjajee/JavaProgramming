package com.muks.Algorithm.Dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*  Created by mukthar.ahmed on 1/13/16.

    Problem definition:
        - Given a dictionary of words, find if a word exists in a dictionary.
 */

public class FromInputQuery {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        System.out.print("Enter a query: ");
        String input = cin.nextLine();
        try{
            String line;
            BufferedReader br = new BufferedReader(
                    new FileReader("/Users/mukthar.ahmed/Downloads/dictionary.txt"));

            while ((line = br.readLine()) != null ) {
                String[] words = line.split(" ");

                for (String w: words) {
                    String p = "^" + input.replaceAll("\\*", ".*") + "$";
                    if (w.matches(p)) {
                        System.out.println(w);
                    }
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }

        System.exit(0);
    }
}
