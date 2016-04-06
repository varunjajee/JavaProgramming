package com.muks.trail_here;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * Created by mukthar.ahmed on 4/6/16.
 */
public class TestBlockingQueue {
    private Queue<Integer> sharedQ = new LinkedList<>();

    private Semaphore prodSema = new Semaphore(1);
    private Semaphore consSema = new Semaphore(0);

//    public void put(int item) {
//        try {
//            prodSema.acquire();
//
//            sharedQ.offer(item);
//
//            consSema.release();
//
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//    }

    public synchronized void put(int item) {
        sharedQ.offer(item);
    }


    public synchronized  int get() {
        return sharedQ.poll();
    }
}
