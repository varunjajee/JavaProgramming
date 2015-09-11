package com.muks.algo.AlgosOnArrays;

public class SortPartiallySortedArray {

	/**
	 * In place sorting of a partially sorted array
	 */
	public static void main(String[] args) {
		//int[] arr = {1, 4, 5, 7, 8, 9, 2, 3, 6, 10, 11};
		int[] arr = {7, 8, 9, 10, 11, 1, 2, 3, 4, 5, 6, };
		sort(arr);
		
		String s = "";
		for (int i : arr) {
			s += i + " ";
		}
		System.out.println(s);
	}
	
	
	public static void sort(int[] a) {
		int left = 0;
		int right = a.length - 1;

		// find beginning of second sub-array
		while(right != left && a[right] > a[right-1]) {
			System.out.println("right: " + right + " left: " + left + " : " + a[right] + " - " + a[right-1]);
			right--;
		}

		while(right != a.length && left != a.length) {
			if (a[left] < a[right]) {
				left++;
			} else {
				System.out.println(a[left] + " < " + a[right]);
				swap(a, left, right);
				right++;
			}
		}
		return;

	}

	public static void swap(int[] a, int l, int r) {
		int tmp = a[l];
		a[l] = a[r];
		a[r] = tmp;
	}


}
