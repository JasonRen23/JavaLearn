package cn.jasonren.javalearn.java8.defaultInterface.chongtu;

public class C implements A,B{
    @Override
    public void hello() {
        A.super.hello();
    }

    public static void main(String[] args) {
        new C().hello();
    }
}
