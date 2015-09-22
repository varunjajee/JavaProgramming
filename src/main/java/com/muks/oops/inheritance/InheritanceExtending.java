package com.muks.oops.inheritance;

/**
 * Created by mukthar.ahmed on 17/09/15.

    Note:
        Java DOES NOT support multiple inheritance.

 */
public class InheritanceExtending {

    // "extends" is to extend an class and "implements" is used to implement a "interface"
    public class FamilyDoctor extends Doctor {
        boolean makesHouseVisits;

        void givesFamilyHealthAdvice() {

        }
    }

    public class Surgeon extends Doctor {
        boolean heartSurgeon;
        boolean generalSurgeon;

        public void surgeonDetails() {
            super.worksAtHospital = true;
        }
    }

    public class HeartSurgeon extends Surgeon {


    }

    public class generalPhysician {
        public void Foo() {
            Doctor doctor = new Doctor();
            doctor.worksAtHospital = false;
        }

    }

}
