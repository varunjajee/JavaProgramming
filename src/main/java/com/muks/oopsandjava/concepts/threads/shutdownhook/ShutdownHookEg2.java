package com.muks.oopsandjava.concepts.threads.shutdownhook;

/**
 * Created by 300000511 on 25/01/17.
 */
public class ShutdownHookEg2 {


    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new ShutdownManager());
    }

    /** Custom Shutdown manager */
    private static class ShutdownManager extends Thread {

        public void run() {
            System.out.println("# Shutting down the JVM");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
