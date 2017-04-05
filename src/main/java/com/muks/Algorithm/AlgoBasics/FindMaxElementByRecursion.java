package com.muks.Algorithm.AlgoBasics;

public class FindMaxElementByRecursion {

	public static void main(String[] args) {

		int[] arr = {1,2,999999, 3,4,5,10,203,2,244,245,1000,55000,2223};	// some int array 

		System.out.println(maxByRecursion(arr, arr.length-1, arr[0]));
		
		//System.out.println(maxByArrayTraverse(arr));

	} // end lib


	// recursive method to find max
	public static int maxByRecursion (int[] arr, int n, int max) {
		
		while ( n >= 0 ) { 	// while is required, else we encounter arrayoutofbound exception coz it moves to (n = -1)

			if (max < arr[n]) {
				System.out.println("From inner statement: " + max + " = " + arr[n]);
				max = arr[n];
				return maxByRecursion(arr, n-1, max);
			
			} else { // else statement is very much required else the code works only on sorted array.
				System.out.println(" --- " + max + " = " + arr[n]);
				return maxByRecursion(arr, n-1, max);
			}
			
		}
		
		return max;
		
	} // end max()
	
	// recursive method to find max
	public static int maxByTraverse (int[] arr) {
		System.out.println("\n+++ Get max number by array traverse... +++");
		
		int i = 0;
		int max = arr[i];
		
		while (i < arr.length) {
			if (max < arr[i]) {
				max = arr[i];
			}
			i++;
			
		}
		
		return max;
		
	} // end max()	
	
} // end class

//####################################################################################################################################
