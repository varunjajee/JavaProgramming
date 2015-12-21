//package oops;
//
//import java.util.HashMap;
//import java.util.concurrent.*;
//
///**
// * Created by mukthar.ahmed on 14/10/14.
// */
//public class CallableClient {
//
//    /**
//     * @param args
//     */
//    public static void main(String[] args) {
//
//        // Step1 : Create a Runnable
//        Callable callableTask = new CallableTask();
//        Callable<HashMap<String, String>> callableTask2 = new CallableTask2();
//
//        //CallableTask2.setArg("mukthar");
//        CallableTask2.var = "mukthar";
//
//        // Step 2: Configure Executor
//        // Uses FixedThreadPool executor
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//        Future<String> future1 = executor.submit(callableTask);
//        Future<HashMap<String, String>> future2 = executor.submit(callableTask2);
//
//        String results1 = null;
//        HashMap<String, String> results2 = new HashMap<String, String>();
////        String results2 = null;
//        boolean listen = true;
//
//        long startTime = System.currentTimeMillis();
//
//        while (listen) {
//
//            if (future1.isDone() && future2.isDone()) {
//                try {
//                    results1 = future1.get();
//                    results2 = future2.get();
//                    System.out.println(results1);
//                    System.out.println(results2.toString());
//                    listen = false;
//                } catch (InterruptedException | ExecutionException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//
//            }
//
//        }
//
//        long endTime = System.currentTimeMillis();
//        long totalTime = endTime - startTime;
//        System.out.println(totalTime);
//
//
//    }
//
//}
