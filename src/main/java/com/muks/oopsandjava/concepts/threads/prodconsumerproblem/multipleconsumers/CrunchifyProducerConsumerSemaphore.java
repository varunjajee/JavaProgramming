package com.muks.oopsandjava.concepts.threads.prodconsumerproblem.multipleconsumers;

import java.util.LinkedList;
import java.util.concurrent.Semaphore;

/**
 * Created by mukthar.ahmed on 11/9/15.
 */
public class CrunchifyProducerConsumerSemaphore {
    static Object crunchifyLock = new Object();
    static LinkedList<String> crunchifyList = new LinkedList<String>();

    // Semaphore maintains a set of permits.
    // Each acquire blocks if necessary until a permit is available, and then takes it.
    // Each release adds a permit, potentially releasing a blocking acquirer.
    static Semaphore producerSemaphore = new Semaphore(1);
    static Semaphore consumerSemaphore = new Semaphore(0);


    // I'll producing new Integer every time
    static class CrunchifyProducer extends Thread {
        public void run() {
            int counter = 1;
            try {
                while (true) {
                    producerSemaphore.acquire();
                    String threadName = Thread.currentThread().getName() + "-" + counter++;
                    crunchifyList.add(threadName);
                    System.out.println("Producer is producing new value : " + threadName);
                    producerSemaphore.release();

                    consumerSemaphore.release();
                    Thread.sleep(10000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }   // end producer class


    static class CrunchifyConsumer extends Thread {
        String consumerName;

        public CrunchifyConsumer (String threadName) {
            this.consumerName = threadName;
        }

        public void run() {
            try {
                while(true) {
                    consumerSemaphore.acquire();
                    StringBuilder result = new StringBuilder();
                    for (String value : crunchifyList) {
                        result.append(value + ",");
                    }

                    System.out.println("\n" + consumerName + " is consuming values = \"" + result +
                            "\" " + "with crunchifyList size = " + crunchifyList.size());
                    Thread.sleep(5000);
                    consumerSemaphore.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }   // end consumer class


    public static void main(String[] args) {
        new CrunchifyProducer().start();
        new CrunchifyConsumer("Crunchify").start();
        new CrunchifyConsumer("Google").start();
        new CrunchifyConsumer("Yahoo").start();
    }

}
