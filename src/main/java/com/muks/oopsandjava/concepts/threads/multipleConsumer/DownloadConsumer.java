package com.muks.oopsandjava.concepts.threads.multipleConsumer;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 * Created by mukthar.ahmed on 2/3/16.
 */
public class DownloadConsumer implements Runnable {
    public ApkQueue apkQueue;

    public DownloadConsumer(ApkQueue myQueue) {
        this.apkQueue = myQueue;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        long waitTime = new Random().nextInt((1000 - 500) + 1) + 500;

        System.out.println(threadName + ", entered and is waiting for \"" + waitTime + "\" before" +
                " consumption.");

        try {
            Thread.sleep(waitTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (apkQueue.index < apkQueue.capacity) {
            System.out.println("+ Thread-Name: " + Thread.currentThread().getName() +" is taking");
            apkQueue.take();
        }
    }




    public static void main(String[] args) {
        Producer producer = new Producer();
        ApkQueue myApkList = producer.publishData();

        DownloadConsumer downloadConsumer = new DownloadConsumer(myApkList);
        Thread thread1 = new Thread(downloadConsumer);
        Thread thread2 = new Thread(downloadConsumer);
        thread1.setName("Thread-1");
        thread2.setName("Thread-2");

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(thread1);
        executorService.execute(thread2);

        executorService.shutdown();     // showdown all worker threads
    }
}
