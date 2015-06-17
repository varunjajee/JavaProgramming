package AlgosOnString;

import java.util.HashSet;

public class RemoveDuplicatesFromString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abcbbaad";
		char[] arr = s.toCharArray();

		
//		removeDuplicates(arr);

		System.out.println("\n+ SubString: " + s.substring(0, 1));
		
		String res = removeDuplicatesBySubstring(s);
		System.out.println(res);


	}	// end main()

	
	
	// #########################################################################################################
	// Just using StringBuilder, substring check using indexOf == -1
	public static String removeDuplicatesBySubstring(String s) {
		StringBuilder resString = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			String si = s.substring(i, i + 1);

			if (resString.indexOf(si) == -1) {
				resString.append(si);
			}

		}

		return resString.toString();

	}	// removeDuplicatesBySubstring

	public static void printArray (char[] s) {
		String a = "";
		for (char c : s) {
			a += c;
		}
		System.out.println(a);
	}



	// function takes a char array as input.
	// modifies it to remove duplicates and adds a 0 to mark the end
	// of the unique chars in the array.
	public static void removeDuplicates(char[] str) {
		if (str == null) return;
		int len = str.length;
		if (len < 2) return; // if its less than 2..can't have duplicates..return.

		int tail = 1; // number of unique char in the array.

		for (int i = 1; i < len; ++i) { 
			int j;

			// for every char in outer loop check if that char is already seen.
			for (j = 0; j < tail; ++j) {
				if (str[i] == str[j]) break; // break if we find duplicate.
			}

			// if j reachs tail..we did not break, which implies this char at pos i, is not a duplicate.
			// we add it to the end, that is at pos tail.
			System.out.println(j + " == " + tail);
			if (j == tail) {
				//System.out.println(str[tail] + " = " + str[i]);
				str[tail] = str[i]; // add
				tail++;
			}
		}

		str[tail] = '\0'; // add a 0 at the end to mark the end of the unique char.

		String si = "";
		for (char c : str) {
			si += c;
		}
		System.out.println("+++ " + si);
		
		return;


	}






}