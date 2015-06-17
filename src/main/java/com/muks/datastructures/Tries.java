package com.muks.datastructures;

import com.muks.datastructures.tree.binarytree.TNode;

public class Tries {

	private static TNode root;


	public Tries() {
		root = new TNode(' ');
	}


	// ##########################################################################################
	// insert method to insert a string into a trie

	public static void insert (String s){
		TNode current = root;

		if(s.length()==0) { 	//For an empty character
			current.marker=true;
		}

		for(int i = 0; i < s.length()-1; i++) {
			TNode child = current.subNode(s.charAt(i));
			if (child != null) {
				current = child;

			} else {
				current.child.add(new TNode(s.charAt(i)));
				current = current.subNode(s.charAt(i));

			}

			// Set marker to indicate end of the word
			if( i == s.length()-1 ) {
				current.marker = true;
			}

		}
	}

	
	// ####################################################################################################
	// Search in a trie
	public static boolean search(String s){
		TNode current = root;

		while(current != null) {
			for(int i=0;i<s.length();i++) {   
				if(current.subNode(s.charAt(i)) == null) {
					return false;

				} else {
					current = current.subNode(s.charAt(i));

				}

			}

			/*
			 * This means that a string exists, but make sure its
			 * a word by checking its 'marker' flag
			 */
			if (current.marker == true) {
				return true;
			} else {
				return false;
			}

		}
		return false;
	}


	public static void main(String[] args) {
		insert("mukthar");
	}

}	//	end class
