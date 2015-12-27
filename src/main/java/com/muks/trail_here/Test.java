package com.muks.trail_here;

/**
 * Created by mukthar.ahmed on 12/22/15.
 */


public class Test extends Thread {
    final static short x = 2;
    public static int y = 0;
    public static void main(String [] args)
    {


        for (int z=0; z < 3; z++)
        {
            switch (z)
            {
                //case y: System.out.print("0 ");   /* Line 11 */
                case x-1: System.out.print("1 "); /* Line 12 */
                case x: System.out.print("2 ");   /* Line 13 */
            }
        }
    }
    public void run()
    {
        for(int i = 0; i < 3; ++i)
        {
            System.out.print(i + "..");
        }
    }
}
