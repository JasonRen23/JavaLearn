package cn.jasonren.javalearn.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
public @interface ConfFactory {
    String value() default "";
}
