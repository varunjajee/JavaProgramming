package com.muks.algo.AlgosOnArrays;

public class SegregateEvenAndOdd {

	public static void main(String[] args) {
		
		int[] arr = {12, 34, 45, 9, 8, 90, 3};
		segregate(arr);
		
		String str = "";
		for (int i : arr) {
			
			str += i + " ";
		}
		
		System.out.println("+++ Final array: " + str);

	}
	
	
	// ######################################################################################################
	// Method to segregate odd nos towards left and even towards right
	public static int[] segregate (int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		
		while (left < right) {
			
			/* Increment left index while we see 0 at left */
		     while ( (arr[left] % 2 != 0) && (left < right) ) {
		    	 left++;
		     }
		        
		     /* Decrement right index while we see 1 at right */
		     while ( (arr[right]%2 == 0) && (left < right) ) {
		        right--;
		     }
		     
		     if(left < right) {
		       swap(arr, left, right); 	/* Swap arr[left] and arr[right]*/
		       left++;
		       right--;
		     }
		}
		
		return arr;
		
	} // end segregate()
	
	
	// ######################################################################################################
	// swap util
	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
		
	} // end swap()

	
} // end class SegregateEvenAndOdd.javapack
