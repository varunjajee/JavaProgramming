package com.muks.Algorithm.AlgosOnArrays.Basics;

import java.util.ArrayList;
import java.util.List;

public class FindMissingIntContineous {

	public static void main(String[] args) {
        int[] a = {1, 4, 5, 6, 7, 10};
        int[] arr1 = {4, 6, 8, 10, 12, 14};
        int[] arr2  = {1, 6, 11, 16, 21, 31};

        allMissingElements(arr2);
    }

    private static void allMissingElements(int[] a) {
		List<Integer> missingList = new ArrayList<>();
		
		int j = a[0];

		for (int i=0; i < a.length; i++) {

            System.out.println(a[i] + ", i=" + i + " j=" + j);
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
