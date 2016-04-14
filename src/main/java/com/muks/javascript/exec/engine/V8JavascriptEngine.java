package com.muks.javascript.exec.engine;

import javax.script.*;
import java.io.File;
import java.io.FileReader;
import java.io.Reader;

/**
 * Hello world!
 *
 */
public class V8JavascriptEngine {


    //    public static void main(String[] args) {
    //        V8 v8 = V8.createV8Runtime();
    //        v8.executeScript("<script src=\\\"mraid.js\\\"></script><script language='Javascript1.1' "
    //            + "SRC=\\\"https:\\/\\/pixel.adsafeprotected"
    //            + ".com\\/rjss\\/st\\/39226\\/5024613\\/skeleton.js\\\"><\\/script>");
    ////        v8.registerJavaMethod(new Printer(), "print", "print", new Class<?>[]{String.class});
    ////        v8.executeVoidScript( "print('Hello, World!');" );
    //        v8.release(true);

    //
    //        //ScriptEngine engine = new ScriptEngineManager(null).getEngineByName("nashorn");
    //        ScriptEngineManager manager = new ScriptEngineManager();
    //
    //        TestingBlockingAlgo {
    //      engine.eval("print('Hello World!');");
    //        } catch (ScriptException e) {
    //            e.printStackTrace();
    //        }
    //
    //
    //        TestingBlockingAlgo {
    //            engine.eval(new FileReadWriteHandlers("/Users/mukthar.ahmed/Downloads/script.js"));
    //        } catch (ScriptException e) {
    //            e.printStackTrace();
    //        } catch (FileNotFoundException e) {
    //            e.printStackTrace();
    //        }
    //


    public static void main(String args[]) {
        //String jsScript = "https://pixel.adsafeprotected.com/rjss/st/39226/5024613/skeleton.js";
        String jsScript = "script.js";

//        ScriptEngineManager manager = new ScriptEngineManager();
//        for (ScriptEngineFactory f : manager.getEngineFactories()) {
//            printBasicInfo(f);
//            System.out.println();
//        }
//
//
//        ScriptEngine nashorn = manager.getEngineByName("rhino");
//        if(nashorn != null) {
//            System.out.println("rhino is the javascript engine in your JDK.");
//            TestingBlockingAlgo {
//                //nashorn.eval("print('Hello World!');");
//                System.out.println("+ Javascript: " + jsScript);
//                nashorn.eval(new InputStreamReader(V8JavascriptEngine.class.getResourceAsStream(jsScript)));
//            } catch (ScriptException e) {
//                e.printStackTrace();
//            }
//        }
//        else {
//            System.out.println("rihno is not present.");
//        }

        File jsFile = new File("/Users/mukthar.ahmed/Downloads/script.js");
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine jsEngine = factory.getEngineByName("rhino");
        jsEngine.put("out", System.out);

        try {
            Reader reader = new FileReader(jsFile);
            jsEngine.eval(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(jsEngine.toString());



    }

    public static void printBasicInfo(ScriptEngineFactory factory) {
        System.out.println("engine name=" + factory.getEngineName());
        System.out.println("engine version=" + factory.getEngineVersion());
        System.out.println("language name=" + factory.getLanguageName());
        System.out.println("extensions=" + factory.getExtensions());
        System.out.println("language version=" + factory.getLanguageVersion());
        System.out.println("names=" + factory.getNames());
        System.out.println("mime types=" + factory.getMimeTypes());
    }


}
