package com.muks.Algorithm.AlgosOnArrays.Basics;

public class KthSmallestElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = {2,3,4,5,6,7,9};
		kthSmallest(arr, 2);
		
		kthLargest(arr, 1);
	}


	public static void kthSmallest(int[] arr, int k) {
		int c=1;

		for(int i=1; i < arr.length; i++) {
			if(c == k) {
				System.out.println("kth Smallest with k=" + k + " is " + arr[i-1]);
				break;
			}

			if(arr[i] != arr[i-1]) {
				c++;
			}
		}
	}
	
	
	public static void kthLargest(int[] arr, int k) {
		int c=1;

		for(int i = arr.length-1; i > 0; i--) {
			if(c == k) {
				System.out.println("kth Smallest with k=" + k + " is " + arr[i]);
				break;
			}
			
			if(arr[i] != arr[i-1]) {
				c++;
			}
		}

	}

}
