package com.muks.headfirstjava.threads.concurrency.racebysemaphore;

import com.muks.headfirstjava.threads.concurrency.BankAccount;
import java.util.Random;
import java.util.concurrent.Semaphore;

/*
 * Created by mukthar.ahmed on 11/9/15.
 */
public class SemaphoreMikeAndMoly {
    private static BankAccount account = new BankAccount(200);

    // thread class
    static class BankingWithMikeAndMoly extends Thread {
        private static final int MAX_CONCURRENT_THREADS = 1;
        private static final Semaphore bankAdminLOCK = new Semaphore(MAX_CONCURRENT_THREADS, true);

        private ThreadLocal<Integer> TOTAL_WITHDRAWN = new ThreadLocal<>();

        @Override
        public void run() {
            TOTAL_WITHDRAWN.set(0);
            for (int i = 0; i < 60; i++) {
                startTransaction();
            }
        }

        public void startTransaction() {
            try {
                bankAdminLOCK.acquire();
                if(account.getAccountBalance() > 0) {
                    System.out.println("+++ " + Thread.currentThread().getName()
                            + " - is the user in" + " transaction.");

                    Random random = new Random();
                    int sleepTime = random.nextInt(500) + 510;
                    System.out.println("+ Zzzzz...... fallen asleep for - " + sleepTime + " secs.");
                    Thread.sleep(sleepTime);

                    System.out.println("+ Wake-up Call - "
                            + Thread.currentThread().getName() + " just WOKE UP...");


                    TOTAL_WITHDRAWN.set(TOTAL_WITHDRAWN.get() + account.withdrawal(10));
                    System.out.println("+ Total Withdrawal by " + Thread.currentThread().getName()
                            + " = " + TOTAL_WITHDRAWN.get());
                    System.out.println("+ Account Balance = " + account.getAccountBalance() + "\n");

                    bankAdminLOCK.release();
                    System.out.println(Thread.currentThread().getName() + "'s Transaction " +
                            "is successful...\n");

                } else {
                    System.out.println("+++ WARNING: Insufficient account balance....");
                    System.exit(0);

                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {

        BankingWithMikeAndMoly banking = new BankingWithMikeAndMoly();
        Thread mike = new Thread(banking);
        Thread molly = new Thread(banking);

        mike.setName("Mike");
        molly.setName("Molly");

        mike.start();
        molly.start();
    }

}
