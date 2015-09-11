package AlgosOnString;

public class StringMatchWithWildChars {


	public static void main(String[] args) {
//		String s1 = "ge?ks*";
//		String s2 = "geeksforgeeks";
		
//		String s1 = "g*k";
//		String s2 = "gee";
		
//		String s1 = "abc*bcd";
//		String s2 = "abcdhghgbcd"; 

		String s1 = "*qrs";
		String s2 = "pqrst";
		
//		String s1 = "a*";
//		String s2 = "abcd";
		boolean state = match(s1.toCharArray(), s2.toCharArray(), 0, 0); // Yes
		System.out.println(state);

	}



	private static boolean match(char[] arr1, char[] arr2, int i, int j) {
		if (i >= arr1.length || j >= arr2.length)
			return true;

		char a = arr1[i];
		char b = arr2[j];

//		if (i < j && a != b) {
//			return false;
//		}
		
		System.out.println("\n" + "a: " + a + " b: " + b );
		if (a == '*' && i + 1 >= arr1.length || j >= arr2.length) {
			System.out.println(" 1");
			return false;
		}

		if (a == '?' || a == b) {
			System.out.println(" 2");
			return match(arr1, arr2, i + 1, j + 1);
		}

		if (a == '*') {
			System.out.println(" 3");
			return match(arr1, arr2, i + 1, j) || match(arr1, arr2, i, j + 1);
		}
			


		return false;
	}




}
