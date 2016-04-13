package com.muks.Algorithm.AlgosOnArrays.Basics;

public class MergeIntArrays {
	
	public static void main(String[] args) {
		int[] a = {1, 2, 4};
		int[] b = {3, 5};

		int[] mArray = merge(a, b);
//		int[] mArray = merge2(a, b);
		
		String s = "";
		for (int i : mArray) { 
			s += i + " ";
		}
		System.out.println("\n+++ Merged array: " + s);

	} // end main()
	
	
	// ##############################################################################################################
	public static int[] merge(int[] a, int[] b) {
		
	    int[] result = new int[a.length + b.length];
	    int i = 0, j = 0, k = 0;

	    while (i < a.length && j < b.length) {

	        if (a[i] < b[j]) {
	            result[k++] = a[i++];	// this is works on postfix/operator precedence: It first assign and then increments k & i

	        } else {        
	            result[k++] = b[j++];	// this is works on postfix/operator precedence: It first assign and then increments k & i
	            
	        } // if-else
	        
	    } // while()
	    

	    while (j < b.length) {
	    	result[k++] = b[j++];		// this is works on postfix/operator precedence: It first assign and then increments k & i
	    }

	    return result;
	    
	} // merge()
	
	
	// ##############################################################################################################
	public static int[] merge2 (int[] array1, int[] array2) {
			  	int[] array1and2 = new int[array1.length + array2.length];
		  	int currentPosition = 0;
		
				for( int i = 0; i < array1.length; i++) {
				    array1and2[currentPosition] = array1[i];
		    		currentPosition++;
				}
		
				for( int j = 0; j < array2.length; j++) {
		    		array1and2[currentPosition] = array2[j];
		    		currentPosition++;
				}
				return array1and2;
	}



	
	
} // end class
