package com.muks.oopsandjava.concepts.a_BigIntegerEg;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Created by mukthar.ahmed on 3/26/16.
 */
public class MathBigIntegers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        List<BigDecimal> arr = new ArrayList<>();

        while (in.hasNext()) {
            if (in.hasNextInt()) {
                arr.add(BigDecimal.valueOf(in.nextInt()));
            } else if (in.hasNextDouble()) {
                arr.add(BigDecimal.valueOf(in.nextDouble()));

            } else if (in.nextLine().equals("exit")) {
                break;
            }
        }
        in.close();

        Collections.sort(arr, Collections.reverseOrder());

        for (BigDecimal D : arr) {
            System.out.println(D.toString());
        }
    }
}
