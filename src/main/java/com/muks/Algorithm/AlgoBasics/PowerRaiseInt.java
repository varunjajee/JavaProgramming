package com.muks.Algorithm.AlgoBasics;

/**
 * Calculate power - http://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
 */
public class PowerRaiseInt {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int x = 2;
        int y = -4;
        //System.out.println(power(x, y));

        try {
            System.out.println(powerOptimised(x, y));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static float power(float x, int y) {

        float temp;

        // base case for recurssion
        if (y == 0) {
            return 1;
        }

        temp = power(x, y / 2);

        if (y % 2 == 0) {
            return temp * temp;

        } else {
            if (y > 0) {
                System.out.println("+ Power: " + y + " Temp: " + temp);
                return x * temp * temp;

            } else {
                System.out.println("+ Power(< 0): " + y + " Temp: " + temp);
                return (temp * temp) / x;
            }

        }
    }

    

    public static int powerOptimised(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("n and p should be non-negative");
        }
        else {
            return pow(n, p);
        }
    }

    public static int pow(int m, int n) {
        if (n <= 0) {
            return 1;
        } else if (n == 1) {
            return m;
        }

        int rem = n & 1;
        n >>= 1;

        if (rem == 0) {
            return pow(m * m, n);      // x^(2n) = (x^2)^n
        } else {
            return m * pow(m * m, n);  // x^(2n+1) = x * ((x^2)^n)
        }
    }

}




