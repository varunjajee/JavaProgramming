package AlgosOnString;



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class NextLargeNumberFromSameDigits {

	/**
	 * given a number whose digits are unique find the next bigger number formed by those digits
	 * @param args
	 * 
	 *  Solution:
	 *  ---------
	 *  1. If all the digits are in increasing order from right to left, 
	 *  then no larger number is possible as that is the largest number possible with those digits. 
	 *  2. If they are not in increasing order form right to left then a larger number is possible. 
	 *  3. We need to find the first decreasing sequence from right side. Then we can bring the larger number in place of the smaller number. 
	 *  4. After that if we arrange the remaining digits in increasing order, next bigger number will be formed.
	 */
	
	public static void main(String[] args) throws Exception {

		String input = "1265"; 	// 1562
		genNextBigNum(input);


	}	// end main()

	public static void genNextBigNum (String input) {
		
		// find if the leght is just 1
		if (input.length() == 1) {
			System.out.println("no greater number possible");
			return;
		}

		List<Integer> dList = new ArrayList<Integer>();
		for (int i = 0; i < input.length(); ++i) {

			Integer digit = Integer.parseInt(input.substring(i, i + 1));
			System.out.println("\n +++ digits: " + digit);
			
			if (dList.contains(digit)) {
				System.out.println("All digits are not unique");
				return;
				
			} else {
				dList.add(digit);
			
			}

		}
		
		System.out.println(dList.toString());
		
		
		
		int rightBiggerIndex=-1;
		int leftSmallerIndex=-1;

		for(int right = dList.size()-1; right > 0 && rightBiggerIndex == -1 ; right--) {
			for(int left = right - 1; left >= 0; left--) {

				if(dList.get(right) > dList.get(left)) {
					rightBiggerIndex = right;
					leftSmallerIndex = left;
					break;
				}
			}
		}

		if(rightBiggerIndex == -1 || leftSmallerIndex == -1) {
			System.out.println("no greater number possible");
			return;
		}
		
		swap(dList, rightBiggerIndex, leftSmallerIndex);
		sortInIncreasingOrder(dList, leftSmallerIndex+1, dList.size() - 1);

		
		for(int num:dList) {
			System.out.print(num);
		}

		
	}	// end convert()
	
	
	
	private static void sortInIncreasingOrder(List<Integer> digits, int startIndex, int endIndex) {
		
		// base case for the break of flow
		if(startIndex == endIndex) {
			return;
		}
		
		// arranging in increasing order, from left to right
		for(int left = startIndex; left < endIndex; left++) {
			for(int right = startIndex+1; right <= endIndex; right++) {
				
				if(digits.get(left) > digits.get(right)) {
					swap(digits,left,right);
				}
				
			}
		}
		
		return;

	}

	
	private static void swap(List<Integer> digits, int i, int j) {
		Integer temp=digits.get(i);
		digits.set(i, digits.get(j));
		digits.set(j, temp);
	}
}