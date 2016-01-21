package com.muks.oopsandjava.concepts.threads.misc;

/*
 * Example showing how the Thread scheduler alternatively allocates threads execution.
 */

public class ThreadsAlternator implements Runnable {
    public static void main(String[] args) {
        ThreadsAlternator threadsAlternator = new ThreadsAlternator();
        Thread alpha = new Thread(threadsAlternator);
        Thread beta = new Thread(threadsAlternator);

        alpha.setName("Alpha");
        beta.setName("Beta");

        alpha.start();
        beta.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println("+ Thread running is - " + threadName);
        }
    }
}
