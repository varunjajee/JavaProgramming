package AlgosOnString;

/**
 * Created by mukthar.ahmed on 25/11/14.
 */
public class FindMaxOccurChar {

    public static void main(String[] args) {
        findMaxOccurChar("this is me here and now");

    }

    // Using javapack DSC:
    private static void findMaxOccurChar (String input) {
        System.out.println("+ Finding max occuring char by using java DSC.");
        char[] inChars = input.toCharArray();
        //int[] charCounter = new int[256];
        //int counter[256];
        int charCounter[] = new int [256];



        for (char c : inChars) {
            charCounter[c]++;
        }


        for (int i = 0; i < charCounter.length; i++ ) {
            System.out.println(charCounter[i] + " ");
        }

    }
}
