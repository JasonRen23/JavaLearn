package cn.jasonren.javalearn.multiThread.threadlocal;

/**
 * @author RenZhiCheng
 * @since 2019-09-16 00:07
 */
public class TestThreadLocal {
    // (1) 创建线程变量
    public static ThreadLocal<String> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set("hello world");
        Thread thread = new Thread(() -> {
            System.out.println("thread:" + threadLocal.get());
        });
        thread.start();
        System.out.println("main:" + threadLocal.get());
    }
}
