package com.muks.Algorithm.AlgosOnArrays;

public class NextBigPalindromeNum {

	/**
	 * http://www.geeksforgeeks.org/given-a-number-find-next-smallest-palindrome-larger-than-this-number/
	 */
	public static void main(String[] args) {
		//int[] input = {1,2,3,4,5, 6};
		//int[] input = {1,2,3,4};
		//int[] input = {9,9,9};
		//int[] input = {2, 3, 5, 4, 5};
		
		int[] input = {1, 2, 9, 2, 1}; // case-1
		//int[] input = {1, 2, 8, 2, 1}; // case-1.1 => no propogation
		generateNextPalindrome(input, input.length);

	}
	
	
	// The function that prints next palindrome of a given number num[] with n digits.
	public static void generateNextPalindrome( int num[], int n ) {
		
		int i;
	    
		// Input type 1: All the digits are 9, simply o/p 1, followed by n-1 0's followed by 1.
		String str = "";
	    if( AreAll9s(num, n) ) {
	        str = "1";
	        for( i = 1; i < n; i++ ) {
	        	str += "0";
	        }	        
	        str += "1";
	    }
	    
	 
	    // Input type 2 and 3
	    else {
			genNextPalNum(num, num.length);
		    System.out.println("\nNext Biggest Palindrome: " + str);
		    printArray(num);			
	    }

	}


	public static void genNextPalNum (int[] num, int n) {
		System.out.println("+++ Original input: " );
		printArray(num);

		boolean leftsmaller = false;		// to check if copy of left side to right is sufficient or not
		int mid = n/2;						// find the index of mid digit
		int i = mid - 1;					// end of left side is always 'mid -1'
		System.out.println(" mid: " + mid);
		
		// Begining of right side depends if n is odd or even
		/* " i & j " pointing to the two middle elements i=2; j=3, if => {1,2,3,4,5,6} and i=2; j=3, if =>{1,2,3,4,5}
		 * or pointing to two elements around the middle element in case of n being odd
		 */
		int j = (n % 2 != 0) ? (mid + 1) : mid;
		System.out.println("+ i: " + i + " & j: " + j + " mid: " + mid);

		// Initially, ignore the middle same digits 
		while (i >= 0 && num[i] == num[j]) {
			i--;
			j++;
		}


		/* 	Find if the middle digit(s) need to be incremented or not (or copying left 
	    	side is not sufficient) */ 
		if ( i < 0 || num[i] < num[j]) {
			leftsmaller = true;
		}
		System.out.println("\n+ leftsmaller: " + leftsmaller);

		// Copy the mirror of left to right
		while (i >= 0) {
			num[j] = num[i];
			i--;
			j++;
		} // end mirroring

		/*	Handle the case where middle digit(s) must be incremented. 
		 * 	Case-1: where the input is palindrome number
		 * 	Case-2: where mirroring the left to right is sufficient. copying from left to right makes a next big palindrome
		 * 
		 */
		if (leftsmaller == true) {
			int carry = 1;
			i = mid - 1;

			// If there are odd digits, then incrementAndGet
			// the middle digit and store the carry
			if (n%2 != 0) {
				System.out.println(" +++++ num[mid]: " + num[mid]);
				num[mid] += carry;
				System.out.println("+++ Increased mid: " + num[mid] + " => by 1 ");
				
				carry = num[mid] / 10;
				System.out.println("+++ Carry: " + carry);
				num[mid] %= 10;
				System.out.println("num[mid]: " + num[mid]);
				j = mid + 1;
			
			} else {
				j = mid;

			}
			
			
			
	        // Add 1 to the rightmost digit of the left side, propagate the carry 
	        // towards MSB digit and simultaneously copying mirror of the left side 
	        // to the right side.
			printArray(num);
			
			System.out.println("\n++ Initial Value of Carry: " + carry);
	        while (i >= 0) {
	            num[i] += carry;
	            
	            carry = num[i] / 10;
	            System.out.println("+ num[i]: " + num[i] + " => i: " + i + " => CARRY: " + carry);
	            
	            num[i] %= 10;
	            System.out.println("+++ num[i]: " + num[i] + " i: " + i + " j: " + j);
	            num[j++] = num[i--]; // copy mirror to right
	            
	        } // while()
	        
	        
		} //end if()
		
		return ;

	} // end genNextPalNum()

	
	
	// A utility function to check if num has all 9s
	static boolean AreAll9s( int[] num, int n )
	{
	    int i;
	    for( i = 0; i < n; ++i )
	        if( num[i] != 9 )
	            return false;
	    return true;
	}
	
	static void printArray(int[] num) {
		String str = "";
		for (int x : num) {
			str += x + " ";
		}
		System.out.println(str + "\n");
	}

} // end class
