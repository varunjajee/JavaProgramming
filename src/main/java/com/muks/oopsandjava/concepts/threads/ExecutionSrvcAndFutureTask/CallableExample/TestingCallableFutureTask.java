package com.muks.oopsandjava.concepts.threads.ExecutionSrvcAndFutureTask.CallableExample;

/*
 * Created by mukthar.ahmed on 2/1/16.
 */

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TestingCallableFutureTask {
    public static void main(String[] args) {
        FutureTask<String> callableEx = new FutureTask<>(new CallableWriter());
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        executorService.execute(callableEx);

        while (true) {      // recursively check if the threads are still running

            if (callableEx.isDone()) {
                try {
                    String returnValue = callableEx.get();
                    System.out.println("+ Callable Returns = \"" + returnValue + "\"");

                } catch (InterruptedException e) {
                    e.printStackTrace();

                } catch (ExecutionException e) {
                    e.printStackTrace();

                }

                executorService.shutdown();     // terminate
                break;
            }
        }
    }
}
