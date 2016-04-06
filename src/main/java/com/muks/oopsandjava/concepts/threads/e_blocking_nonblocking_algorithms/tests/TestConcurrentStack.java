package com.muks.oopsandjava.concepts.threads.e_blocking_nonblocking_algorithms.tests;

import com.muks.oopsandjava.concepts.threads.e_blocking_nonblocking_algorithms.implementation.ConcurrentStack;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by mukthar.ahmed on 4/4/16.
 * - Test class
 */
public class TestConcurrentStack implements Runnable {
    ConcurrentStack<Integer> cStack;
    private int value;
    private boolean run = true;

    public TestConcurrentStack(ConcurrentStack<Integer> conStack, int in) {
        this.cStack = conStack;
        this.value = in;
    }


    @Override
    public void run() {
        System.out.println("# Value = "+ value);
        cStack.push(value);
    }


    public static void main(String[] args) {

        List<Future<?>> tasklist = new ArrayList<>();

        ConcurrentStack<Integer> concurrentStack = new ConcurrentStack<>();
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for (int i = 0; i <= 50; i++) {
            TestConcurrentStack task = new TestConcurrentStack(concurrentStack, i);

            Future<?> ftask = executor.submit(task);
            tasklist.add(ftask);

        }

        //shut down the executor service so that this thread can exit
        executor.shutdownNow();

        // wait for all tasks to complete before continuing
        for (Future<?> f : tasklist) {
            /** To check if all threads are completed */
            while (true) {
                if (f.isDone()) {
                    break;
                }
            }

            /** Even try block works - To check if all threads are completed */
//            try {
//                f.isDone();
//            } catch (Exception e) {
//                e.printStackTrace();
//
//            }
        }



        concurrentStack.toPrint();

    }
}
