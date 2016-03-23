package com.muks.IntrvAlgorithms.LargeFileReverseReader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by mukthar.ahmed on 3/23/16.
 * <p>
 * Reading file using bufferred reader with a limited size
 */

public class FileReaderBufferredReader {

    public static void main(String[] args) {
        int bufferSize = 8 * 1024;

        try {
            BufferedReader bufferedReader =
                new BufferedReader(new FileReader("/Users/mukthar.ahmed/Documents/file1.txt"), bufferSize);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
