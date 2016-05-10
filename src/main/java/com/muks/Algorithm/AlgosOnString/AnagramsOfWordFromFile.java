package AlgosOnString;


import java.util.*;
import java.io.*;


public class AnagramsOfWordFromFile {
	/*
	 * Print all the anagrams from a input file, corresponding to a word given as a input
	 */
	
	public static void main(String[] args) {
		String beta = "cat";
		String fileName = "/Users/muktharahmed/Data2/tutorials/DSC_And_Algorithms/src/crackingcodingIntrvsStringAlgos/anagrams_dic.txt";

		try {

			Map<String, List<String>> map = new HashMap<String, List<String>>();

			Scanner s = new Scanner(new File(fileName));	// reading the file
			while (s.hasNext()) {
				String word = s.next();
				String sortedWord = sorting(word);
				List<String> list = map.get(sortedWord);

				if (list == null) {
					map.put(sortedWord, list = new ArrayList<>());
				}
				list.add(word);
			}

			List<String> l = map.get(sorting(beta));
			Object[] arr = l.toArray();
			for (int i=0; i < arr.length; i++)
				System.out.println("+++ " + arr[i]);

		} 
		catch (Exception e) {
			System.out.println(e);
			System.exit(1);
		}

	}

	private static String sorting(String s) {
		char[] a = s.toCharArray();
		Arrays.sort(a);
		return new String(a);
	}
}