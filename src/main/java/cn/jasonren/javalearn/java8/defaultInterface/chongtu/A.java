package cn.jasonren.javalearn.java8.defaultInterface.chongtu;

public interface A {
    default void hello() {
        System.out.println("Hello from A");
    }
}
