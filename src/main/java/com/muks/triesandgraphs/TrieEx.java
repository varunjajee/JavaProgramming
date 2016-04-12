package triesandgraphs;

import java.util.HashMap;
import java.util.Map;

import triesandgraphs.TrieEx.Node;

/*
 * TrieMatrix is an efficient information retrieval data structure.
 * Using trie, search complexities can be brought to optimal limit (key length). 
 * If we store keys in binary search tree, a well balanced BST will need time proportional to O(M * log N), 
 * where M is maximum string length and N is number of keys in tree. 
 * 
 * Using trie, we can search the key in O(M) time. However the penalty is on trie storage requirements.
 */

public class TrieEx {

	public static class Node {
		private boolean isWord = false; // indicates a complete word
		private int prefixes = 0; // indicates how many words have the prefix
		private Map<Character, Node> children = new HashMap<Character, Node>(); // references to all possible children

	}

	private Node root = new Node();

	/**
	 * Inserts a new word into the trie
	 * @param word
	 */
	public void insertWord(String word){
		if(searchWord(word) == true) return;

		Node current = root;
		for(char c : word.toCharArray()) {
			
			// Character.valueof(c) => simply takes a char and returns a Character wrapper instance representing the same value
			// if you use 0, 1 or very high values) as your starting point, then the result will be a String containing a single Unicode character 
			if ( current.children.containsKey( Character.valueOf( c ) ) ) {
				
				Node child = (Node) current.children.get(Character.valueOf(c));
				System.out.println(" + " + current.children.get(Character.valueOf(c)).toString());
				
				child.prefixes++;
				current = child;
				
			} else {
				Node child = new Node();
				child.prefixes = 1;
				System.out.println("++++ " + current.children.get(Character.valueOf(c)));
				current.children.put(Character.valueOf(c), child);
				current = child;
			}
		}
		// we have reached the endof the word, hence mark it true
		// if during a search we reach the end of the search string and this
		// flag is still false, then the search string is not registered as a valid
		// word in the trie but is a prefix
		current.isWord = true;
	}

	/**
	 * Searches for a word in the trie
	 * @param word
	 */
	public boolean searchWord(String word){
		Node current = root;
		for(char c : word.toCharArray()){
			if(current.children.containsKey(Character.valueOf(c))){
				current = (Node) current.children.get(Character.valueOf(c));

			} else {
				return false;

			}

		}
		// if at the end of the search of entire word the boolean variable is
		// still false means that the given word is not regitered as a valid
		// word in the trie, but is a prefix
		System.out.println("+++ INFO: There are " + current.prefixes + " words with the same prefix...!");
		return current.isWord;
	}

	/**
	 * Deletes a word from the trie
	 * @param word
	 */
	public void deleteWord(String word){
		if(searchWord(word) == false) return;

		Node current = root;
		for(char c : word.toCharArray()){
			Node child = (Node) current.children.get(Character.valueOf(c));
			if(child.prefixes == 1){
				current.children.remove(Character.valueOf(c));
				return;
			}else{
				child.prefixes--;
				current = child;
			}
		}
		// since the word is removed now, set the flag to false
		current.isWord = false;
	}


	/*
	 * Print TrieMatrix:
	 * 
	 */
//	public void printTrie() {
//		if (root == null) {
//			return;
//		}
//
//	}



	public static void main(String[] args) {
		TrieEx trie = new TrieEx();
//		trie.insertWord("ball");
//		trie.insertWord("balls");
//		trie.insertWord("bat");
//		trie.insertWord("doll");
//		trie.insertWord("dork");
//		trie.insertWord("dorm");
//		trie.insertWord("send");
//		trie.insertWord("sense");
		
		String[] words = {"ball", "balls", "bat", "doll", "dork", "dorm", "send", "sense"};
		
		trie.insertWord("ball");
		trie.insertWord("balls");
//		
//		for (int i = 0; i < words.length; i++)
//			trie.insertWord(words[i]);


		// testing deletion
		System.out.println(trie.searchWord("ba"));
		//trie.deleteWord("ball");
		//System.out.println(trie.searchWord("ball"));
		//System.out.println(trie.searchWord("balls"));

		// testing insertion
		//System.out.println(trie.searchWord("dumb"));
		//trie.insertWord("dumb");
		//System.out.println(trie.searchWord("dumb"));
		//trie.deleteWord("dumb");
		//System.out.println(trie.searchWord("dumb"));
	}



}

