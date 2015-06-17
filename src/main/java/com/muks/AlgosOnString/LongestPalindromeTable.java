package AlgosOnString;

import java.util.Arrays;

public class LongestPalindromeTable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String str = "woddooddaqowwoqad";
		System.out.println(longestPalSubstr(str.toCharArray()));

	}
	
	
	// This function prints the longest palindrome substring of str[].
	// It also returns the length of the longest palindrome
	public static char[] longestPalSubstr( char[] str ) {
	    
	    int n = str.length;	// get length of input string
	 
	    // table[i][j] will be false if substring str[i..j] is not palindrome.
	    // Else table[i][j] will be true
	    boolean[][] table = new boolean[n][n];

	 
	    // All substrings of length 1 are palindromes
	    int maxLength = 1;
	    for( int i = 0; i < n; i++ ) {
	        table[i][i] = true;
	    }
	 
	    // check for sub-string of length 2.
	    int start = 0;
	    for( int i = 0; i < n-1; i++ ) {
	        if( str[i] == str[i+1] ) {
	            table[i][i+1] = true;
	            start = i;
	            maxLength = 2;
	        }
	    }
	 
	    // Check for lengths greater than 2. k is length of substring
	    for( int k = 3; k <= n; k++ ) {
	        // Fix the starting index
	        for( int i = 0; i < n - k + 1 ; i++ ) {

	            int j = i + k - 1;		            // Get the ending index of substring from starting index i and length k
	 
	            // checking for sub-string from ith index to jth index iff str[i+1]
	            // to str[j-1] is a palindrome
	            if( table[i+1][j-1] && str[i] == str[j] ) {
	                table[i][j] = true;
	 
	                if( k > maxLength ) {
	                    start = i;
	                    maxLength = k;
	                }
	            }
	        }
	    }
	 
	    System.out.println("Longest palindrome substring is: ");
	    System.out.println( " str: " + str + " start: " + start + " star+maxlen: " + (start + maxLength - 1) );
	    
	    return ( Arrays.copyOfRange(str, start, (start + maxLength) ) );

	}
	
	

}
