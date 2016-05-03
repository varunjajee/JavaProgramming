package com.muks.Algorithm.AlgoBasics;
public class FibonacciByRecursion {

	/**
	 * NOTE:[important, READ this] => Complexity = 2^n
	 * ---------------------------
	 * By definition, the first two numbers in the Fibonacci sequence are 0 and 1, 
	 * and each subsequent number is the sum of the previous two
	 * 
	 * 	T(n) = T(n-1) + T(n-2) = T(n-2) + T(n-3) + T(n-3) + T(n-4) = 
			= T(n-3) + T(n-4) + T(n-4) + T(n-5) + T(n-4) + T(n-5) + T(n-5) + T(n-6) = ...
			in each step you call T twice, thus will provide eventual asymptotic barrier of: T(n) = 2 * 2 * ... * 2 = 2^n
			
			bonus: the best implementation to fibonacci is actually a close formula, using the golden ratio:
			
			Fib(n) = (Phi^n � (�Phi)^(�n))/sqrt(5) [where phi is the golden ratio]
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 6;
		int[] arr = new int[i];
		for (int j=0; j < i; j++) {
			arr[j] = fibonacci(j);
		}

		//System.out.println("\nResult from recursion: " + fibonacci(i));
		for(int x : arr) {
			System.out.println(x);
		}
		
		//System.out.println("\nResults from a formula type calculation: " + fib2(i) );
		
		//System.out.println( MyUtils.arrayToString(genSeriesByIteration(i)) );
		
	}


	/* ==========================================================================================
		Memoization algorithm *

	 */

	// By simple variable swapping
	public static int fib2(int n) {
		int a = 0;
		int b = 1;
		int fib = 0;
		
		for (int i = 1; i < n; i++) {
			fib = a+b;

			a = b;
			b = fib;
			
		}	// for()
		
		return fib;		// return the fibonacci value of a number - n
		
	}
	

	// By recursion, generate the fibonacci series
	public static int fibonacci(int n)  {
		//System.out.println(n);
		if ( (n == 0) || (n == 1) ) { 
			return n;
			
		} else {
			return fibonacci(n-1) + fibonacci(n-2);
			
		}
		
	}


	/** Fibonaci by memoization
	 *	Generating fibonacci series...
 	 */
	public static int[] genSeriesByIteration(int n) {
		System.out.println("*****Fibonacci Series*****");

		int[] series = new int[n];
		series[0] = 0;
		series[1] = 1;


        for(int i = 2; i < n; i++) {
        	series[i] = series[i-1] + series[i-2];

        }

        return series;
	}



}	// end class
