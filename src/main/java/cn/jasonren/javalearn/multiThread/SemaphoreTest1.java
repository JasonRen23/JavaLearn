package cn.jasonren.javalearn.multiThread;

import java.util.concurrent.Semaphore;

/**
 * @author JasonRen
 * @since 2018/8/13 上午2:03
 */
public class SemaphoreTest1 {
    public static void main(String[] args) {
        int nums = 50;
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < nums; i++) {
            int finalI = i;
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println("顾客" + finalI + "在挑选商品，购买。。。");

                    Thread.sleep(1000);

                    System.out.println("顾客" + finalI + "购买完毕了。。。");
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
