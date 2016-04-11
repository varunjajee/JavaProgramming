package com.muks.Algorithm.AlgoBasics;


public class Swapping2Vars {

	/**
	 * @param args
	 * 
	 * Swapping of 2 int:
	 * This can be accomplished by 3 methods
	 * (1) If int, then using (+/-) aperations
	 * (2) else using Xor
	 * Method 2 : Using X-OR (^) operator
//
//		a = a^b;
//		b = b^a;
//		a = a^b;
//		
//		lets take a same example a=10 & b=5,
//		
//		a = a^b = 10^5 = 15        so, a=15 & b=5
//		b = b^a = 5^15 = 10        so, a=15 & b=10
//		a = a^b =15^10 = 5         so, a=5 & b=10
//		
//		Drawback of this method is that it will not work for floating-point values.

	 * (3) else using references which again uses a temp variable
	 * swap(int *a, int *b) {
//		if(*a!=*b) {
//			*a = *a^*b;
//			*b = *b^*a;
//			*a = *a^*b;
//		}
//		}
	 * Swapping 2 variables;
	 * (1) Using ref, and use of a temp variable for temp storage.
	 * 
	 */
	public static void main(String[] args) {
		// Swapping 2 integers without using temp

		int x = 10;
		int y = 20;
		System.out.println("Before swap:");
		System.out.println("x value: "+x);
		System.out.println("y value: "+y);
		x = x+y;
		y=x-y;
		x=x-y;
		System.out.println("After swap:");
		System.out.println("x value: "+x);
		System.out.println("y value: "+y);

		swap2Vars();

		swap(10, 20);
		
	}

	public static void swap2Vars() {

		String a = "first";
		String b = "second";

		System.out.println("First Var: " + a + "\n" + "Second Var: " + b);
		Object temp = a;
		a = b;
		b = temp.toString();

		System.out.println("First Var: " + a + "\n" + "Second Var: " + b);



	}

	public static void swap(int a, int b) {
		System.out.println("a: " + a + " b: " + b);
		
		if(a != b) {
			a = a^b;
			b = b^a;
			a = a^b;
		}
		
		System.out.println("a: " + a + " b: " + b);
	}


}


