package AlgosOnString;

public class LongestPalindromeOptimum {

	/**
	 * Time complexity o(n2) and space: 0(1)
	 * -------------------------------------
	 * While, if we move from middle towards ends, we only need to iterate through the list and expand from each character. 
	 * That gives us O(n^2) total running time and only O(1) space.
	 */
	
	public static void main(String[] args) {
	
		String str = "woddooddaqowwoqad";
		System.out.println(longestPalindrome(str));
		
		String s = "mukthar";
		System.out.println("+++ Sub-String: " + s.substring(1, s.length()) );

	}


	// ########################################################################################################################
	/* Check if its palindrome or not
	 * 
	 * Explaination: findPalindrome()
	 * This method works based on the logic of expanding from the center of a palindromic string
	 */
	
	public static String findPalindrome(String str, int left, int right) {  
		
		while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
			System.out.println("+ left: " + left + " " + str.charAt(left) + " == " + " right: " + right + " " + str.charAt(right));
			left--; right++;  
		}  
		
		return str.substring(left+1, right);		
		
	}  // findPalindrome()

	
	// ########################################################################################################################
	// Traverse for the longest palindromic string
	public static String longestPalindrome(String str) {  
		String longest = "";  
		
		for (int i=0; i < str.length(); i++) {  
			String palindrome = findPalindrome(str, i, i);  
		
			if (palindrome.length() > longest.length()) {  
				longest = palindrome;
			}
			
		}  // for
		
		for (int i=1; i < str.length(); i++) {  
			String palindrome = findPalindrome(str, i-1, i);
			System.out.println("+++" + palindrome);
			if (palindrome.length() > longest.length()) {  
				longest = palindrome;
			}  
		
		}  
		
		return longest;
		
	}  // longestPalindrome()

	
} // end class
