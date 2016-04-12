package com.muks.Algorithm.AlgosOnArrays.Matrix;

/**
 * Created by mukthar.ahmed on 4/12/16.
 * <p>
 * - Given a matrix of characters, find all the words in the matrix
 */
public class SearchWords{
    static String[] Dictionary = {"GEEKS", "FOR", "QUIZ", "GO"};

    public static void main(String[] args) {
        char[][] matrix = {
            {'G', 'I', 'Z'},
            {'U', 'E', 'K'},
            {'Q', 'S', 'E'}
        };

        findWords(matrix);
    }


    private static void findWords(char[][] matrix) {
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        String str = "";

        int rows = matrix.length;
        int cols = matrix[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                findWordsHelper(matrix, visited, i, j, str);
            }
        }
    }

    private static void findWordsHelper(char[][] matrix, boolean[][] visisted, int i, int j, String str) {
        visisted[i][j] = true;  /** mark the as visisted */

        str = str + matrix[i][j];   /** Collect the current char, add to the str */

        if (isWord(str)) {
            System.out.println("# Found word: " + str);
        }

        for (int row = i - 1; row <= i + 1 && (row < matrix.length); row++) {
            for (int col = j - 1; col <= j + 1 && (col < matrix[0].length); col++) {
                if (row >= 0 && col >= 0) {
                    if (!visisted[row][col]) {
                        findWordsHelper(matrix, visisted, row, col, str);
                    }
                }

            }
        }

        str.substring(0, str.length() - 1);   /** Code control will reach here if not found, so keep removing char from str */
        visisted[i][j] = false;             /** revert visited, mark as false */

    }


    private static boolean isWord(String inStr) {
        for (String words : Dictionary) {
            if (inStr.equalsIgnoreCase(words)) {
                return true;
            }
        }
        return false;
    }

}
