package cn.jasonren.javalearn.java8.lamda;

/**
 * @author zhicheng
 * @create 2018-06-27 下午7:24
 */


public class test1 {
    public static void main(String[] args) {

        System.out.println("=== RunnableTest ===");

        //Anonymous Runnable
        Runnable r1 = new Runnable() {
            public void run() {
                System.out.println("Hello world one!");
            }
        };

        //Lamda Runnable
        Runnable r2 = () -> System.out.println("Hello world two!");

        //Run em!
        r1.run();
        r2.run();


    }
}
