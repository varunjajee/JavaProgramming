package com.muks.Algorithm.AlgoBasics;

public class FirstNonRepeatedAndMostRepeated {

	/**
	 * Algorithm:
	 * 	1. Build the name structure of character count
	 * 		=> foreach character in the string, 
	 * 				incrementAndGet its corresponding char count in the array
	 * 
	 * 	2. Search name structure for character count
	 * 		=> Array implementation: 
	 * 			for each character in the string, return the char object which has the character count which is looked for.
	 * 				return char object
	 * 
	 */

	public static void main(String[] args) {
		String str = "Hello world";
		int len = str.length();

		System.out.println("+++ Character repeated for 1: " + CharCountArray(str, 3) );
		

	} // end lib()

	
	
	
	// ##############################################################################################################

	// NOTE (Important) : Return type is "Character" object rather than char, is to allow us to return null if nothing is found. 
	public static Character CharCountArray (String str, int place) {

		int[] arrayStore = new int[128]; // limit = 128, this is a javapack dsc and its limited to ASCII character set which is of 128 characters

		// Initialize the array with 0 - char count
		for (int i = 0; i < str.length(); i++) {
			arrayStore[i] = 0;			
		}
		
		
		// incrementAndGet the char count
		for ( char c : str.toCharArray() ) {
			arrayStore[c]++;
			System.out.println("+++ character: " + c + " => " + arrayStore[c]);
		}
		
		
		System.out.println("+++ Final Array: " + arrayStore.length);
		for (int n = 0; n < arrayStore.length -1; n++) {
			System.out.println(arrayStore[n]);
		}
		
		// Find the char which occurs for max number of times:
		char max = str.charAt(0);
		for (char c: str.toCharArray() ) {
			System.out.println("+++ arrayStore: " + c + " => arrayStore[c]" + arrayStore[c]);
			
			if ( arrayStore[max] < arrayStore[c] ) {
				max = c;
			}
			
		}
				
		return max;

		// ##############################################################################################################	
//		// find the occurrence where the number is given as a arg.
//		// Eg: char which occurs for 1ce = place = 1
//		for (char c : str.toCharArray() ) {
//			if ( arrayStore[c] == place ) {
//				return c;
//			}
//		}
//		
//		return null;
		// ##############################################################################################################		
		
	}
	
	
	
	// ##############################################################################################################
	// recursive method to find max
	public static int getMax (int[] arr, int n, int max) {
		
		while ( n >= 0 ) { 	// while is required, else we encounter arrayoutofbound exception coz it moves to (n = -1)

			if(max < arr[n]) {
				max = arr[n];
				return getMax(arr, n-1, max);
			
			} else { // else statement is very much required else the code works only on sorted array.
				return getMax(arr, n-1, max);
			}
			
		}
		
		return max;
		
	} // end max()
	// ##############################################################################################################
	
} // end class

