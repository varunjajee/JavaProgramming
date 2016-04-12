package com.muks.Algorithm.AlgosOnArrays.Matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mukthar.ahmed on 4/12/16.
 */
public class TryHere {


    public static void findWords(Character[][] matrix, List<String> wordsList) {

        List<Character> matrixChars = new ArrayList<>();

        for (Character[] row : matrix) {
            matrixChars.addAll(Arrays.asList(row));
        }


        for (String word :  wordsList) {
            List<Character> wordChars = new ArrayList<>();



        }
    }
}
