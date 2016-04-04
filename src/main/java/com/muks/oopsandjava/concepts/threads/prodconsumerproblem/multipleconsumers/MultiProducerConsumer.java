package com.muks.oopsandjava.concepts.threads.prodconsumerproblem.multipleconsumers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by mukthar.ahmed on 3/2/16.
 */
public class MultiProducerConsumer {

    class ProductQueue {
        Queue<Integer> myQ = new LinkedList<>();

        private Semaphore semProd = new Semaphore(5);       /** 5 producers */
        private Semaphore semCon = new Semaphore(2);        /** 2 consumers */

        public void put(int val) {
            try {
                semProd.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //TestingBlockingAlgo.ThreadSleep();

            //item = val;
            myQ.add(val);
            System.out.println("+ Producing - " + val);
            semCon.release();
        }

        public void get() {
            try {
                semCon.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            MultiProducerConsumer.ThreadSleep();
            int qItem = myQ.remove();
            System.out.println("+ [Consuming] = " + qItem);
            semProd.release();
        }
    }


    class Producer implements Runnable {
        ProductQueue myQueue;

        public Producer(ProductQueue q) {
            this.myQueue = q;
        }

        public void run() {
            for (int i = 1; i <= 20; i++) {
                myQueue.put(i);
            }
        }
    }


    class Consumer implements Runnable {
        ProductQueue myQueue;

        public Consumer(ProductQueue q) {
            this.myQueue = q;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 20; i++) {
                myQueue.get();
            }
        }
    }


    public void runProducerConsumer() {
        ProductQueue mQ = new ProductQueue();
        Producer producer = new Producer(mQ);
        Consumer consumer = new Consumer(mQ);

        ExecutorService execService = Executors.newFixedThreadPool(10);
        execService.submit(producer);
        execService.submit(consumer);

        if (!execService.isShutdown()) {
            execService.shutdown();
        }
    }

    public static void main(String[] args) {
        MultiProducerConsumer multiProdCon = new MultiProducerConsumer();
        multiProdCon.runProducerConsumer();
    }

    /** Thread sleep method */
    private static void ThreadSleep() {
        int rand = new Random().nextInt(1500) + 2000;

        try {
            Thread.sleep(rand);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
