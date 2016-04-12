package com.muks.Algorithm.AlgosOnArrays.Matrix;

public class PrintUniqueRows {

	/**
	 * This should be implemented using trie datastructure
	 */
	
	public static void main(String[] args) {
		

	}


	static class TrieNode {
		boolean idEndOfCol;

		TrieNode[] children = new TrieNode[2];
	}

	static class Trie {
		int count;
		TrieNode root;

		public Trie() {
			this.root = null;
		}
	}
//
//    boolean insert( TrieNode root, int[][] matrix, int row, int col ){
//        // base case
//        if ( *root == NULL )
//        *root = newNode();
//
//        // Recur if there are more entries in this row
//        if ( col < COL )
//            return insert ( &( (*root)->child[ M[row][col] ] ), M, row, col+1 );
//
//        else // If all entries of this row are processed
//        {
//            // unique row found, return 1
//            if ( !( (*root)->isEndOfCol ) )
//            return (*root)->isEndOfCol = 1;
//
//            // duplicate row found, return 0
//            return 0;
//        }
//    }
}
