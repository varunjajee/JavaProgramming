package com.muks.oopsandjava.concepts.listener.TestReporting;

import com.muks.oopsandjava.concepts.listener.eg2.Subject;

/**
 * Created by 300000511 on 15/04/17
 *  - Test reporting observer class`
 */
public abstract class TestReportingObserver {
    protected SubjectBroker subjectBroker;
    public abstract void update();
}
