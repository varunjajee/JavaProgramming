package com.muks.trail_here;


class Testing {

    static class staticInner {
        staticInner() {
            System.out.println("\n# Static inner class");
        }

        public void myMethod() { System.out.println("myMethod()"); }
    }

    public void voice() {
        System.out.println("bhow-bhow...");
    }

    class NonStaticInnerClass {
        NonStaticInnerClass() {
            System.out.println("# non-static inner class");
        }


    }


    public static void main(String[] args) {
        Testing.staticInner staticClass = new Testing.staticInner();
        staticClass.myMethod();

        Testing testing = new Testing();
        NonStaticInnerClass abc = testing.new NonStaticInnerClass();


        Testing testing1 = new Testing() {
            public void bark() {
                System.out.println("# Meeo...");
            }
        };


    }


}