package com.muks.oopsandjava.concepts.a_BasicCode;

import java.io.*;

/**
 * Created by mukthar.ahmed on 4/15/16.
 *
 *  Java file reader & writer examples
 */
public class FileReadWriteHandlers {

    public static void main(String[] args) {
        new FileReadWriteHandlers().WriteFile();
    }

    public void ReadFile() {
        String infile = "/Users/mukthar.ahmed/Downloads/infile.txt";

        try {
            BufferedReader bufferedReader = new BufferedReader(new java.io.FileReader(new File(infile)));

            String line;
            try {
                while (( line=bufferedReader.readLine() ) != null) {
                    System.out.println("# Line: " + line);

                }

                bufferedReader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void WriteFile() {
        String writeFile = "/Users/mukthar.ahmed/Downloads/writefile";

        try {
            PrintWriter printWriter = new PrintWriter(new File(writeFile + "-1.txt"));
            printWriter.write("first line");
            printWriter.write("second line");

            printWriter.close();

            FileOutputStream fileOutputStream = new FileOutputStream(new File(writeFile + "-2.txt"));
            fileOutputStream.write(new String("First").getBytes());
            fileOutputStream.write(new String("\n").getBytes());
            fileOutputStream.write(new String("second").getBytes());

            fileOutputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
