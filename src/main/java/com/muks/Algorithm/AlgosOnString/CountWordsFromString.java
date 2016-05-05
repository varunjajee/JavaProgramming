package com.muks.Algorithm.AlgosOnString;

public class CountWordsFromString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//String s = "this is me here!!!";
		String s = "me me";
		System.out.println("+++ total word count: " +countWords(s.toCharArray()) );
	}
	
	// returns number of words in str
	public static int countWords(char[] str) {
	    boolean isWord = true;
	    int wc = 0;  // word count
	 
	    // Scan all characters one by one
	    for (int i = 0; i < str.length-1; i++) {	        

	        if (str[i] == ' ' || str[i] == '\n' || str[i] == '\t') {	    	// If next character is a separator, set the isWord as OUT
	            isWord = true;

	        } else if (isWord) {	         // If next character is not a word separator and isWord is OUT,
	            isWord = false;	// then set the isWord as IN and incrementAndGet word count
	            wc++;
	        
	        }
	        
	    }
	    
	    System.out.println("+++ wc : " + wc );
	    return wc;
	}

}
