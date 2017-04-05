package com.muks.oopsandjava.concepts.threads.shutdownhook;

/**
 * Created by 300000511 on 25/01/17.
 */

public class ShutdownHookEg extends Thread {
    public static void main(String[] args)throws Exception {

        Runtime r=Runtime.getRuntime();

        r.addShutdownHook(new Thread(){
                              public void run(){
                                  System.out.println("shut down hook task completed..");
                              }
                          }
        );

        System.out.println("Now main sleeping... press ctrl+c to exit");
        try{Thread.sleep(3000);}catch (Exception e) {}
    }

}