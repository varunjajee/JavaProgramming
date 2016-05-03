package com.muks.Algorithm.AlgosOnString;

public class ReverseWordByWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "first second third";
		
		
		String reversed1 = reverseWordByWord(s);
		System.out.println("+++ Reversed: " + reversed1);
//
//        System.out.println(reverseCharsWithinWords(s) );
	}

	
	// ####################################################################################################
	// reverse a string, along with individual strings being reversed.
	
	// output: +++ Reversed-2: tsrif dnoces driht
	
	public static String reverseCharsWithinWords(String str) {
		
        StringBuilder sb = new StringBuilder();
        int insertIndex = 0;
        
        for(int i = 0; i < str.length(); i++ ) {
        	 
            if(str.charAt(i) != ' ') {
                sb.insert(insertIndex, str.charAt(i));
                
            }  else {
                insertIndex = i+1;
                sb.append(str.charAt(i));

            }
            System.out.println(sb.toString());
        }

        return sb.toString();
    }
	
	
	// ####################################################################################################
	// reverse a string, along with individual strings being reversed.
	
	// output: +++ Reversed: third second first
	
	public static String reverseWordByWord(String str) {
        StringBuilder returnValue = new StringBuilder();
        int insertIndex = 0;
        
        for(int i = 0; i < str.length(); i++ ) {
        	
            if(str.charAt(i) != ' ') {
            	returnValue.insert(insertIndex, str.charAt(i));
                insertIndex++;

            }  else {
            	insertIndex = 0;
            	returnValue.insert(insertIndex, str.charAt(i));
            }
        }

        return returnValue.toString();
    }
	
	
}	// class()
