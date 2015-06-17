package com.muks.algo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class DeleteBlankSpaces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abab dece af";
		rem(s);


	}
	
	public static void rem(String str) {
		char[] arr = str.toCharArray();
		
		
		int j = 0;
		for (int i=0; i < arr.length - j; i++) {
			System.out.println(" i: " + i + " j: " + j + " arr.length: " + arr.length);
			if (arr[i+j] == ' ') {
				j++;
			}
			arr[i] = arr[i+j];
			
		}
		
		arr[arr.length-j] = '\0';	 // add a 0 at the end to mark the end of the unique char
		
		String s = "";
		for (char c : arr) {
			s += c;
		}
		System.out.println("+++ Final output with deleted spaces: " + s);
		
	}
	
}
