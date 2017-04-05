package com.muks.IntrvAlgorithms.WordsWithoutSplit;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by mukthar.ahmed on 3/5/16.
 */
public class WordsWithoutSplit {

    public static void main(String[] args) {
        String in = "this  is me here";
        //usingStringTokenizer(in);
        wordCounter(in);

//        String inFile = "/Users/mukthar.ahmed/Data/git/personal/JavaProgramming/src/lib/java/com/muks/IntrvAlgorithms/WordsWithoutSplit/WordCountFile.txt";
//        WordsInFile(inFile);
    }

    /** ====================  Read file and count total words in it ==================== */
    private static void WordsInFile(String filePath) {
        int wordCounter = 0;
        int lineCounter = 0;
        int charCounter = 0;

        try {
            FileReader fileReader = new FileReader(new File(filePath));
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ( (line = bufferedReader.readLine()) != null) {
                charCounter += line.length();
                lineCounter++;
                wordCounter += wordCounter(line);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Lines = " + lineCounter + ", Words = " + wordCounter + ", Chars = " + charCounter);
    }


    private static int wordCounter(String str) {
        String state = "OUT";
        int wc = 0;  // word count

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ' || str.charAt(i) == '\n' || str.charAt(i) == '\t') {
                state = "OUT";

            }
            else if (state == "OUT") {    // If next character is not a word separator and state is OUT,
                state = "IN";	            // then set the state as IN and incrementAndGet word count
                wc++;
                System.out.println("+ wc = " + wc);

            }
            System.out.println("Status = " + state + ", i = " + i);
        }

        System.out.println(wc);
        return wc;
    }

    /** ====================  Word counter code using StringTokenizer() API ==================== */
    private static void usingStringTokenizer(String inStr) {
        int wordCounter = 0;

        StringTokenizer st = new StringTokenizer(inStr, " ");
        while (st.hasMoreTokens()) {
            wordCounter++;
            System.out.println(" " + st.nextToken() );
        }

        System.out.println("+ Total Words: " + wordCounter);
    }


}
