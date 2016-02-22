package com.muks.designpatterns.creational.ObjectPoolPattern;

/*
 * Created by mukthar.ahmed on 12/28/15.
 */
public class ExportingProcess {
    private long processNo;

    public ExportingProcess(long processNo)  {
        this.processNo = processNo;
        // do some  expensive calls / tasks here in future
        // .........
        System.out.println("Object with process no. " + processNo + " was created");
    }

    public long getProcessNo() {
        return processNo;
    }
}
