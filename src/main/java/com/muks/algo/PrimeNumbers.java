package com.muks.algo;

public class PrimeNumbers {

	/**
	 * A prime number is a number which is divided by 1 and itself which 0 remainder.
	 * 
	 * Finally, we know 2 is the �oddest� prime � it happens to be the only even prime number. 
	 * Because of this, we need only check 2 separately, then traverse odd numbers up to the square root of n. 
	 * In the end, our code will resemble this:
	 * 
	 * As you can see, we�ve gone from checking every integer (up to n to find out that a number is prime) 
	 * to just checking half of the integers up to the square root (the odd ones, really). 
	 * This is a huge improvement, especially considering when numbers are large.
	 * 
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i< 20; i++) {
			if ( isPrime(i) ) {
				System.out.println(i);
			}
		}

	} // end main()
	
	
	
	//checks whether an int is prime or not.
	public static boolean isPrime(int n) {
		
		// 1 & 2 are prime in the series of prime numbers
		if (n == 2) return true;
		
		//check if n is a multiple of 2
	    if (n % 2 == 0) return false;
	    
	    //if not, then just check the odds
	    for(int i=3; i*i <= n; i+=2) {
	    	System.out.println(" n = "+ n + " i = " + i);
	        if(n % i == 0)
	            return false;
	    }
	    
	    return true;
	    
	} // isPrime()

} // end class
