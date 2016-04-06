package com.muks.oopsandjava.concepts.threads.b_ExecutionSrvcAndFutureTask.RunnableExample;

/*
 * Created by mukthar.ahmed on 2/1/16.
 */


public class RunnablePrintWorker implements Runnable {
    private final String name;
    private final int delay;

    public RunnablePrintWorker(String name, int delay) {
        this.name = name;
        this.delay = delay;
    }

    public void run() {
        System.out.println("Starting: " + name);
        try {
            Thread.sleep(delay);

        } catch (InterruptedException ignored) {
            ignored.printStackTrace();
        }
        System.out.println("Done with: " + name);
    }

}

//
//    Read more: http://mrbool.com/working-with-java-executor-framework-in-multithreaded-application/27560#ixzz3yu4h4KgV
//
