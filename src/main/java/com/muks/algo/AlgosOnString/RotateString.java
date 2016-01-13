package com.muks.algo.AlgosOnString;



public class RotateString {

	public static void main(String[] args) {
		String str = "abcdef";

		System.out.println("+++ String lenght: " + str.length()); 
//		rotateString(str, 3);	//	rotate string about pivotal element

//		String s1 = "waterbottle";
//		String s2 = "terbottlewa";		// Eg # 1
//		//String s2 = "muks";		// Eg # 1
//		//String s2 = "waterbottle";			// Eg # 2
//
//		System.out.println("+++ Is a rotation of: " + isRotation(s1, s2) );
		
		System.out.println("+++ Rotated using string builder: " + rotateStringOptimum(str, 3));

	}

	// ##########################################################################################
	/* Solution: 
	 * First make sure s1 and s2 are of the same length. 
	 * Then check to see if s2 is a substring of s1 concatenated with s1: */
		
	//System.out.println((s1+s1).indexOf(s2));	// this gives the index at which the substring starts
	
	// Question: is a string circular rotation of another?
	public static boolean isRotation(String s1, String s2) {
		System.out.println("+++ indexOf: s1: " + s1 + s1 + " " + s2 + " " + (s1+s1).indexOf(s2));
		return (s1.length() == s2.length()) && ((s1+s1).indexOf(s2) != -1);
		
	} 	// end isRotation()

	// ########################################################################################################
	public static void rotateString (String str, int pivot) {
		char[] outstring = str.toCharArray();
		int len = outstring.length;

		for (int i = 0; i < pivot; i++) {

			char ch = outstring[0];		// pop out the elements/chars one by one
			for (int j = 0; j < len - 1; j++) {
				outstring[j] = outstring[j + 1];	//  Slide the rest of the string over by one position.
			}
			outstring[len - 1] = ch;		// adding the pop'd element at the end.

			System.out.println("+++ after the poped and push activity: ");
			for (int k = 0; k < outstring.length; k++) {
				System.out.print(outstring[k]);
			}
			System.out.println();

		}

	} // rotateString()


	// ################################################################################################
	// Using StringBuilder with O(n) time complexity
	public static String rotateStringOptimum (String str, int r) {
		
		for (int i = 0; i < r; i++) {
			
			char popd = str.charAt(0);
			str = str + popd;
			str = str.substring(1, str.length());
					
		}
		
		return str;
	}
	
	
	// ##########################################################################################
	// revert back the rotated string
	public static void revertBack (String str) {
		char[] outstring = str.toCharArray();
		int len = outstring.length;
		
		for (int i = 0; i < len; i++) {
			char ch = outstring[len - 1];
			
			for (int j = len - 1; j > 0; j--) {
				outstring[j] = outstring[j - 1];
			}
			outstring[0] = ch;
			
			{
				for (int k = 0; k < outstring.length; k++)
					System.out.print(outstring[k]);
				System.out.println();
			}
		}
	}



} // end class
// ##################################################################################################
