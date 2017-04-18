package com.muks.oopsandjava.concepts.annotationsCustom.eg1;

/**
 * Created by 300000511 on 18/04/17.
 */
public @interface MultiValueAnnotation {
    int value1() default 1;
    String value2() default "";
    String value3() default "xyz";
}
