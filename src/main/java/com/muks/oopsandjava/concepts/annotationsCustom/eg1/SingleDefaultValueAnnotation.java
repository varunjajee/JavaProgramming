package com.muks.oopsandjava.concepts.annotationsCustom.eg1;

/**
 * Created by 300000511 on 18/04/17.
 */
public @interface SingleDefaultValueAnnotation {
    int value() default 0;
}