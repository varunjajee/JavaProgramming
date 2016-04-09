package com.muks.Algorithm.AlgosOnString;

public class DeleteDuplicatesFromString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "abcbbaad";
		char[] arr = s.toCharArray();

		//removeDupUsingSubstring(s);
		//deleteDupUsingArray(s);

        getUniq(s);

	}	// end main()


    private static void getUniq(String input) {
        boolean[] charCounter = new boolean[256];

        for (char ch : input.toCharArray()) {
            if (!charCounter[ch]) {
                System.out.print(ch);
                charCounter[ch] = true;
            }
        }
    }

	private static void deleteDupUsingArray(String input) {
		char[] arr = input.toCharArray();

		int i = 0, j = 1;
		while (j < arr.length) {
			if (arr[i] == arr[j]) {
				j++;
			}
			else {
				i++;
				arr[i] = arr[j];
				j++;
			}
		}

		for (int k = 0; k <= i; k++) {
			System.out.print(arr[k]);
		}
	}

	// ==========================================================================================
	// Just using StringBuilder, substring check using indexOf == -1
	public static void removeDupUsingSubstring(String s) {
		StringBuilder resString = new StringBuilder();

		for (int i = 0; i < s.length(); i++) {
			String si = s.substring(i, i + 1);

            /** indexOf in a StringBuilder returns index of a str in StringBuilder & -1 if not found */
            if (resString.indexOf(si) == -1) {
				resString.append(si);
			}
		}

		System.out.println("# De-dup: " + resString.toString());
	}	// end ()




	public static void printArray (char[] s) {
		String a = "";
		for (char c : s) {
			a += c;
		}
		System.out.println(a);
	}


}