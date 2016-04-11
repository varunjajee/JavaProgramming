package com.muks.Algorithm.AlgoBasics;

public class Palindrome {

	/*
	 * NOTE:
	 * -----
	 *  Complexity = O(n/2)
	 * 
	 */
	
	public static void main(String[] args) {
		//String str = "malayalam";
		//String str = "madam";
		String str = "toot";
		//String str = "bccbmad";
		
		if (findPalindrome(str))
			System.out.println("YES, Is palindrome... ");
		else
			System.out.println("NOT a palindrome");
			
	} // end main

	
	// find pal sub
	public static boolean findPalindrome(String str) {
		
		// if ( str.length()%2 != 0) {		// DO NOT USE THIS COZ PALINDROME CAN BE EVEN OR OOD
		int i = 0, j = str.length() - 1;
		boolean status = false;
		
		while ( i <= j ) {
			System.out.println("i=" + i + " : " + "j=" + j + " " + str.charAt(i) + " <=> " + str.charAt(j));
			if ( str.charAt(i) == str.charAt(j) ) {
				i++;
				j--;
				
				status = true;
				
			} else {
				status = false;
				return status;
				
			} 
		}
				
		return status;
		
	} // end findPalindrome()
	

} // end class
