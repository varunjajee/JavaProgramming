package com.muks.algo;



public class SortingTechniques {

	/**
	 * @param args
	 */

	// 	COMPLEXITY = ????


	public static void main(String[] args) { // arrays are always call-by reference, so it retains its reference
		int[] arrayToSort = new int[] {9,2,8,5,1,10,0};

		//		System.out.println("Initial Array: " + arrayToString(arrayToSort));
		System.out.println("Sorted array: " + arrayToString(SelectionSort(arrayToSort)));
		//InsertionSort();


		//InsertionSort();


	} // end main




	// ===========================================================================================
	/*
	 * "selection sort" is a sorting algorithm, specifically an in-place comparison sort. 
	 * It has O(n2) time complexity, making it inefficient on large lists, 
	 * and generally performs worse than the similar insertion sort. 
	 * 
	 * Selection sort is noted for its simplicity, and it has performance advantages over more complicated 
	 * algorithms in certain situations, particularly where auxiliary memory is limited.
	 * 
	 */

	public static int[] SelectionSort(int array[]) {
		System.out.println("+++ Selection/comparision sorting technique... +++");


		for (int i = 0; i < array.length; i++) {
			int key = array[i];
			int sIndex = i;

            // {9, 2, 8, 5, 1, 10, 0};
			for (int j = i + 1; j < array.length; j++ ) {
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

	} // end SelectionSort()


	//===========================================================================================
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

	public static void InsertionSort() {

		System.out.println("+++ Insertion sorting technique... +++");
		int[] array = {3, 4, 6, 8, 9, 7, 2, 5, 1};
		System.out.println("Initial array: " + arrayToString(array));

		// algo
		for (int i=1; i < array.length; i++) {
			int j = i;
			int key = array[i];

			while ( j > 0 && array[j-1] > key ) {
				System.out.println("i=" + i + " j=" + j + " j-1=" + (j-1) + " key=" + key + " ARRAY: " + MyUtils.arrayToString(array));
				array[j] = array[j-1];				
				j--;

			} // end while()

			array[j] = key;

		} // end for()

		System.out.println("After sorting: " + arrayToString(array));

	} // end InsertionSort()


	public static void InsertionSort2(int[] array) {
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
	}


	/* 	=========================================================================================
	 *  In merge sort split the array values in halves recursively until each half has only
	 *  single  element.
	 *  Merge the two 1/2 values together and sort the values.
	 *  Do same steps iteratively until the values are not sorted.
	 */
	public static void MergeSort(int[] arr, int lo, int n){
		int low = lo;
		int high = n;
		
		if (low >= high) {
			return;
		}

		int middle = (low + high) / 2;
		MergeSort(arr, low, middle);
		MergeSort(arr, middle + 1, high);

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


	/* 	=========================================================================================
		Quick Sort - Divide & Conquer
	 */
	public static int[] sortedIntArray(int[] arr) {
		quickSort(arr, 0, arr.length-1);
		return arr;
	}


	// Quick Sort Method
	public static void quickSort(int[] arr, int start, int end) {
		if (start < end) {
			int mid = partition(arr, start, end);
			quickSort(arr, start, mid);
			quickSort(arr, mid+1, end);
		}
	}

	// 23,44,1,2009,2,88,123,7,999,1040,88

	// Partition method
	public static int partition(int[] arr, int start, int end) {
		int xPivotElem = arr[start];
		int i = start - 1;
		int j = end + 1;

		while (true) {
			i++;
			while (arr[i] < xPivotElem) {
				i++;
			}


			j--;
			while (arr[j] > xPivotElem) {
				j--;
			}


			if (i < j) {
				System.out.println("+ " + arr[i] + " - " + arr[j]);
				swap(arr, i, j);
			} else {
				return j;
			}
		}
	}


	// swap 2 elements
	public static void swap(int[] a, int i, int j) {
		int tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}


	// print the original array:
	public static void printArray(int[] arr) {
		String s = "";
		for (int a: arr) {
			s += a + " ";
		}
		System.out.println(s );
	}


	// ===========================================================================================
	// collect the array ref to a string object
	public static String arrayToString(int[] array) {
		String res = "";
		for (int a: array) {
			res += a + " ";
		}
		return res;

	} // end arrayToString()



} // end of class

