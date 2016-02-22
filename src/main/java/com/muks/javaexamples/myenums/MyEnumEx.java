package com.muks.javaexamples.myenums;

/**
 * Created by mukthar.ahmed on 1/1/16.
 */
public class MyEnumEx {

    // If you want to have string constraints
    private enum Weekdays {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
    }

    private enum Status {
        ACTIVE(0),
        PAUSED(1),
        PENDING(2);

        private int statusID;
        private String status;

        private Status(int id) {
            this.statusID = id;
        }

        private Status(String status) {
            this.status = status;
        }

        public static Status findByValue(int statusValue) {
            for (Status mapping : Status.values()) {
                System.out.println("+ Search with => mapping.statusID: " + mapping.statusID);
                if (mapping.statusID == statusValue) {
                    System.out.println("+ Found mapping, return the value");
                    return mapping;
                }
            }
            return null;
        }   //

        public static int findByOrdinal(String status) {
            for (Status mapping : Status.values()) {
                System.out.println("+ Search with => mapping.status: " + mapping.name());

                if (mapping.name().equalsIgnoreCase(status)) {
                    System.out.println("+ Found mapping, return the value");
                    return mapping.ordinal();
                }
            }
            return 0;
        }   //
    }




    // main()
    public static void main(String args[]) {

        // This kind of enum mapping is used to make sure string consistency is maintained
        System.out.printf("\n+ String consistency eg. (Friday): %s%n%n", Weekdays.FRIDAY);


        // Print all enum values
        Status[] drinks = Status.values();
        for (Status drink : drinks) {
            System.out.printf("String to Enum example using name : %s%n", drink.name());
        }

        int idLookup = 2;
        System.out.printf("\n+ Status with ID - " + idLookup + " = " +
                Status.findByValue(idLookup) );

        String statusLookup = "PAUSED";
        System.out.println("\n+ By Ordinal: " + Status.findByOrdinal(statusLookup));

    }

}
