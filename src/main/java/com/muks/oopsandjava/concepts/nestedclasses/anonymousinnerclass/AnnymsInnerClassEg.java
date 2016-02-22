package com.muks.oopsandjava.concepts.nestedclasses.anonymousinnerclass;

/*
 * Created by mukthar.ahmed on 11/23/15.
 */
public class AnnymsInnerClassEg {
    //
    interface Eatable {
        void eat();
    }

    static class TestAnnonymousInner1 {
        public static void main(String args[]) {

            // Eg of anonymous inner class
            Eatable e = new Eatable() {
                public void eat() {
                    System.out.println("nice fruits");
                }
            };
            e.eat();    // class eat method of anonymous class
        }
    }
}
