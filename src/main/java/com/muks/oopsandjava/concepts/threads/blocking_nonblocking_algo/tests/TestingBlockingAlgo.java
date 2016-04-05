package com.muks.oopsandjava.concepts.threads.blocking_nonblocking_algo.tests;

import com.muks.oopsandjava.concepts.threads.blocking_nonblocking_algo.implementation.ConcurrentCounter;
import com.muks.oopsandjava.concepts.threads.blocking_nonblocking_algo.implementation.BlockingCounter;

/**
 * Created by mukthar.ahmed on 4/4/16.
 */
public class TestingBlockingAlgo {
    public static void main(String[] args) {
        //blockingCounterTest();

    }


    public static void blockingCounterTest() {
        BlockingCounter blockingCounter = new BlockingCounter();
        System.out.println("# Initial value = " + blockingCounter.getValue());

        System.out.printf("# Incremented value = " + blockingCounter.incrementAndGet());
    }

    public static void nonBlockingCounterTest(){
        ConcurrentCounter concurrentCounter = new ConcurrentCounter();

    }
}
