//package oops;
//
//import java.util.HashMap;
//import java.util.concurrent.Callable;
//
///**
// * Created by mukthar.ahmed on 14/10/14.
// */
//public class CallableTask2 implements Callable<HashMap<String, String>> {
//
//    static String var;
//    @Override
//    public HashMap<String, String> call() throws Exception {
//        HashMap<String, String> s2 = new HashMap<>();
//        s2.put("key", var);
//        return s2;
//    }
//
//    protected static void setArg(String a) {
//        var = a;
//    }
//
//}
//
//
//
///*
//
//public class CallableTask implements Callable<String> {
//
//    @Override
//    public String call() throws Exception {
//        String s="Callable Task Run at "+System.currentTimeMillis();
//        return s;
//    }
//
//}
//
// */
