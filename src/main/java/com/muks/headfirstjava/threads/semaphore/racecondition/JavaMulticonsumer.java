package com.muks.headfirstjava.threads.semaphore.racecondition;

import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/*
 * Race conditions occurs when two thread operate on same object without proper synchronization
 * and there operation interleaves on each other. Classical example of Race condition is
 * incrementing a counter since increment is not an atomic operation and can be further divided
 * into three steps like read, update and write. if two threads tries to increment count at same
 * time and if they read same value because of interleaving of read operation of one thread to
 * update operation of another thread, one count will be lost when one thread overwrite increment
  * done by other thread. atomic operations are not subject to race conditions because those
  * operation cannot be interleaved
  * Read more: http://javarevisited.blogspot.com/2012/02/what-is-race-condition-in.html#ixzz3qzVRW9gs

 */
public class JavaMulticonsumer {
    private static final int MAX_CONCURRENT_THREADS = 2;
    private final Semaphore crunchifyAdminLOCK = new Semaphore(MAX_CONCURRENT_THREADS, true);

    public class CrunchifyPerson extends Thread {
        public void run() {
            try {
                // aquire lock
                crunchifyAdminLOCK.acquire();

            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }

            System.out.println("Thread " + this.getId() + " is using crunchify's car - aquire()");
            try {
                sleep(ThreadLocalRandom.current().nextInt(5000), 10000+1);

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                crunchifyAdminLOCK.release();
                System.out.println("Thread " + this.getId() + " releases crunchify's car - " +
                        "release()\n");
            }

        }
    }

    public void crunchifyStartTest() {
        for (int i = 0; i < 10; i++) {
            CrunchifyPerson person = new CrunchifyPerson();
            person.start();
        }
    }

    public static void main(String[] args) {
        JavaMulticonsumer multiConsumer = new JavaMulticonsumer();
        multiConsumer.crunchifyStartTest();
    }
}
