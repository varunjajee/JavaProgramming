package com.muks.oopsandjava.concepts.asserts;

/**
 * Created by mukthar.ahmed on 12/22/15.
 */
public class AssertionExamples {

    /*
     Invalid case as assertion is used like a ternary operator (Invalid)
    int x = 0;
    assert (x > 0) ? "assertion failed" : "assertion passed" ;  // (Invalid error line)
    System.out.println("finished");



    Assertion rules:
        1. Assertions cannot be used like ternary operators
        2. If assert - fails / false then the program doesn't proceed to next line
            Eg:
                while(true) {
                    assert false;
                    break;
                }
                assert false;   // this line is not reachable

        3.
            3.1. It is never appropriate to write code to handle failure of an assert statement.
            3.2. Assertion checking is typically enabled during program development and testing.
            3.3. Assertion checking can be selectively enabled or disabled on both a per-package
                 basis and a per-class basis.

        4. Method returning void cannot NOT be used in asserts
            Eg:
                public class Test {

                  public static int y;


                  public static void foo(int x) { this method CANNOT be used in asserts
                      System.out.print("foo ");
                      y = x;
                  }

                   public static int bar(int z) {
                      System.out.print("bar ");
                      return y = z;
                  }

                    public static void main(String [] args ) {
                      int t = 0;
                      assert t > 0 : bar(7);
                      assert t > 1 : foo(8); /* Line 18 */
//                    System.out.println("done ");
//                  }
//              }

     //*/
}
