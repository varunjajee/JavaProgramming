package com.muks.oopsandjava.concepts.exceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Created by mukthar.ahmed on 1/11/16.

    Checked exeception:
        - FileNotFound or other custom checked exception

    Un-Checked exception:
        - Arithmetic (10/0) or ArrayIndexOutOfBound exceptions, null pointer exceptions
        - These types are caught during run time due to user's bad input
 */
public class ExceptionTypes {

    // Checked exception - which compiler checks

    public void readFile() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("/usr/local/file.txt"));
        String line = br.readLine();

        while (line != null) {
            System.out.println("+ Line = " + line);
        }
        br.close();
    }

    // un-checked exception
    public static void unchecked() {
        int x = 0;
        int y = 10;
        int z = y/x;        // => This line throws un-checked runtime Arithmetic exception
    }

    public static void main(String[] args) {
        unchecked();
    }
}
