package com.muks.algo.AlgosOnString;

public class IsStringSubstringOfAnother {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str1 = "hello world";
		String str2 = "lo";

		if (str1.length() > str2.length()) {
			isSubstring(str1, str2);	// call the method to check for sub-string
		} else {
			isSubstring(str2, str1);	// call the method to check for sub-string
		}

	}

	public static void isSubstring(String s1, String s2) {
		int index = 0;

		for (int i = 0; i < s1.length(); i++) {

			if ( index < s2.length() ) {

				if ( s1.charAt(i) == s2.charAt(index) ) {
					index++;
				}

			}

		}	// for()


		if (index == s2.length()) {
			System.out.println("Is Substring");
		} else {
			System.out.println("Is not Substring");
		}


	}	// isSubstring()


}	// end class

