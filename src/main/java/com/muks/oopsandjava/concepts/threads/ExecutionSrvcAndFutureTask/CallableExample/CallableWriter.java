package com.muks.oopsandjava.concepts.threads.ExecutionSrvcAndFutureTask.CallableExample;

import java.util.concurrent.Callable;

/*
 * Created by mukthar.ahmed on 2/1/16.
 */
public class CallableWriter implements Callable<String> {


    @Override
    public String call() throws Exception {
        return "CallableWriter: Example Thread, returning String value.";
    }
}
