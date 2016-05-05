package com.muks.Algorithm.AlgosOnString;

public class StringSegregateOrTranspose {

	/**
	 * Complexity: O(n) using cycle leader algorithm
	 * http://www.geeksforgeeks.org/an-in-place-algorithm-for-string-transformation/
	 * 
	 */
	
	public static void main(String[] args) {
		//String s = "a1b2c3d4e5f6g7";
		String s = "a1b2c3d";
		char[] arr = s.toCharArray();
		transpose(arr);

		System.out.println("Final String: " + new String(arr));
	}
	
	public static void transpose (char[] str) {
		
		int length = str.length;
		int i = 1;
		int j;
		char temp;
		
		while(i <= length/2 ) {
			temp = str[i];
			j = i;
			
			while(j < length-1) {
				str[j] = str[j+1];
				j++;
			}
			
			str[j] = temp;
			i++;
		}
	}

	public static void printArray (char[] arr) {
		String s = "";
		for (char c: arr) {
			s += c;
		}
		System.out.println(s);
	}
	
	// ##########################################################################################################
	/* Complexity: O(n)
	 * But space complexity is higher than o(n) since string is b_immutable, and we are working with
	 * string append operations where in for each append, jvm creates a instance of a string in memory 
	 */
	
	public static String splitEvenOdd(String str) {
        int n = str.length()-1;
        int flag=0;
         
        for(int i=0; i <= n/2; i++) {
             
            if ( (i+1) % 2 == 0 && flag == 0) {
                str = str + str.charAt(i);
                str = str.substring(0, i) + str.substring(i+1, str.length());
                
                n = n-1;	// keep reducing n or in for-lops; having (i <= n/2)
                flag=1;
            }
            
            else if ( i % 2 == 0 && flag == 1 ) {
            	System.out.println(" i: " + i);
                str = str + str.charAt(i);
                str = str.substring(0, i) + str.substring(i+1, str.length());
                n = n-1;
                flag = 0;
            }
            System.out.println(str);
             
        }
        return str;
    }

}
