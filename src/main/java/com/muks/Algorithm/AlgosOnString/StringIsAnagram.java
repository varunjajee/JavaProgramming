package AlgosOnString;

import java.util.Arrays;
import java.util.HashMap;

public class StringIsAnagram {

	public static void main(String[] args) {
		String s1 = "abcd";
		String s2 = "abdc";
		System.out.println("+ s1: " + s1 + " s2: " + s2);
		System.out.println("\n +++ Is Anagram of: " + isAnagram(s1, s2) );

	}


	// #################################################################################################################
	// time complexity - O(n)

	public static boolean isAnagram(String s1, String s2){

		if ( s1.length() != s2.length() ) {		// return false if string are not of equal length
			return false;
		}

		char[] a = s1.toCharArray();
		char[] b = s2.toCharArray();
		Arrays.sort(a);
		Arrays.sort(b);

		for(int i = 0; i < a.length-1; i++) {
			if(b[i] != a[i]) {
				return false;  
			}
		}

		return true;
		//        String sc1 = new String(c1);
		//        String sc2 = new String(c2);
		//        return sc1.equals(sc2);

	}	// end isAnagram()

	// ############################################################################################################
	// By using hashmap
	/*
	 * 1. Create a Hashmap where key - character and value - frequencey of character,
	 * 2. for first string populate the hashmap (O(n))
	 * 3. for second string decrement count and remove element from hashmap O(n)
	 * 4. if hashmap is empty, the string is anagram otherwise not.
	 */
	
	public static boolean checkPermutation(String str1, String str2) {

		char[] chars1 = str1.toCharArray();
		char[] chars2 = str2.toCharArray();

		HashMap<Character, Integer> map1 = new HashMap<Character, Integer>();
		HashMap<Character, Integer> map2 = new HashMap<Character, Integer>();

		for (char c : chars1) {
			if ( map1.containsKey(c) ) {
				map1.put( c, map1.get(c)+1 );
			}
			map1.put(c, 1);
		}

		// now do the same for chars2 and map2
		for (char c : chars2) {
			if ( map2.containsKey(c) ) {
				map2.put( c, map2.get(c)+1 );
			}
			map2.put(c, 1);
			
		} // for()
		
		
		if (map1.size() != map2.size()) {	// return false if the map sizes do not match
			return false;
		}
		
		for (char c : map1.keySet()) {		// compare each element in the map along with the char count
			if (!map2.containsKey(c) || map1.get(c) != map2.get(c)) {
				return false;
			}
		}

		return true;
	}

} // end class()
