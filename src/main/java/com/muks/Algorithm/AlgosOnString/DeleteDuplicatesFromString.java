package com.muks.Algorithm.AlgosOnString;

public class DeleteDuplicatesFromString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "aaabcbbaaeda";
		char[] arr = s.toCharArray();

		//removeDupUsingSubstring(s);

        deDuplicateByHashing(s.toCharArray());


	}	// end main()

    /** ==================================================================
     * Deleting duplicate chars from arr string,
     Time - O(n)
     Space - (1) auxillary space

        Very important one

     */
    private static void deDuplicateByHashing(char[] arr) {
        boolean[] hashVisisted = new boolean[256];

        int j = 0;
        for (int i = 0; i < arr.length; i++) {

            if ( !hashVisisted[ arr[i] ] ) {
                hashVisisted[arr[i]] = true;
                arr[j] = arr[i];
                j++;
            }
        }

        arr[j] = '\0';

        for (char ch : arr) {
            System.out.print(" " + ch);
        }
    }


    // ==========================================================================================
    // Just using StringBuilder, substring check using indexOf == -1
    public static void removeDupUsingSubstring(String s) {
        StringBuilder resString = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            String si = s.substring(i, i + 1);

            /** indexOf in a StringBuilder returns index of a str in StringBuilder & -1 if not found */
            if (resString.indexOf(si) == -1) {
                resString.append(si);
            }
        }

        System.out.println("# De-dup: " + resString.toString());
    }	// end ()






    static void deDupByBitwise(char str[]){
        int i, checker = 0, bitvalue = 0, value = 0, tail = 0;
        i = 0;
        tail = 0;
        while(i < str.length){
            value = str[i] - 'a';
            bitvalue = 1 << value;

            System.out.println("# Val = " + value + ", BitValue = " + bitvalue);
            if ( (checker & bitvalue) == 0 ) {
                System.out.println("# checker = " + checker + ", bitVal = " + bitvalue
                + " ===== true");
                str[tail++] = str[i];
                checker |= bitvalue;
            }
            i++;
        }
        str[tail] = '\0';

        for (int j = 0; j < str.length; j++) {
            System.out.print(" " + str[j]);
        }
    }



    public static void RemoveDuplicates(char[] str){
        int check = 0;
        for(int i = 0; i < str.length; i++){
            int val = str[i] - 'a';
            if((check & (1 << val)) > 0){
                str[i] = '\0';
                continue;
            }
            check = check | (1 << val);
        }
        for(int j = 0; j < str.length; j++){
            if(str[j] == '\0')
                continue;
            else
                System.out.print(str[j]);
        }
    }

    private static void getUniq(String input) {
        boolean[] charCounter = new boolean[256];

        for (char ch : input.toCharArray()) {
            if (!charCounter[ch]) {
                System.out.print(ch);
                charCounter[ch] = true;
            }
        }
    }






	public static void printArray (char[] s) {
		String a = "";
		for (char c : s) {
			a += c;
		}
		System.out.println(a);
	}


}