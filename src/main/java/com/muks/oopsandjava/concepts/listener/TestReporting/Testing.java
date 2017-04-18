package com.muks.oopsandjava.concepts.listener.TestReporting;


/**
 * Created by 300000511 on 15/04/17
 *  - Testing class
 */

public class Testing {
    public static void main(String[] args) {
        SubjectBroker subjectBroker = new SubjectBroker();

        new TestLoggingObserver(subjectBroker);

        subjectBroker.setState(15);
        subjectBroker.setState(10);
    }
}
