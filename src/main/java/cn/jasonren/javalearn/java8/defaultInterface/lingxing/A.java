package cn.jasonren.javalearn.java8.defaultInterface.lingxing;

public interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}
