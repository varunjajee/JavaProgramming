package com.muks.Algorithm.AlgosOnArrays.Matrix;

import java.util.*;


public class FindingWords {

    public static void main(String[] args) {

        // Q1: Find all possible words from the 2D array
        //	Ans: Insert all the chars into a graph and do a breadth first1BinarySearch search to find words
        Character[][] wordMat = {
            {'a', 'f', 'h', 'u', 'n'},
            {'e', 't', 'a', 'i', 'r'},
            {'a', 't', 'g', 'g', 'o'},
            {'t', 'r', 'm', 'l', 'p'}

        };

        Character[][] matrix = {
            {'g', 'o', 'd', 'b', 'o', 'd', 'y'},
            {'t', 'a', 'm', 'o', 'p', 'r', 'n'},
            {'u', 'i', 'r', 'u', 's', 'm', 'p'}
        };


        String[] rawWords = {"eat", "ate"};
        String[] rawList = {"god", "goat", "godbody", "amour", "net"};


        //wordFinder(wordMat, rawWords);

        findWord(wordMat, "ate");
    }


    private static void findWord(Character[][] matrix, String word) {
        char[] letters = word.toCharArray();

        // We'll need two "flag" variables.
        boolean over = false;
        boolean found = false;

        int rows = matrix.length;
        int cols = matrix[0].length;

        // Note the second condition in each for-loop:
        for (int i = 0; (i < rows) && (!over); i++) {
            for (int j = 0; (j < cols) && (!over); j++) {

                // Use (i,j) as the starting point.
                found = true;

                // Note the additional condition:
                for (int k = 0; (k < letters.length) && (found); k++) {

                    if ((j + k >= matrix[i].length) || (letters[k] != matrix[i][j + k])
                        || (letters[k] != matrix[i][j - k])) {
                        // Not a match.
                        found = false;
                    }
                }

                // If we went the whole length of the word, we found it.
                if (found) {
                    System.out.println("String " + word + " found in row=" + i + " col=" + j);
                    // Mark the end of the double-for here.
                    over = true;
                }

            }
        }

        // We print outside the double-for.
        if (!found) {
            System.out.println("String " + word + " not found");
        }
    }


    /**
     * Find word using List.containsAll()
     * */
    public static void wordFinder(Character[][] matrix, String[] wordsList) {
        List<Character> matrixChars = new ArrayList<>();
        List<String> wordtotal = new ArrayList<>();

        for (Character[] row : matrix) {
            matrixChars.addAll(Arrays.asList(row));
        }


        for (String word : wordsList) {
            List<Character> wordChars = new ArrayList<>();

            for (Character charAux : word.toCharArray()) {
                wordChars.add(charAux);
            }

            /** just check if all the chars are in the list using .containsAll()	*/
            if (matrixChars.containsAll(wordChars)) {
                wordtotal.add(word);
            }

        }

        System.out.println("# Words found are: " + wordtotal.toString());
    }
}


