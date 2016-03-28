package com.muks.Algorithm;

public class DeleteBlankSpaces {

	/* ====================================================================================
		Logic:
			Where ever I find some space, I just increment 'j' and then arr[i] = arr[i+j]

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
			System.out.println(" arr[" + i + "] = " + str.charAt(i)
					+ ", arr[" + j + "] = " + str.charAt(i+j) + " arr.length: " + arr.length);

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
