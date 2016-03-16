package com.muks.IntrvAlgorithms.ReverseLargeFiles;

import java.io.*;

/**
 * Created by mukthar.ahmed on 3/16/16.
 * - Reverse file contents
 */
public class ReverseFile {

    public static void main(String[] args) throws IOException {
        String inputFile = "/Users/mukthar.ahmed/Documents/file1.txt";

        /** Create the large input file */
        File file = new File(inputFile);
        RandomAccessFile raf = new RandomAccessFile(file, "rw");

        for (int i = 0; i <= 5; i++) {
            raf.writeBytes("Adding Line number " + i + "\n");              // Adding line from 1 to 10
        }
        raf.close();


//        /** Simple way to read file without Reversing */
//        FileReader logReader = new FileReader(inputFile);
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
        System.out.print("\nReading file in reverse order - from 10 to 1");
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
