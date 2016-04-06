package com.muks.oopsandjava.concepts.threads.a_runnable_callable_threads;

import com.muks.oopsandjava.concepts.threads.blocking_nonblocking_algo.implementation.ConcurrentCounter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by mukthar.ahmed on 4/6/16.
 * <p>
 * - Callable example
 */

public class CallableEg implements Callable {
    ThreadLocal<String> name =  new ThreadLocal<>();
    ConcurrentCounter count;

    CallableEg(String name, ConcurrentCounter counter) {
        this.name.set(name);
        this.count = counter;
    }

    @Override
    public Integer call() throws Exception {
        return count.incrementAndGet();
    }


    public static void main(String[] args) {
        ConcurrentCounter counter = new ConcurrentCounter();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future> listOfThreads = new ArrayList<>();

        for (int i = 1; i <= 10; i++) {
            Callable callable = new CallableEg("muks-" + i, counter);
            Future<Integer> submittedFuture = executorService.submit(callable);
            listOfThreads.add(submittedFuture);
        }

        executorService.shutdown();

//        while ( executorService.isTerminated()) {
//            System.out.println("# Not yet.");
//        }
//        try {
//            if ( !executorService.awaitTermination(10, TimeUnit.SECONDS)) {
//                System.out.println("# Still waiting for thread completion.");
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        for (Future<Integer> task : listOfThreads) {
            if (task.isDone()) {
                try {
                    System.out.println("# Name: " + task.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
                break;
            }
        }



        for (Future<Integer> workerTask : listOfThreads) {
            try {

                System.out.println("+ Worked picked Int: " + workerTask.get() );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
