package cn.jasonren.javalearn.java8.defaultInterface.chongtu;

public interface B {
    default void hello() {
        System.out.println("Hello from B");
    }
}
