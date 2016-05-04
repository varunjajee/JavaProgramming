package com.muks.oopsandjava.concepts.threads;

import com.muks.oopsandjava.concepts.threads.e_concurrency_nonblocking_algo.implementation.ConcurrentCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by mukthar.ahmed on 5/4/16.
 */
public class TryHere {

    static class MyCallable implements Callable {
        ConcurrentCounter counter;
        ThreadLocal<String> name = new ThreadLocal<>();

        public MyCallable(String name, ConcurrentCounter counter) {
            this.counter = counter;
            this.name.set(name);
        }

        @Override
        public Integer call() throws Exception {
            int val = counter.incrementAndGet();
            System.out.println("Name: " + this.name.get() + ", Value: " + val);
            return val;
        }
    }

    public static void main(String[] args) {
        ConcurrentCounter counter = new ConcurrentCounter();

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        List<Future> futureList = new ArrayList<>();

        for (int i = 0; i <= 10; i++) {

            Callable MyCallable = new MyCallable("Muks-" + i, counter);

            Future future = executorService.submit(MyCallable);
            futureList.add(future);
        }


        executorService.shutdown();

        for (Future future : futureList) {
            if (future.isDone()) {
                try {
                    System.out.println(future.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
