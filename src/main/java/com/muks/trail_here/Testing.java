package com.muks.trail_here;

class Testing {

//    public static void main(String[] args) {
//        int i = 0, j = 5;
//        tp: for (;;) {
//            i++;
//            for (; ; ) {
//                if (i > --j) {
//                    break tp;
//                }
//            }
//            //System.out.println("i =" + i + ", j = " + j);
//        }
//
//
//    }


    public static int x;
    public static int foo(int y)
    {
        return y * 2;
    }
    public static void main (String [] args)
    {
        int i1 = 5;
        int i2 = 6;
        String s1 = "7";
        System.out.println(i1 + i2 + s1); /* Line 8 */
    }

    class Super
    {
        public int i = 0;

        public Super(String text) /* Line 4 */
        {
            i = 1;
        }
    }
}