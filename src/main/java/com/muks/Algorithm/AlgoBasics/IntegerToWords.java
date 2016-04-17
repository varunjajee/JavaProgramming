package com.muks.Algorithm.AlgoBasics;

public class IntegerToWords {

	public static void main(String[] args) {
		//int num = 21;
		int num = 2501;
        System.out.println(
                "+ Number in words: " + numberInWords(num, new StringBuilder()));
	}


	private static String numberInWords(int number, StringBuilder sb) {
		System.out.println("\n+ Number: " + number);		// Debug
		
		String[] digit = { "", "one", "two", "three", "four", "five", "six",
				"seven", "eight", "nine", "ten", "eleven", "twelve",
				"thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
				"eighteen", "nineteen" };
		
		String[] tens = { "", "", "twenty", "thirty", "forty", "fifty",
				"sixty", "seventy", "eighty", "ninety" };
		
		if (number > 0 && number < 20) {
			System.out.println("(1)");
			sb.append(digit[number]);
			
		} 
		else if (number / 1000000 > 0) {		// million - 1 + 6 zeros
			numberInWords(number / 1000000, sb);
			sb.append(" million ");
			numberInWords(number % 1000000, sb);
			
		} else if (number / 100000 > 0) {		// laks - 1 + 5 zeros
			numberInWords(number / 100000, sb);
			sb.append(" lakh ");
			numberInWords(number % 100000, sb);

		} else if (number / 1000 > 0) {
			numberInWords(number / 1000, sb);
			sb.append(" thousand ");
			numberInWords(number % 1000, sb);

		} else if (number / 100 > 0) {
			numberInWords(number / 100, sb);
			sb.append(" hundred ");
			numberInWords(number % 100, sb);

		} else if (number / 10 >= 2) {
			System.out.println("+ /10");
			sb.append(" " + tens[number / 10] + " ");	// each number in tens[] is a multiple of 10
			numberInWords(number % 10, sb);

		}

		return sb.toString();

	}
}
