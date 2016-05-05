package com.muks.Algorithm.AlgoBasics;



import java.util.ArrayList;
import java.util.List;

public class NextLargeNumberFromSameDigits {
	/**
	 * given a number whose digits are unique find the next bigger number formed by those digits
	 * @param args
	 *
     * http://www.geeksforgeeks.org/find-next-greater-number-set-digits/
     *
     * Logic:
     *  Base case 1: Next big integer DOES NOT exists if the number has;
     *              - All same digits Eg: 1111, 222 or
     *              - the digits are in incremental form from left to right
     *
     *  Base case 2: If the length of the number is just one digit
     *
     *  Logic:
     *      - Traverse the int array from right to left
     *      - Traverse till the next digit is smaller than the current digit Eg: [i-1] < [i]
     *      - While traversing, keep track of smallest int encountered.
     *      - Find smallest digit just greater than next int & swap them
     *      - Sort in increasing order at the end
     * */
	
	public static void main(String[] args) throws Exception {

		int num1 = 1234; 	// 1243
        int num2 = 1111;
        int num3 = 1;

        int num4 = 534976;

        FindNextBigNumber(num4);

	}	// end main()



	public static void FindNextBigNumber (int number) {
        System.out.println("+ Input = " + number);
        String input = Integer.toString(number);    /** convert int to string */

        /** convert string number to int array. */
        List<Integer> dList = new ArrayList<>();
        for (int i = 0; i < input.length(); ++i) {
            Integer digit = Integer.parseInt(input.substring(i, i + 1));

            /** check if all digits are same (Large number wouldn't be possible) */
            if (dList.contains(digit)) {
                System.out.println("All digits are not unique, NO next big number is possible.");
                return;
            } else {
                dList.add(digit);
            }
        }


		/** find if the length is just 1   */
		if (dList.size() == 1) {
			System.out.println("no greater number possible");
			return;
		}


        /** find right digit bigger than left digit and break out */
		int rightBiggerIndex=-1;
		int leftSmallerIndex=-1;
		for (int right = dList.size() - 1; right > 0 && rightBiggerIndex == -1 ; right--) {
			for (int left = right - 1; left >= 0; left--) {

				if (dList.get(right) > dList.get(left)) {
					rightBiggerIndex = right;
					leftSmallerIndex = left;
					break;
				}
			}
		}

		if(rightBiggerIndex == -1 || leftSmallerIndex == -1) {
			System.out.println("No greater number possible");
			return;
		}

        /** Swap and sorting in increasing order */
        System.out.println("+ Swapping numbers : " + dList.get(rightBiggerIndex) + ", " + dList.get(leftSmallerIndex) );
        swap(dList, rightBiggerIndex, leftSmallerIndex);

		sortInIncreasingOrder(dList, leftSmallerIndex+1, dList.size() - 1);


        /** Printing final number */
		for(int num:dList) {
			System.out.print(num);
		}


	}	// end convert()



	private static void sortInIncreasingOrder(List<Integer> digits, int startIndex, int endIndex) {
        /** base case for the break of flow */
        if(startIndex == endIndex) {
            return;
        }

        /** sort in increasing order */
        for (int i = startIndex; i <= endIndex; i++) {
            int runner = startIndex;

            while (runner != i) {
                if (digits.get(runner) > digits.get(i)) {
                    swap(digits, runner, i);
                }

                runner++;
            }
        }

	}


	private static void swap(List<Integer> digits, int i, int j) {
		Integer temp = digits.get(i);
		digits.set(i, digits.get(j));
		digits.set(j, temp);
	}
}