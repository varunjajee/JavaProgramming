package com.muks.Algorithm.AlgosOnArrays.Matrix;

import java.util.*;


public class MatrixFindWords {

	public static void main(String[] args) {

		// Q1: Find all possible words from the 2D array
		//	Ans: Insert all the chars into a graph and do a breadth first1BinarySearch search to find words
		Character[][] wordMat = {
				{'a', 'f', 'h', 'u', 'n'},
				{'e', 't', 'a', 'i', 'r'},
				{'a', 'e', 'g', 'g', 'o'},
				{'t', 'r', 'm', 'l', 'p'}

		};

		Character[][] matrix = {
				{'g','o','d', 'b', 'o', 'd','y'},
				{'t','a','m','o' ,'p','r','n'}, 
				{'u','i','r','u','s', 'm', 'p'}
		};


		String[] rawWords = {"eat", "ate"};
		String[] rawList = {"god", "goat", "godbody", "amour", "net"};

		String[] vuelta = find (wordMat, rawWords);
		printArray(vuelta);
		//System.out.println(vuelta.toString());

	}


	public static String[] find(Character[][] matrix, String[] rawList){

		List<Character> lsCharTotal = new ArrayList<Character>();
		List<String> wordtotal = new ArrayList<String>();
		
		for (Character[] line: matrix){
			lsCharTotal.addAll(Arrays.asList(line));
		}
		
		String total = "";
		for (Character c: lsCharTotal) {
			total += c + " ";
		}
		System.out.println("+++ Total chars: " + total);
		
		for (String word: rawList){
			List<Character> lsCharWord = new ArrayList<Character>();
			
			for (Character charAux : word.toCharArray()) {
				lsCharWord.add(charAux);
			}

			if (lsCharTotal.containsAll(lsCharWord)) {		// just check if all the chars are in the list using .containsAll()
				wordtotal.add(word);
			}
			
		}
		
		return wordtotal.toArray(new String[wordtotal.size()]);
		
	}

	
	
	public static void printArray(String[] arr) {
		String s = "";
		for (String a: arr) {
			s += a + " ";
		}
		System.out.println("+++ Array: " + s);
	}

}


