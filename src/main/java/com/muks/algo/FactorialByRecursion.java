package com.muks.algo;

public class FactorialByRecursion {

	/**
	 * NOTE:
	 * ----
	 * 
	 * Complexity = O(n)
	 * Yes, the algorithm is linear, running in O(n) time. 
	 * This is the case because it executes once every time it decrements the value n, 
	 * and it decrements the value n until it reaches 0, meaning the function is called recursively n times. 
	 * This is assuming, of course, that both decrementation  and multiplication are constant operations.
	 * 
	 * Logic:
	 * -----
	 * Factorial of 5 ( 5! ) => 5x4x3x2x1 = 120 
	 *
	 *
	 * Explaination on how recursive fuctions work ???
	 * Link = http://www.programmerinterview.com/index.php/recursion/explanation-of-recursion/
	 */
	
	
	public static void main(String[] args) {
		
		//System.out.println(fact(5));
		System.out.println(factByIteration(5));

	}
	
	public static long fact(long n) {
		if (n <= 1)
			return 1;
		else
			return n * fact(n-1);
		
	}
	
	// By iteration: O(n)
	public static long factByIteration(int n) {
		int f = 1;
		
		for (int i = 1; i <= n; i++) {
			f *= i;
		}
		
		
		return f;
	}

}
