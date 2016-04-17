package com.muks.IntrvAlgorithms.HackerRank;

/**
 * Created by mukthar.ahmed on 4/16/16.
 */
public class ChoclatesAndWrappers {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//
//        Scanner scan = new Scanner(System.in);
//        String tests = scan.nextLine();
//
//        String[] inputset = new String[Integer.parseInt(tests)];
//        for (int i = 0; i < Integer.parseInt(tests); i++) {
//            String str = scan.nextLine();
//            inputset[i] = str;
//        }
//
//        for (String str : inputset) {
//            System.out.println(str);
//        }
//        System.exit(0);
//
//
//        System.out.println("# Total: " + tests);
//        String myLine = scan.nextLine();
//        String[] inArgs = myLine.split(" " );


//        BigInteger N = new BigInteger("6");
//        BigInteger C = new BigInteger("2");
//        BigInteger M = new BigInteger("2");

//        System.out.println("# N: " + N + ", C = " + C + ", M = " + M);
//
//        BigInteger totalBuyable = N.divide(C);
//        System.out.println("@ total buy'd = " + totalBuyable.toString());
//
//
//        while (true) {
//            BigInteger[] free = totalBuyable.divideAndRemainder(M);
//
//
//        }


//
//        int additionalFree = Integer.parseInt(free[0].toString());   // getting quotient
//        int totalBuyd = Integer.parseInt(totalBuyable.toString());
//
//        System.out.println("# Quotient = " + free[0] + ", Remainder: " + free[1]);
//
//        System.out.println("Final = " + (totalBuyd + additionalFree) );


        int wraps = 6/2;
        int totalEaten = wraps;

        int wrapperDiscount = 2;
        while (wraps >= wrapperDiscount){
            int newlyEaten = wraps/wrapperDiscount;

            totalEaten += newlyEaten;    /** add up to the total totalEaten */

            wraps %= wrapperDiscount;   /** remaining wraps */

            wraps += newlyEaten;        /** wraps out of newly eaten ones */
        }


        System.out.println("# totalEaten = " + totalEaten);

    }
}


