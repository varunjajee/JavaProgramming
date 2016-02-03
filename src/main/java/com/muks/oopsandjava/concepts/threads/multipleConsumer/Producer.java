package com.muks.oopsandjava.concepts.threads.multipleConsumer;

/*
 * Created by mukthar.ahmed on 2/3/16.
 */
public class Producer {

    public ApkQueue publishData() {
        String[] apkList = {"one", "two", "three", "four"};
        ApkQueue apkQueue = new ApkQueue(apkList);
        //System.out.println("+ init() : " + apkQueue.toString());

        return apkQueue;
    }

    public static void main(String[] args) {
        Producer producer = new Producer();
        producer.publishData();
    }
}
