package com.muks.IntrvAlgorithms.LargeFileReverseReader;

import java.io.*;

/**
 * Created by mukthar.ahmed on 3/16/16.

 * Link: ???
 *
 * Alternatively, Radix sort algorithm works with O(n) space
 * Link: http://www.codeproject.com/Articles/490755/Sorting-Variable-Length-Strings-in-O-N-Time
 *
 */
public class ReverseFile {

    public static void main(String[] args) throws IOException {
        String inputFile = "/Users/mukthar.ahmed/Documents/file1.txt";

        /** Create the large input file */
        File file = new File(inputFile);
        RandomAccessFile raf = new RandomAccessFile(file, "rw");

        for (int i = 0; i <= 3; i++) {
            raf.writeBytes("Adding Line number " + i + "\n");              // Adding line from 1 to 10
        }
        raf.close();


//        /** Simple way to read file without Reversing */
//        FileReadWriteHandlers logReader = new FileReadWriteHandlers(inputFile);
//        BufferedReader bufferedReader = new BufferedReader(logReader);
//        System.out.println("Simple way to read file without Reversing - from 1 to 10");
//
//        String line1;
//        while ( (line1 = bufferedReader.readLine()) != null) {
//            System.out.println(line1);
//        }

        /** Reading file in reverse order.. Will return line from 10 to 1 */
        ReverseLineReaderCore reader = new ReverseLineReaderCore(file, "UTF-8");
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
