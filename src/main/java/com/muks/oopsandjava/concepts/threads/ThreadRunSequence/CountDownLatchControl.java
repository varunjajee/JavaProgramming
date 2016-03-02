package com.muks.oopsandjava.concepts.threads.ThreadRunSequence;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by mukthar.ahmed on 3/2/16.

 How to control the sequence of workers execution & wait till the previous worker is completed ?
    - Controlling the sequence of workers is possible by using CountDownLatch()
    - CountDownLatch() - takes an int arguement and when the int becomes 0 / zero, it communicates that its completed

 */
public class CountDownLatchControl {
    static final CountDownLatch cdl1 = new CountDownLatch(1);
    static final CountDownLatch cdl2 = new CountDownLatch(1);
    static final CountDownLatch cdl3 = new CountDownLatch(1);


    public static void main(String[] args) {
        List<Runnable> threadList = new ArrayList<>();

        threadList.add(new Runnable1());
        threadList.add(new Runnable2());
        threadList.add(new Runnable3());

        ExecutorService executorService = Executors.newFixedThreadPool(30);
        for (int i = 0; i < 3; i++) {
            executorService.submit(threadList.get(i));  // submit thread by thread.

            //executorService.invokeAll(Collection<>);  To submit all callable threads at once
        }
        executorService.shutdown();
    }


    static class Runnable1 implements Runnable {
        public void run() {
            System.out.println(Thread.currentThread().getName() + ", is running....");

            RandomThreadWait();

            cdl1.countDown();   /** Decrements the count of the latch, releasing all waiting threads if
             * the count reaches zero.*/
        }
    }

    static class Runnable2 implements Runnable {
        public void run() {

            try {
                cdl1.await();
                System.out.println(Thread.currentThread().getName() + " is running....");

                RandomThreadWait();

                cdl2.countDown();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Runnable3 implements Runnable {
        public void run() {

            try {
                cdl2.await();
                System.out.println(Thread.currentThread().getName() + " is running....");

                RandomThreadWait();

                cdl3.countDown();   // This informs that task/thread # 3 is finished
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    /** Random wait method for threads */
    public static void RandomThreadWait() {
        try {
            Thread.sleep(new Random().nextInt(500) + 500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
