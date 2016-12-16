package com.muks.oopsandjava.concepts.a_passbyvalueandref;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

/**
 * Created by 300000511 on 16/12/16.
 *
 * There are 2 types of references
 1. Strong &
 2. Week References‰
 2.1) Soft references
 2.2) Phantom references


 Soft References: In Soft reference, even if the object is free for garbage collection, its not garbage
 collected, until JVM is in need of memory badly.The objects gets cleared from the memory when JVM runs out of memory.

 Phantom References: The objects which are being referenced by phantom references are eligible for garbage collection.
 But, before removing them from the memory, JVM puts them in a queue called ‘reference queue’ .
 They are put in a reference queue after calling finalize() method on them


 */
public class JavaReferenceTypes {
    public static void main(String[] args) {
//        new JavaReferenceTypes().StrongReference();
//        new JavaReferenceTypes().SoftReference();
        new JavaReferenceTypes().PhantomReference();
    }

    // Java program to illustrate Strong reference
    static class Gfg {
        public void xMethod() {
            System.out.println("GeeksforGeeks");
        }
    }

    public void StrongReference() {
        /** Strong reference */
        Gfg strongRef = new Gfg();
        strongRef.xMethod();
        strongRef = null;         /** Strong references are eligible for garbage collection only when its null */
    }


    public void SoftReference() {
        // Strong Reference
        Gfg g = new Gfg();
        g.xMethod();

        // Creating Soft Reference to Gfg-type object to which 'g'
        // is also pointing.
        SoftReference<Gfg> softref = new SoftReference<Gfg>(g);

        // Now, Gfg-type object to which 'g' was pointing
        // earlier is available for garbage collection.
        g = null;

        // You can retrieve back the object which
        // has been weakly referenced.
        // It succesfully calls the method.
        g = softref.get();

        g.xMethod();
    }


    public void PhantomReference() {
        //Strong Reference
        Gfg g = new Gfg();
        g.xMethod();

        //Creating reference queue
        ReferenceQueue<Gfg> refQueue = new ReferenceQueue<Gfg>();

        //Creating Phantom Reference to Gfg-type object to which 'g'
        //is also pointing.
        PhantomReference<Gfg> phantomRef = null;

        phantomRef = new PhantomReference<Gfg>(g,refQueue);

        //Now, Gfg-type object to which 'g' was pointing
        //earlier is available for garbage collection.
        //But, this object is kept in 'refQueue' before
        //removing it from the memory.
        g = null;

        //It always returns null.
        g = phantomRef.get();

        //It shows NullPointerException.
        g.xMethod();
    }

}
