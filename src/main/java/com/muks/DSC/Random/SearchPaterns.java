package com.muks.DSC.Random;

public class SearchPaterns {
	/*
	 * NOTE: (KMP Algorithm - Knuth-Morrith-Pratt algorithm)
	 * -----
	 * 	A simple search pattern is to run accross n-pattern chars using the search pattern of size m. 
	 * this has a search complexity of mxn, to simplify it, we use further search pattern algorithms
	 * 
	 * 1 fastest algorithm to search for pattern is "Knuth-Morris-Pratt" - algorithm
	 * Observation:
	 * ------------
	 * 		If mismatch occurs, we may NOT need to restart the comparison all way back (from the next input position)
	 * 
	 *  What to do:
	 *  		Constructing an array h, that determines how many characters to shift the pattern to the right in case of 
	 *  		a mismatch during the pattern matching process
	 *  
	 *  	we are going to store the information of how many char to shift, into a array called 'h'
	 *
	 * 
	 * Computing the array h
	 *  h = longest proper prefix of the pattern which is "also a suffix" of the pattern and importantly the next char to be different
	 *  
	 *  KMP algorithm, the time taken to search for a text is proportional to the lenght of the text
	 * 
	 */

}
