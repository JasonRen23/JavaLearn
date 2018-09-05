package cn.jasonren.javalearn.multiThread.SynchronizedTest;

/**
 * 修饰非静态方法
 */
public class Test1 implements Runnable{

    static int num = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(new Test1());
        Thread t2 = new Thread(new Test1());

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(Test1.num);
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 1000; i++) {
            num++;
        }
    }
}
