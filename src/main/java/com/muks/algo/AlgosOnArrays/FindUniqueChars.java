package com.muks.algo.AlgosOnArrays;

public class FindUniqueChars {

	public static void main(String[] args) {
		//String str1 = "abcde";
		String str2 = "ababad";

		System.out.println("\n+++ Has unique characters: " + isUniqueChars2(str2) );
		
	}

	
	
	public static boolean isUniqueChars2(String str) { 
		boolean[] char_set = new boolean[256];
		for (int i = 0; i < str.length(); i++) {
			int val = str.charAt(i);
			
			if (char_set[val]) 
				return false; 
			
			char_set[val] = true;
		}
		return true;
	}

	
	
	
	
	
	public static boolean isUniqueChars(String str) { 
		int checker = 0;
		
		for (int i = 0; i < str.length(); ++i) {
			int val = str.charAt(i) - 'a';
			
			if ((checker & (1 << val)) > 0) 
				return false; 
			
			checker |= (1 << val);
		}
		return true;
	}



}
