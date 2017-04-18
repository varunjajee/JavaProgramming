package com.muks.oopsandjava.concepts.listener.TestReporting;

/**
 * Created by 300000511 on 15/04/17
 *  -
 */
public class TestLoggingObserver extends TestReportingObserver {

    public TestLoggingObserver(SubjectBroker subjectBroker){
        this.subjectBroker = subjectBroker;
        this.subjectBroker.regiesterObserver(this);
    }

    @Override
    public void update() {
        System.out.println( "(Logger): " + subjectBroker.getState() );
    }
}
