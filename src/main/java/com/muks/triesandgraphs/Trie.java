package triesandgraphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/*
 * 1. Fetch all possible words from a 2D array of characters
 * 2. Find all words matching a prefix
 * 3. Count the number of words matching a prefix
 * 
 */
public class Trie {

	private TNode root;

	public Trie(){
		root = new TNode();
	}

	public void insert(String word){
		int length = word.length();
		TNode trieNode = root;

		for(int level = 0; level < length; level++){
			char ch = word.charAt(level);
			int index = (int)ch - (int)'a';

			if(trieNode.getChild(index) != null) {
				trieNode = trieNode.getChild(index);
				//System.out.println(" + Child not null: " + trieNode);
				
			} else {
				//System.out.println(" Setting the child: " + index);
				trieNode.setChild(index);
				trieNode = trieNode.getChild(index);
				
			}
		}
		trieNode.setIsEnd(true);
	}

	
	
	public String getMatchingPrefix(String input){
		int length = input.length();
		TNode crawl = root;
		int prevMatch = 0;
		String result = "";

		for(int level = 0; level < length; level++){
			char ch = input.charAt(level);
			int index = (int)ch - (int)'a';
			
			if(crawl.getChild(index) != null){
				result += ch;
				crawl = crawl.getChild(index);

				if(crawl.isEnd()) {
					prevMatch = level + 1;
					
				}
			}
			else
				break;
		}
		if(!crawl.isEnd()) {
			return result.substring(0, prevMatch);
		} else {
			System.out.println("+ Res: " + result + " prevMatch: " +prevMatch );
			return result;
			
		}
	}


	public static String getString() throws IOException{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}

	//public class LongestPrefixMatching {
	public static void main(String[] args) throws IOException{
		Trie dict = new Trie();
		dict.insert("are");
		dict.insert("area");
		dict.insert("base");
		dict.insert("cat");
		dict.insert("cater");        
		dict.insert("basement");

		
		String input = "are";
		System.out.print(input + ": ");
		String ret = dict.getMatchingPrefix(input);
		if ( ret == "") {
			System.out.println("Matching Prefix NOT FOUND...");
		} else {
			System.out.println("+++ " + ret);
		}
		
//		
//		for(int i = 0; i < 6; i++){
//			System.out.print("\nEnter a string: ");
//
//			String input = getString();
//			System.out.print(input + ": ");
//			if (dict.getMatchingPrefix(input) == " ") {
//				System.out.println("Matching Prefix NOT FOUND...");
//			} else {
//				System.out.println(dict.getMatchingPrefix(input));
//			}
//		}
	}


}
