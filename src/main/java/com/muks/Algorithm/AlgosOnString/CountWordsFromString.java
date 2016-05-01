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
	    String state = "OUT";
	    int wc = 0;  // word count
	 
	    // Scan all characters one by one
	    for (int i = 0; i < str.length-1; i++) {	        

	        if (str[i] == ' ' || str[i] == '\n' || str[i] == '\t') {	    	// If next character is a separator, set the state as OUT
	            state = "OUT";

	        } else if (state == "OUT") {	         // If next character is not a word separator and state is OUT,
	            state = "IN";	// then set the state as IN and incrementAndGet word count
	            wc++;
	        
	        }
	        
	    }
	    
	    System.out.println("+++ wc : " + wc );
	    return wc;
	}

}
