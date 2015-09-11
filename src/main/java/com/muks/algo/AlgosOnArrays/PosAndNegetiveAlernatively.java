package com.muks.algo.AlgosOnArrays;

/*Segregate pos and negetive in such a way that we get one pos and next neg alertnatively. 
 */

public class PosAndNegetiveAlernatively {

	public static void main(String[] args) {
		int[] arr = {-1, 2, -3, 4, 5, 6, -7, 8, 9};	

		reArrangePosAndNegs(arr, arr.length-1);
		printArray(arr);

	}


	// ################################################################################################
	// The main function that rearranges elements of given array.  It puts 
	// positive elements at even indexes (0, 2, ..) and negative numbers at 
	// odd indexes (1, 3, ..).
	static void reArrangePosAndNegs(int arr[], int n) {

		int i=0, j=n;
		while (i < j) {

			while (arr[i] < 0) {
				i++;
			}

			while (arr[j] > 0) {
				j--;
			}

			if (i < j) {
				swap(arr, i, j);
			}

		} // end while()		
		printArray(arr);

		int neg = 0, pos = i;
		while (pos < n && neg < pos && arr[neg] < 0) {
			System.out.println(arr[neg] + " swap " + arr[pos]);
			swap(arr, neg, pos);
			pos++;
			neg += 2;
		}

	} 	// reArrangePosAndNegs()


	// ############################################################################################################
	// Swap elements:
	public static void swap (int[] a, int i, int j) {
		a[i] = a[i] ^ a[j];
		a[j] = a[j] ^ a[i];
		a[i] = a[i] ^ a[j];
	}

	static void printArray(int[] arr) {
		String s = "";
		for (int x: arr) {
			s += x + " ";
		}
		System.out.println("++ s: " + s);
	}

}	// end class()
