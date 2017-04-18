package com.muks.oopsandjava.concepts.annotationsCustom.eg2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by 300000511 on 18/04/17.
 */




@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD) //can use in method only.
public @interface Test {

    //should ignore this test?
    public boolean enabled() default true;

}