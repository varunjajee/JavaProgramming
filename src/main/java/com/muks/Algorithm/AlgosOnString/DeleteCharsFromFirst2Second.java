package com.muks.Algorithm.AlgosOnString;

public class DeleteCharsFromFirst2Second {

	/*
	 * A function that takes two strings as arguments and removes the characters from first string which are present 
	 * in second string (mask string).
	 * 
	 * Complexity: O(n)
	 * 
	 */
	
	public static void main(String[] args) {
		String s1 = "geeks for geeks";
		String s2 = "mask";

		removeDuplicates(s1, s2);

	}
	
	
	// ##################################################################################################################
	// Method which removes the duplicate chars
	
	public static void removeDuplicates(String s1, String s2) {
		boolean[] arrayStore = new boolean[128];

		// mark true if the char is present in the string
		for (char c : s2.toCharArray()) {
			arrayStore[c] = true;
		}
		

		String f = "";
		for (char c : s1.toCharArray()) {
			if (arrayStore[c] == false) {
				f += c;
			}
		}
		
		System.out.println("+++ Final string: " + f);

	}	// removeDup()

	
}	// end class
