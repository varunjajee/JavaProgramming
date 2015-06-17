package com.muks.AlgosOnArrays;

import java.util.ArrayList;
import java.util.List;


/* 	http://www.dsalgo.com/2013/02/back-to-content-array-equal-sum.html
 *	Non-Polynomial. There are Polynomial solutions for NP problems. 
 * this is called knap-sack problem. */

/* Given a set of n integers, divide the set in two subsets of n/2 sizes each 
 * such that the difference of the sum of two subsets is as minimum as possible. 
 * If n is even, then sizes of two subsets must be strictly n/2 and if n is odd, 
 * then size of one subset must be (n-1)/2 and size of other subset must be (n+1)/2.
 * 
 * 
 * The sum of two parts should be equal. 
 * That means sum should be equal to half of total sum. 
 * As they are all integers so if the sum is odd number then it is not possible to partition. 
 * If they are even we will try to find whether that half of sum is possible by adding numbers from the array. 
 * 
 * We solve this by dynamic programming. 
 * We take a two dimensional array L of size count+1, sum/2+1. 
 * Where L[i,j] = maximum sum possible with elements of array 0 to i and sum not exceeding j. 
 * We compute this array from L[0,0] to L[n,sum/2]. So for computing L[i,j] we need to check the element i. 
 * if it is greater than j then it cannot be included in the sum so L[i,j]=L[i-1,j]. 
 * If ith element is less than j, then we should consider two cases and take the greater of them. 
 * First case is where we don't include the element in sum. Then L[i,j] = L[i-1,j] which is exactly like before. 
 * Now if we include the element, then L[i,j]=a[i]+L[i-1,j-a[i]]. In this way we fill this 2-d array. 
 * If L[n,sum/2] is equal to sum/2 that means the array can be partitioned in two parts whose sums are equal. 
 * Then we find out which elements have been included in that sum by backtracking through that 2-d array.
 * 
 * For backtracking through the array we just apply the reverse logic. 
 * If L[i,j] is equal to a[i]+L[i-1,j-a[i]] then that element is included in the partition. 
 * Then we continue this process to L[i-1,j-a[i]). 
 * If it is not equal then the element is not included in the final sum, so we proceed to L[i-1,j] After we get the complete 
 * list of elements in a partition we remove them from the original array to get the second partition. 
 */

public class EqualSumPartitionTugOfWwar {

	public static void main(String[] args) {
		Integer[] valid_array = { 1, 2, 3, 6, 4, 5, 7 };
		Integer[] invalid_array = {3, 4, 5, -3, 100, 1, 89, 54, 23, 20};

		System.out.println("+ Original array: ");
		printArray(valid_array);

		int[] vArray = { 1, 2, 3, 6, 4, 5, 7 };
		boolean found = findPartiion(vArray, vArray.length);

		Integer[][] parts = partition(valid_array);		// calling the partitioner

		if (parts == null) {
			System.out.println("partition not possible");
			return;
		}
		
		System.out.println("partition");
		for (Integer num : parts[0]) {
			System.out.print(num + ", ");
		}

		System.out.println();
		for (Integer num : parts[1]) {
			System.out.print(num + ", ");
		}

	} // main


	// ##############################################################################################################################
	// print the array
	private static Integer[][] partition(Integer[] arr) {
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> part = new ArrayList<Integer>();

		int sum = 0;
		for (Integer num : arr) {
			list.add(num);
			sum += num;
		}

		System.out.println("+++ total sum: " + sum);

		if (sum % 2 == 1) {		// there is no solution to this if the sum is odd. NP-Complete (Non-Polynomial Complete) problem
			return null;
		}

		sum /= 2;		// get half of the sum

		int[][] table = new int[arr.length + 1][sum + 1];

		for (int i = 1; i <= arr.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (arr[i - 1] > j 
						|| 
						( table[i - 1][j] 
								> 
						arr[i - 1] 
								+ 
								table[i - 1][j - arr[i - 1]] ) ) {

					table[i][j] = table[i - 1][j];

				} else {
					table[i][j] = arr[i - 1] + table[i - 1][j - arr[i - 1]];

				}
			}
		}

		if (table[arr.length][sum] != sum) {
			return null;
		}

		int i = arr.length;
		int j = sum;
		while (j > 0 && i > 0) {
			if (arr[i - 1] <= j
					&& table[i][j] == arr[i - 1] + table[i - 1][j - arr[i - 1]]) {
				part.add(arr[i - 1]);
				j = j - arr[i - 1];
			}
			i--;
		}

		for (Integer num : part) {
			list.remove(num);
		}

		Integer[][] result = new Integer[2][];
		result[0] = part.toArray(new Integer[] {});
		result[1] = list.toArray(new Integer[] {});
		return result;
	}


	// ##############################################################################################################################
	// print the array
	public static void printArray(Integer[] arr) {
		String s = "";
		for (int i: arr) {
			s += i + ", ";
		}
		System.out.println("{ " + s + " }");

	}	// printAray()



	/* 
	 * Better Solution:
	 * Requirement: The sum of two parts should be equal. That means sum should be equal to half of total sum.
	 *  
	 * As they are all integers so if the sum is odd number then it is not possible to partition. 
	 * If they are even we will try to find whether that half of sum is possible by adding numbers from the array. 
	 * 
	 * We solve this by dynamic programming. 
	 * We take a two dimensional array L of size count+1, sum/2+1. Where L[i,j]=maximum sum possible with elements of array 0 to i and sum not exceeding j. 
	 * We compute this array from L[0,0] to L[n,sum/2]. So for computing L[i,j] we need to check the element i. 
	 * if it is greater than j then it cannot be included in the sum so L[i,j]=L[i-1,j]. 
	 * If ith element is less than j, then we should consider two cases and take the greater of them. 
	 * First case is where we don't include the element in sum. Then L[i,j] = L[i-1,j] which is exactly like before. 
	 * Now if we include the element, then L[i,j]=a[i]+L[i-1,j-a[i]]. In this way we fill this 2-d array. 
	 * If L[n,sum/2] is equal to sum/2 that means the array can be partitioned in two parts whose sums are equal. 
	 * Then we find out which elements have been included in that sum by backtracking through that 2-d array.
	 * 
	 * For backtracking through the array we just apply the reverse logic. 
	 * If L[i,j] is equal to a[i]+L[i-1,j-a[i]] then that element is included in the partition. 
	 * Then we continue this process to L[i-1,j-a[i]). 
	 * If it is not equal then the element is not included in the final sum, so we proceed to L[i-1,j] 
	 * After we get the complete list of elements in a partition we remove them from the original array to get the second partition. 
	 */

	//	############################################################################################################################################







	public static boolean findPartiion (int[] arr, int n) {
		int sum = 0;
		int i, j;

		// Caculcate sun of all elements
		for (i = 0; i < n; i++)
			sum += arr[i];

		if (sum%2 != 0)  
			return false;

		boolean[][] part = new boolean[sum/2+1][n+1];

		// initialize top row as true
		for (i = 0; i <= n; i++) {
			part[0][i] = true;
		}

		// initialize leftmost column, except part[0][0], as 0
		for (i = 1; i <= sum/2; i++) {
			part[i][0] = false;     
		}

		// Fill the partition table in botton up manner 
		for (i = 1; i <= sum/2; i++) {
			for (j = 1; j <= n; j++) {
				part[i][j] = part[i][j-1];
				if (i >= arr[j-1]) {
					part[i][j] = part[i][j] || part[i - arr[j-1]][j-1];
				}
			}    
		}    

//			     // uncomment this part to print table 
//			     for (i = 0; i <= sum/2; i++) {
//			       for (j = 0; j <= n; j++)  
//			          System.out.println("%4d" + part[i][j]);
//			       
//			       System.out.println("");
//			     }

		return part[sum/2][n];
	}     

}
