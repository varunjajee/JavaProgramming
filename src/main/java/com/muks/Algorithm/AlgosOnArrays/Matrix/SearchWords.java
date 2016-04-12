package com.muks.Algorithm.AlgosOnArrays.Matrix;

/**
 * Created by mukthar.ahmed on 4/12/16.
 * <p>
 * - Given a matrix of characters, find all the words in the matrix
 */
public class SearchWords{
    static String[] dictionary = {"GEEKS", "FOR", "QUIZ", "GO"};

    public static void main(String[] args) {
        char[][] matrix = {
            {'G', 'I', 'Z'},
            {'U', 'E', 'K'},
            {'Q', 'S', 'E'}
        };

        findWords(matrix);
    }

    /**
     * Prints all words present in dictionary
     */
    static void findWords(char[][] boggle) {
        // Mark all characters as not visited
        boolean[][] visited = new boolean[boggle.length][boggle[0].length];

        // Initialize current string
        String str = "";

        int rows = boggle.length;
        int cols = boggle[0].length;

        // Consider every character and look for all words starting with this character
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                findWordsUtil(boggle, visited, i, j, str);
            }
        }
    }



    // A recursive function to print all words present on boggle
    static void findWordsUtil(char[][] boggle, boolean[][] visited, int i, int j, String str) {
        // Mark current cell as visited and append current character to str
        visited[i][j] = true;
        str = str + boggle[i][j];

        // If str is present in dictionary, then print it
        if (isWord(str)) {
            System.out.println("# String: " + str);
        }

        // Traverse 8 adjacent cells of boggle[i][j]
        for (int row = i-1; row <= i+1 && row < boggle.length; row++) {
            for (int col = j - 1; col <= j + 1 && col < boggle[0].length; col++) {


                if (row >= 0 && col >= 0) {

                    if ( !visited[row][col] ) {
                        findWordsUtil(boggle, visited, row, col, str);
                    }
                }
            }
        }

        // Erase current character from string and mark visited of current cell as false
        str.substring(0, str.length()-1);
        visited[i][j] = false;
    }


    /** Check if the word exists in the dictionary array */
    static boolean isWord(String str) {
        for (String wordInDictionay : dictionary) {
            if (str.equalsIgnoreCase(wordInDictionay)) {
                return true;
            }
        }
        return false;
    }
}
