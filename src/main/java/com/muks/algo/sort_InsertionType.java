package com.muks.algo;

public class sort_InsertionType {

	/**
	 * @param args
	 * 
	 * Note: Comment out all the sysout statments for a better readability
	 * 
	 */

	// TODO: Read quick sort, heap sort, merge sort

	public static void main(String[] args) {

		System.out.println("+++ Insertion sorting technique...");
		int[] array = {6, 8, 9, 7, 2, 5, 1};

		printArray(array);	// print the original array

		// algo
		for (int i=1; i < array.length; i++) {
			int j = i;
			int key = array[i];

			while ( ( j > 0 ) && ( array[j-1] > key) ) {
				//System.out.println("arr[j]: " + array[j] + " + arr[j-1]: " + array[j-1] + " key: " + key);
				array[j] = array[j-1];				
				j--;
				printArray(array);
			} // end while()

			array[j] = key;

		} // end for()

		System.out.println("+++ After sorting...");
		for (int e : array) {
			System.out.println(e);
		}

	} // end main()

	
	// print the original array:
	public static void printArray(int[] arr) {
		String s = "";
		for (int a: arr) {
			s += a + " ";
		}
		System.out.println(s );
	}


} // end class
