package com.muks.Algorithm.AlgoBasics;



public class FindSecondHighest {

	/**
	 * @param args
	 */

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,10,203,2,244,245,1000,55000,23};	// some int array
		
		System.out.println(findByRecursion(arr, 0, 1, 2));
		//System.out.println(findByArrayScan(arr));

	}

	
	//####################################################################################################################################		
	public static int findByRecursion (int[] arr, int index, int largest, int secondLargest) {
		
	    if (index == arr.length) {
	        return secondLargest;
	    }
	    
	    
	    int element = arr[index];
	    if(element > secondLargest) {
	        if(element > largest) {
	            return findByRecursion(arr, index + 1, element, largest);
	           
	        }
	        else {
	            return findByRecursion(arr, index + 1, largest, element);
	            
	        }
	        
	    }
	    
	    System.out.println("element: " + element + " = arr[index]" + arr[index] + "\n largest: " + largest + " Second: " + secondLargest);
	    return findByRecursion(arr, index + 1, largest, secondLargest);
	    
	}	

	//####################################################################################################################################
	/*
	 * 
	 * There are 3 use cases to be considered, where 
	 * (1) a[i] > the max
	 * (2) a[i] > the second max - if this is not considered, then the second max would be a wrong hit
	 * (3) second == max, then second = a[i], else second max would be wrongly calculated. 
	 * 
	 */
	public static int findByArrayScan(int[] array) {
		System.out.println("+++ Find by array scan +++");
		
		int highest = array[0];  
		int secondHighest = array[0];

		for(int i = 0; i < array.length; i++) {
			if (array[i] > highest) {
				secondHighest = highest;  
				highest = array[i];  

			} else if (array[i] > secondHighest){  
				secondHighest = array[i];
				
			} else if (secondHighest == highest){  
				secondHighest = array[i];
				
			} 
			
		} // end for  

		return secondHighest;  

	} // end method  


} // end of class


//###############################################################################################################################################
