package com.muks.algo;

public class ReverseString {

	public static void main(String[] args) {
		//System.out.println("+++ " + rev("this is me") );
		
		//System.out.println("+++ " + reverseByMid("this is me") );
		System.out.println("+ Reversed by recursion: " + reverseByRecursion("this is me") );
		
	}

	
	// ###################################################################################################
	// Reverse by using mid elements o(n log n)
	public static String reverseByMid(String orig) {
		char[] s = orig.toCharArray();

		int n = s.length; 	// array length always returns 1-n rather 0-n
		System.out.println("Lenght - n : " + n);
		int halfLength = n / 2;
		
		for (int i=0; i < halfLength; i++) {
			char temp = s[i];
			s[i] = s[n-1-i];
			s[n-1-i] = temp;
			
		}
		return new String(s);
	}

	
	// ##################################################################################################
	// Method to mirror string:
	public static String reverseByRecursion(String str){
		int length = str.length();
		System.out.println("+++ : " + str);
		
		if (length <= 1){
			return str;
		}

		char c = str.charAt(length-1);
		System.out.println(" C: " + c);
		return c + reverseByRecursion(str.substring(0,length-1));

	} // mirror()

	
	// ##################################################################################################
	public static String rev(String orig) {
		char[] str = orig.toCharArray();
		int p1 = 0;
		int p2 = str.length - 1;

		//for (int i=0; i < str.length(); i++) {
		
			while ( p1 <= p2 ) {
				System.out.println(" p1 != p2 " +  p1 + " " + p2 );
				char temp = str[p1];
				str[p1] = str[p2];
				str[p2] = temp;
				p1++;
				p2--;
				System.out.println(" p1 != p2 " +  str[p1] + " " + str[p2] );
				
			}
		//}
			return new String(str);
	}
}
