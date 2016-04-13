package com.muks.Algorithm.AlgosOnArrays.Basics;

public class testing {



	public static void main(String[] args){

		int[] arr = {1, 2, 3, 4, 5};
		
		int leftsum = 0;
		int sum = 0;
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
//			if (sum > leftsum) {
//				leftsum = sum;
//			}
		}
		
		System.out.println("++ lefsum: " + sum);

	}

}
