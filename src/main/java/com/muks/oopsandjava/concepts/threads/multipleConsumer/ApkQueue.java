package com.muks.oopsandjava.concepts.threads.multipleConsumer;

import java.util.concurrent.Semaphore;

/*
 * Created by mukthar.ahmed on 2/3/16.
 */
public class ApkQueue {
    private String[] myPackages;
    public int index = 0;
    public int capacity;

    // Start with consumer prodconsumerproblem unavailable
    static Semaphore semCon = new Semaphore(1);

    public ApkQueue(String[] inputPackages) {
        capacity = inputPackages.length;
        myPackages = new String[inputPackages.length];

        for (int i = 0; i < inputPackages.length; i++) {
            myPackages[i] = inputPackages[i];
        }

        System.out.println("+ Initialized your APK queue with - " + this.toString() );
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        for (String str : myPackages) {
            sb.append(str + ", ");
        }
        sb.append(")");

        return sb.toString();
    }

    public void take() {
        try {
            semCon.acquire();

            System.out.println("+ Value = " + myPackages[index]);
            index++;
            semCon.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
