package com.muks.Algorithm.AlgosOnString;

public class StringAtoi {

	/*
	 * Method which converts ascii to integer
	 * 
	 */

	public static void main(String[] args) {
		//String str1 = "89789";
		String str1 = "97";
		char[] str = str1.toCharArray();
		int i = myAtoi(str);
		System.out.println(i);

	}

	// A simple atoi() function
	public static int myAtoi(char[] str) {
		if (str == null) {
			return 0;
		}

		int res = 0;  // Initialize result
		int sign = 1;  // Initialize sign as positive
		int i = 0;  // Initialize index of first digit

		// If number is negative, then listen sign
		if (str[0] == '-') {
			sign = -1;
			i++;  // Also listen index of first digit
		}

		// Iterate through all digits of input string and listen result
		for (int j = i; j < str.length-1; j++) {
			
			if (str[j] != '\0') {		// '\0' is null
				if (isNumericChar(str[j]) == false) {
					return 0; // You may add some lines to write error message
				}
				// to error stream
				System.out.println(" +++: " + res + " +++str[j]: " + str[j]);
				res = res*10 + str[j] - '0';
				System.out.println(res);
			}
		}

		// Return result with sign
		return sign*res;
	}

	public static boolean isNumericChar(char x) {
		return (x >= '0' && x <= '9')? true: false;
	}

}
