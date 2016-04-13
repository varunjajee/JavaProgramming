package com.muks.Algorithm.AlgosOnArrays.Basics;

import java.util.HashMap;

public class RemoveDuplicateChars {

	public static void main(String[] args) {
		String s = "ababdeceaf";
		removeDuplicates(s);
		System.out.println("+++ " + s.toString());
	}


	public static void removeDuplicates(String s) {

		char[] str = s.toCharArray();
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();

		if ( (str == null) || (str.length < 2) ) return;

		for (char c: str) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c)+1);
			} else {
				map.put(c, 1);
			}
		}
		
		String r = "";
		for (int i=0; i < str.length; i++) {
			if (map.get(str[i]) == 1) {
				r += str[i];
				
			} 
			
		}
		
		System.out.println("+ Final NonRepeated: " + r);


	}
	
	


}
