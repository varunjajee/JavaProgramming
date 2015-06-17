package com.muks.algo;
import java.util.ArrayList;
import java.util.HashMap;

import sun.security.action.GetLongAction;

// http://www.ritambhara.in/longest-substring-of-unique-characters/

/*
 * Q: Find the longest substring having non-repated characters
 */

public class LongestSubString {

	public static void main(String[] args) {
		findLongestSubStr("ababaefabc");
		
		findLongestSubStr("ABDEFGABEF");
		
	} // main()
	
	
	
	public static void findLongestSubStr (String str) {
		System.out.println("+ String: " + str);
		
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String unique = new String();
		ArrayList<String> subStrings = new ArrayList<String>();
		String longestSubStr = "";
		
		for (char c : str.toCharArray()) {
			//System.out.println("+ C=" + c + " Count=" );			
			if ( map.containsKey(c) ) {
				System.out.println("+ Unique: " + unique + " : 2nd occurrence... +++ \n" );

				subStrings.add(unique);				
				longestSubStr = findMax(longestSubStr, unique); // call the method to declare the longest-substr

				unique = Character.toString(c);
				map.clear();
				map.put(c, 1);
				
				//System.out.println("+ Unique - Post reset(): "  + unique);
			
			} else {
				//System.out.println("+ 1st occurrence \n Building string: \"" + unique + "\" with \"" + c + "\"\n");
				unique += c;
				map.put(c, 1);
				
		        // In case the longest substring is at end
				if ( c == str.charAt(str.length()-1)) {
					System.out.println("+ UNIQUE: " + unique);
					subStrings.add(unique);					
					longestSubStr = findMax(longestSubStr, unique);	// call the method to declare the longest-substr
					
				} // if ()
			
			} // if-else()
			
		} // for()
		
		System.out.println("\n+ Sub Strings: " + subStrings.toString());
		System.out.println("+ Longest: " + longestSubStr);
		
	} // findLongestSubStr()
	
	public static String findMax (String str1, String str2) {
		
		if ( str1.length() > str2.length() ) {
			return str1;
			
		} else if (str1.length() == str2.length() ){
			return str1;
			
		} else {
			return str2;
			
		}

	} // findMax()

	
} // class LongestSubString90

