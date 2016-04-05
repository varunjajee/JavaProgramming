package com.muks.trail_here;



class Testing {
    static {
        System.out.println("+ static initializer");
    }

    {
        System.out.println("# non-static init");
    }

    Testing() {
        System.out.println("# Constructor");
    }

    public static void main(String[] args) {
        Testing t1 = new Testing();
        System.out.println("");

        Testing t2 = new Testing();
        System.out.println("");

        Testing t3 = new Testing();
    }

}