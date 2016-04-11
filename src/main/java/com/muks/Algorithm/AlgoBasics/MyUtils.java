package com.muks.Algorithm.AlgoBasics;

public class MyUtils {
	
	public static String arrayToString(int[] array) {
		String res = "";
		for (int a: array) {
			res += a + " ";
		}
		return res;
		
	} // end arrayToString()
	
	public static String arrayToString(String[] array) {
		String res = "";
		for (String a: array) {
			res += a + " ";
		}
		return res;
		
	} // end arrayToString()

}
