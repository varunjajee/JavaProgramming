package com.muks.algo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CharacterPrecedence {

	/*
	 * http://stackoverflow.com/questions/10304176/order-a-list-of-characters-given-a-dictionary
	 * http://www.careercup.com/question?id=13394663
	 */
	
	public static Set<Character> charPrecedence(List<String> dictionary, char[] letters){
	    Set<Character> result = new HashSet<Character>();
	    //since your characters are the 26 letters instead of the 256 chars
	    // a bit vector won't do; you need a map or set
	    Set<Character> alphabets = new HashSet<Character>();
	    for(char c: letters)
	       alphabets.add(c);

	    //now get to work
	    for(String word: dictionary){
	       if(alphabets.isEmpty()) return result;
	       for(char c: word.toCharArray()){
	          if(alphabets.remove(c))
	           result.add(c);
	       }
	    }
	    //since the dictionary is guaranteed to contain all the 26 letters,
	    //per the problem statement, then at this point your work is done.
	    return result;
	}
	
}
