package com.muks.oopsandjava.concepts.threads.e_concurrency_nonblocking_algo.tests;

import com.muks.oopsandjava.concepts.threads.e_concurrency_nonblocking_algo.implementation.BlockingCounter;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by mukthar.ahmed on 4/4/16.
 * <p>
 * - Testing nonblocking counter
 */
public class TestNonblockingCounter implements Callable<Integer> {

    //ConcurrentCounter counter;
    BlockingCounter counter;

    //public TestNonblockingCounter(ConcurrentCounter threadCounter) {
    public TestNonblockingCounter(BlockingCounter threadCounter) {
        this.counter = threadCounter;
    }

    @Override
    public Integer call() throws Exception {
        //Thread.sleep(new Random().nextInt(500) + 500);

        int i = counter.incrementAndGet();

        return i;
    }
    /** ========== thread class ========== */




    public static void main(String args[]){
        final int THREADS = 10;
        //ConcurrentCounter nonblockingCounter = new ConcurrentCounter();   /** shared nonblocking counter*/
        BlockingCounter blockingCounter = new BlockingCounter();

        long startTime = System.currentTimeMillis();    /** Start time */


        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<Future<Integer>> futureTaskList = new ArrayList<>();


        for(int i=0; i< 10; i++){

            Future<Integer> future = executor.submit(new TestNonblockingCounter(blockingCounter));
            //Future<Integer> future = executor.submit(new TestNonblockingCounter(nonblockingCounter));
            futureTaskList.add(future);
        }


        // This will make the executor accept no new threads
        // and finish all existing threads in the queue
        executor.shutdown();

        // Wait until all threads are finish
        while (!executor.isTerminated()) {
        }

        /** Approach # 2 */
        try {
            if ( !executor.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("# Still waiting for thread completion.");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        List<Integer> resList = new ArrayList<>();
        for (Future<Integer> workerTask : futureTaskList) {
            try {
                resList.add(workerTask.get());
                System.out.println("+ Worked picked Int: " + workerTask.get() );
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (futureTaskList.size() != resList.size() ) {
            System.out.println("Test Results = Fail");
        } else {
            System.out.println("Test Results = Pass");
        }

        System.err.println("DONE, Time: "
            + (System.currentTimeMillis() - startTime));
    }

}
