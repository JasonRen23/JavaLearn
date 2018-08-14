package cn.jasonren.javalearn.multiThread;

import java.util.concurrent.CountDownLatch;

/**
 * @author JasonRen
 * @since 2018/8/13 上午12:32
 */
public class CountDownLatchTest {
    static CountDownLatch c = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
                c.countDown();
            }
        }).start();

        c.await();
        System.out.println("3");
    }
}
