package com.muks.oopsandjava.concepts.listener.TestReporting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 300000511 on 15/04/17.
 *      - SubjectBroker clas which maintains reportingObservers and states along with methods to notifyAll
 */
public class SubjectBroker {
    private List<TestReportingObserver> reportingObservers = new ArrayList<>();
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    public void regiesterObserver(TestReportingObserver observer){
        reportingObservers.add(observer);
    }

    public void unregisterObserver(TestReportingObserver observer){
        reportingObservers.remove(observer);
    }

    public void notifyAllObservers(){
        for (TestReportingObserver testReportingObserver : reportingObservers) {
            testReportingObserver.update();
        }
    }
}
