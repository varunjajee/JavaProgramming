package com.muks.algo.AlgosOnArrays;

public class Segregate0sAnd1s {

	public static void main(String[] args) {
		int[] arr = {0, 1, 0, 1, 0, 0, 1};
		//segregate0and1(arr);

		sortZeroOne(arr);

		StringBuilder s = new StringBuilder();
		for (int x: arr) {
			s.append(" " + x);
		}

		System.out.println(s);

	}


	// ############################################################################################################
	// in place segration of 0s and 1s: 
	// segregate using modification of name
	
	public static void sortZeroOne(int[] a) {
		if (a == null || a.length==1) {
			return;
		}

		int i=0;
		int j=a.length-1;
		while (i<j) {
			while (a[i]==0) {
				i++;
			}
			
			while (a[j]==1) {
				j--;
			}
			
			if (i < j) {	// rather than swapping, just reassign
				a[i]=0; 
				a[j]=1; 
				i++; 
				j--;
			}
		}

		return;

	}


	// ############################################################################################################
	// in place segration of 0s and 1s: 
	// segregate using swap
	public static void segregate0and1 (int[] arr) {
		int i = 0; 
		int j = arr.length-1;

		while (i < j) {
			while (arr[i] == 0 && i < j) {
				i++;
			}

			while (arr[j] == 1 && i < j) {
				j--;
			}

			if (i < j) {
				swap(arr, i, j);
			}

		}

	} // segregate0and1()

	
	// #################################################################################
	// swap elements of array
	public static void swap (int[] a, int i, int j) {
		a[i] = a[i] ^ a[j];
		a[j] = a[j] ^ a[i];
		a[i] = a[i] ^ a[j];
	}
	
	
}	// end class()
