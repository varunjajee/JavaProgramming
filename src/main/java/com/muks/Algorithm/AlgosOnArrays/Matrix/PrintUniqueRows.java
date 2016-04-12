package com.muks.Algorithm.AlgosOnArrays.Matrix;

import java.util.HashMap;

public class PrintUniqueRows {

    /**
     * This should be implemented using trie datastructure
     */

    public static void main(String[] args) {
        int[][] matrix = {
            {0, 1, 0, 0, 1},
            {1, 0, 1, 1, 0},
            {0, 1, 0, 0, 1},
            {1, 1, 1, 0, 0},
        };

        findUniqueRows(matrix);
    }

    private static boolean insert(int[][] matrix, int row, TrieNode root) {
        TrieNode currNode = root;

        for (int i = 0; i < matrix[0].length; i++) {

            if (matrix[row][i] == 0) {
                if (currNode.children[0] == null) {
                    TrieNode newNode = new TrieNode(0);

                    currNode.children[0] = newNode;
                    currNode = currNode.children[0];

                } else {
                    currNode = currNode.children[0];
                }
            } else {
                if (currNode.children[1] == null) {
                    TrieNode newNode = new TrieNode(1);

                    currNode.children[1] = newNode;
                    currNode = currNode.children[1];

                } else {
                    currNode = currNode.children[1];
                }
            }


        }


        /** If the last node was already traversed, then it would be with isLeaf = true */
        if (currNode.isLeaf) {
            //System.out.println("# Row = " + row + ", Dup = " + true);
            return true;
        } else {
            currNode.isLeaf = true;
            return false;
        }

    }

    private static void findUniqueRows(int[][] matrix) {
        Trie trie = new Trie(0);

        for (int row = 0; row < matrix.length; row++) {
            if (!insert(matrix, row, trie.root)) {
                printRow(matrix, row);
            }
        }
    }


    static class TrieNode {
        int value;
        boolean isLeaf;
        TrieNode[] children = new TrieNode[2];

        public TrieNode(int val) {
            this.value = val;
            this.children[0] = null;
            this.children[1] = null;
            this.isLeaf = false;
        }
    }

    static class Trie {
        TrieNode root;

        public Trie(int val) {
            this.root = new TrieNode(val);
        }
    }


    static void printRow(int[][] matrix, int row) {
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.print(" " + matrix[row][i]);
        }
        System.out.println("");
    }
}
