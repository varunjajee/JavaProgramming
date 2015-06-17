package datastructures;

import java.util.HashSet;
import java.util.Set;

public class TrieNode {

	private boolean endOfWord;
	private int phraseNb;
	private char letter;
	private HashSet<TrieNode> children = new HashSet<TrieNode>();

	public TrieNode(){}

	public TrieNode(char letter){
		this.letter = letter;
	}

	public boolean isWord(){
		return endOfWord;
	}

	public void setNb(int nb){
		phraseNb = nb;
	}

	public int getNb(){
		return phraseNb;
	}

	public char getLetter(){
		return letter;
	}

	public TrieNode getChild(char c){
		for(TrieNode child: children){
			if(c == child.getLetter()){
				return child;
			}
		}
		return null;
	}

	public Set<TrieNode> getChildren(){
		return children;
	}

	public boolean addChild(TrieNode t){
		return children.add(t);
	}

	public void endOfWord(){
		endOfWord = true;
	}

	public void notEndOfWord(){
		endOfWord = false;
	}
}