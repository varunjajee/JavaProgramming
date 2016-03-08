package com.muks.algo.AlgosOnString;
import java.util.ArrayList;
import java.util.HashMap;


public class SubStringPalindrome {

	public static void main(String[] args) {
		//System.out.println("+++ Longest Palindrone: " + subStrPalindrome("ababaefabccb") );
		
		System.out.println("+++ Longest Palindrone: " + subStrPalindrome("woddooddaqowwoqad") );
		//System.out.println("+++ " + isPalindrome("bccbmad"));
		
	}

	
	public static String subStrPalindrome (String str) {
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		String longestPalindrome = "";
		String unique = "";
		ArrayList<String> palStore = new ArrayList<String>();

		for (char c : str.toCharArray()) {
			map.put(c, 0);
		}
		

		for (char c : str.toCharArray()) {			
			if (map.get(c) == 2) {
//				System.out.println("+ if() : Palindrome: " + unique);
//				System.out.println("+++ Unique: " + unique + " - "  + isPalindrome(unique) );
				palStore.add(unique);
				
				if (isPalindrome(unique)) {
					System.out.println("+++ Unique: " + unique);
					longestPalindrome = longestSubStr(longestPalindrome, unique);
				}
				System.out.println("+++ PAL: " + longestPalindrome);
				
				unique = Character.toString(c);
				//map.clear();
				map.put(c, 0);
				
			} else {
				unique += c;
				map.put(c, (map.get(c) + 1) );
				
				if (c == str.charAt(str.length()-1)) {
//					System.out.println("+++ Unique: " + unique + " - "  + isPalindrome(unique) );
//					System.out.println("+ else() : Palindrome: " + unique);
					palStore.add(unique);
					
					if (isPalindrome(unique)) {
						System.out.println("+++ Unique: " + unique);
						longestPalindrome = longestSubStr(longestPalindrome, unique);
					}
					System.out.println("+++ PAL: " + longestPalindrome);
				
				} // if() 
				
			} // if-else()
		
		} // for()
		
		System.out.println("+ palStore: " + palStore.toString());
		return longestPalindrome;
	
	} // subStrPalindrome()
	
	
	public static boolean isPalindrome (String str) {
		boolean isPal = false;
		int p1 = str.length() - 1; int p2 = 0;

		while (p1 >= p2) {
			if (str.charAt(p1) == str.charAt(p2)) {
				isPal = true;
				p1--;
				p2++;
				
			} else {
				return isPal = false;
				
			}

		}
		
		return isPal;
		
	} // isPalindrome()
	
	
	public static String longestSubStr (String str1, String str2) {
		
		if (str1.length() > str2.length())
			return str1;
		
		else if (str1.length() == str2.length())
			return str1;
		
		else
			return str2;
		
	} // longestPalindrome()
	
}
