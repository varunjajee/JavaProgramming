package AlgosOnString;

import java.util.*;


public class AnagramsFromDictionary {


	private static HashMap<String, ArrayList<String>> anagramMap = new HashMap<String, ArrayList<String>>();

	public static void main(String[] args) {
		
		String[] dictionary = {"cat", "dog", "tac", "god", "act", "muks"};
		
		AnagramsFromDictionary AClass = new AnagramsFromDictionary();
		AClass.findAnagrams(dictionary);	// pre-process all the words
		
		for (String s : dictionary) {
			boolean isAnagram = AClass.printAnagrams(s);
			if (isAnagram) { 
				System.out.println(s);
			}
		}
	}

	
	// ############################################################################################################
	// pre process all the words into a hash map
	public void findAnagrams(String [] dictionary) {
		int len = dictionary.length;
		

		for (int i=0; i<len; i++) {

			String sortedWord = sortWordLexicographically(dictionary[i]);
			ArrayList<String> wordListKey = anagramMap.get(sortedWord);
			System.out.println("+++ wordList: " + wordListKey);
			
			if (wordListKey == null) {
				wordListKey = new ArrayList<String>();   
			}
			wordListKey.add(dictionary[i]);
			System.out.println("+++ " + wordListKey.toString());
			anagramMap.put(sortedWord, wordListKey);

		}

		printHash(anagramMap);
		System.out.println("++++ End Pre-process anagrams +++");
		
	}

	
	// ############################################################################################################
	// print all anagrams corresponding to a word
	public boolean printAnagrams(String word) {
		String out = "";
		
		if (word == null) {
			System.out.println("Input word is null!");

		} else {

			ArrayList<String> wordList = getAnagrams(word);
			//System.out.println("Size: " + word + " " + wordList.size() );
			//if (wordList == null) {
			if (wordList.size() <= 1) {
				//System.out.println("No anagrams exists for : " + word);
				return false;

			} else if (wordList.size() > 1) {
				Iterator<String> iter = wordList.iterator();
				out += word + " ";
				while (iter.hasNext()) {
					out += iter.next() + " ";
				}
				System.out.print("\nword: " + word + " => " + out);
				

			}
			
		} 
		return true;
	}
	
		
	// ############################################################################################################
	// getAnagrams
	public ArrayList<String> getAnagrams(String word) {
		if (word == null) { return null; }

		String sortedWord = sortWordLexicographically(word); 
		return anagramMap.get(sortedWord);
	}
	

	// ############################################################################################################
	// util to sort a given word and return with sorted chars
	public static String sortWordLexicographically(String word) { 
		char[] wordArray = word.toCharArray();
		Arrays.sort(wordArray);

		String s = "";
		for (char c: wordArray) {
			s += c;
		}
		return s;

	}


	// ############################################################################################################
	// util to print the hash map
	public static void printHash (HashMap<String, ArrayList<String>> mymap) {
		String out = "{ ";
		for (String s : mymap.keySet()) {
			out += s + "=>" + mymap.get(s) + " ";
		}
		out += " }";

		System.out.println(out);
	}


}
