package com.muks.trail_here;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Testing {

    public static void main(String[] args) {
        TestBlockingQueue prodQ = new TestBlockingQueue();

        Runnable prod = new Prod(prodQ);
        Runnable cons = new Cons(prodQ);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.submit(prod);
        executorService.submit(cons);

        executorService.shutdown();
    }


    static class Prod implements Runnable {
        private TestBlockingQueue prodQ;

        Prod(TestBlockingQueue q) {
            this.prodQ = q;
        }

        @Override
        public void run() {
            for (int i = 0; i <= 20; i++) {
                prodQ.put(i);
            }
            return;
        }
    }

    static class Cons implements Runnable {
        TestBlockingQueue prodQ;

        Cons(TestBlockingQueue q) {
            this.prodQ = q;
        }

        @Override
        public void run() {
            for (int i = 0; i <=20; i++) {
                System.out.println(prodQ.get());
            }
        }
    }
}