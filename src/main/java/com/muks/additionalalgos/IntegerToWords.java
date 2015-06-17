package com.muks.algo.additionalalgos;

public class IntegerToWords {

	public static void main(String[] args) {
		convertNum(21);
		//convertNum(100001);

	}


	public static void convertNum(int number) {
		System.out.println("+ Number: " + number);		// Debug
		
		String[] digit = { "", "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine", "ten", "eleven", "twelve",
				"thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
				"eighteen", "nineteen" };
		
		String[] tens = { "", "", "twenty", "thirty", "forty", "fifty",
				"sixty", "seventy", "eighty", "ninety" };
		
		if (number > 0 && number < 20) {
			System.out.print(digit[number]);
			
		} 
		else if (number / 1000000 > 0) {		// million - 1 + 6 zeros
			convertNum(number / 1000000);
			System.out.print(" million ");
			convertNum(number % 1000000);
			
		} else if (number / 100000 > 0) {		// laks - 1 + 5 zeros
			convertNum(number / 100000);
			System.out.print(" lakh ");
			convertNum(number % 100000);

		} else if (number / 1000 > 0) {
			convertNum(number / 1000);
			System.out.print(" thousand ");
			convertNum(number % 1000);

		} else if (number / 100 > 0) {
			convertNum(number / 100);
			System.out.print(" hundred ");
			convertNum(number % 100);

		} else if (number / 10 >= 2) {
			System.out.println("hre...");
			System.out.print(" " + tens[number / 10] + " ");	// each number in tens[] is a multiple of 10
			convertNum(number % 10);

		}

	} 
}
