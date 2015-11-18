package com.muks.javaexamples.concepts.passbyvalue;

/* Java is always - pass-by-value
 * http://javarevisited.blogspot.in/2012/12/does-java-pass-by-value-or-pass-by-reference.html
 */
public class PassByRefConfusion {

    public static void main(String args[]) {
        Car car = new Car("BMW");
        System.out.println("Brand of Car Inside main() before: "+ car.brand);
        printBrand(car);
        System.out.println("Brand of Car Inside main()after: "+ car.brand);
    }

    public static void printBrand(Car car){
        car.brand = "Maruti";
        System.out.println("Brand of Car Inside printBrand(): "+car.brand);
    }

    private static class Car {
        private String brand;

        public Car(String brand){
            this.brand = brand;
        }

    }


    public static class PassByValueExample {

        public static void receiving (int var) {
            var = var + 2;
            System.out.println("+ From \"receiving()\": " + var);
        }


        public static void main(String [] args) {
            int passing = 3;

            receiving(passing);

            System.out.println("The value of passing is: " + passing);
        }
    }
}
