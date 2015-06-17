package com.muks.algo;



public class SortingTechniques {

	/**
	 * @param args
	 */

	// 	COMPLEXITY = ????


	public static void main(String[] args) { // arrays are always call-by reference, so it retains its reference
		int[] arrayToSort = new int[] {9,2,8,5,1,10,0};

		//		System.out.println("Initial Array: " + arrayToString(arrayToSort));
		System.out.println("Sorted array: " + arrayToString(selectionSort(arrayToSort)));
		insertionSort();


		//insertionSort();


	} // end main

	//#########################################################################################################

	// collect the array ref to a string object
	public static String arrayToString(int[] array) {
		String res = "";
		for (int a: array) {
			res += a + " ";
		}
		return res;

	} // end arrayToString()

	//#########################################################################################################	

	/*
	 * "selection sort" is a sorting algorithm, specifically an in-place comparison sort. 
	 * It has O(n2) time complexity, making it inefficient on large lists, 
	 * and generally performs worse than the similar insertion sort. 
	 * 
	 * Selection sort is noted for its simplicity, and it has performance advantages over more complicated 
	 * algorithms in certain situations, particularly where auxiliary memory is limited.
	 * 
	 */

	public static int[] selectionSort(int array[]) {
		System.out.println("+++ Selection/comparision sorting technique... +++");
		//System.out.println("Len: " + array.length);

		for (int i = 0; i < array.length; i++) {
			int key = array[i];
			int sIndex = i;

			for (int j = i + 1; j < array.length; j++ ) {
				System.out.println(" j=" + j + " i=" + i + " key=" + key);
				if ( key > array[j]) {
					key = array[j];
					sIndex = j;

				}

			} // end of for(j)

			// smallest value now is the smallest in j... end()
			array[sIndex] 	= array[i];
			array[i]		= key;

		} // end of for(i)
		return array;

	} // end selectionSort()


	//#########################################################################################################
	/*
	 * "Insertion sort" is a simple sorting algorithm that builds the final sorted array (or list) one item at a time. 
	 * It is much less efficient on large lists than more advanced algorithms such as quicksort, heapsort, or merge sort. 
	 * However, insertion sort provides several advantages:
	 * Simple implementation
	 *    Efficient for (quite) small data sets
	 *    
	 *    Adaptive (i.e., efficient) for data sets that are already substantially sorted: 
	 *    the time complexity is O(n + d), where d is the number of inversions
	 *    More efficient in practice than most other simple quadratic (i.e., O(n2)) algorithms such as selection sort or bubble sort; 
	 *    the best case (nearly sorted input) is O(n)
	 *    
	 *    Stable; i.e., does not change the relative order of elements with equal keys
	 *    
	 *    In-place; i.e., only requires a constant amount O(1) of additional memory space
	 *    
	 *    Online; i.e., can sort a list as it receives it
	 * 
	 */	

	public static void insertionSort () {

		System.out.println("+++ Insertion sorting technique... +++");
		int[] array = {3, 4, 6, 8, 9, 7, 2, 5, 1};
		System.out.println("Initial array: " + arrayToString(array));

		// algo
		for (int i=1; i < array.length; i++) {
			int j = i;
			int key = array[i];

			while ( ( j > 0 ) && ( array[j-1] > key) ) {
				System.out.println("i=" + i + " j=" + j + " j-1=" + (j-1) + " key=" + key + " ARRAY: " + MyUtils.arrayToString(array));
				array[j] = array[j-1];				
				j--;

			} // end while()

			array[j] = key;

		} // end for()

		System.out.println("After sorting: " + arrayToString(array));

	} // end insertionSort()


	/* ################################################################################################################
	 * In merge sort split the array values in halves recursively until each half has only single  element. 
	 * Merge the two 1/2 values together and sort the values. 
	 * Do same steps iteratively until the values are not sorted. 
	 */
	
	public static void mergeSort_srt(int[] arr, int lo, int n){
		int low = lo;
		int high = n;
		
		if (low >= high) {
			return;
		}

		int middle = (low + high) / 2;
		mergeSort_srt(arr, low, middle);
		mergeSort_srt(arr, middle + 1, high);

		int end_low = middle;
		int start_high = middle + 1;

		while ((lo <= end_low) && (start_high <= high)) {
			if (arr[low] < arr[start_high]) {
				low++;

			} else {
				int Temp = arr[start_high];

				for (int k = start_high- 1; k >= low; k--) {
					arr[k+1] = arr[k];
				}

				arr[low] = Temp;
				low++;
				end_low++;
				start_high++;

			}
		}
	}  

} // end of class

//###################################################################################################################################
