package com.muks.Algorithm.AlgosOnArrays;

import java.util.ArrayList;
import java.util.List;

public class FindMissingInt {


	@SuppressWarnings("null")
	public static void main(String[] args) {
		int[] a = {1,3,4,5,6,7,10};
		
		
		List<Integer> missingList = new ArrayList<Integer>();
		
		int j = a[0];
		for (int i=0; i < a.length; i++) {
			System.out.println(a[i] + " = " + j);
			if (a[i] == j) {
				j++;
				continue;
			} else {
				missingList.add(j);
				i--;
				j++;
			}
		}
		
		String s = "";
		for (int i: missingList) {
			s += i+" ";
		}
		System.out.println(s);

	}

}
