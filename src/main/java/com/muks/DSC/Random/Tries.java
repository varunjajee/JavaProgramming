//package com.muks.datastructures;
//
//import com.muks.DSC.Tries.TrieNode;
//
//public class Tries {
//
//	private static TrieNode root;
//
//
//	public Tries() {
//		root = new TrieNode(' ');
//	}
//
//
//	// ##########################################################################################
//	// insert method to insert a string into a trie
//
//	public static void insert (String s){
//		TrieNode current = root;
//
//		if(s.length()==0) { 	//For an empty character
//			current.marker=true;
//		}
//
//		for(int i = 0; i < s.length()-1; i++) {
//			TrieNode child = current.subNode(s.charAt(i));
//			if (child != null) {
//				current = child;
//
//			} else {
//				current.child.add(new TrieNode(s.charAt(i)));
//				current = current.subNode(s.charAt(i));
//
//			}
//
//			// Set marker to indicate end of the word
//			if( i == s.length()-1 ) {
//				current.marker = true;
//			}
//
//		}
//	}
//
//
//	// ####################################################################################################
//	// Search in a trie
//	public static boolean search(String s){
//		TrieNode current = root;
//
//		while(current != null) {
//			for(int i=0;i<s.length();i++) {
//				if(current.subNode(s.charAt(i)) == null) {
//					return false;
//
//				} else {
//					current = current.subNode(s.charAt(i));
//
//				}
//
//			}
//
//			/*
//			 * This means that a string exists, but make sure its
//			 * a word by checking its 'marker' flag
//			 */
//			if (current.marker == true) {
//				return true;
//			} else {
//				return false;
//			}
//
//		}
//		return false;
//	}
//
//
//	public static void lib(String[] args) {
//		insert("mukthar");
//	}
//
//}	//	end class
