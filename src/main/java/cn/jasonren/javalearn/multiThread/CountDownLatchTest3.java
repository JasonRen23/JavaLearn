package cn.jasonren.javalearn.multiThread;

import java.util.concurrent.CountDownLatch;

/**
 * @author JasonRen
 * @since 2018/8/13 上午1:46
 */
public class CountDownLatchTest3 {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(5);

        System.out.println("现在6点下班了。。。");

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    countDownLatch.await();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("。。。其他的5个员工，3y终于可以走了");
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("员工" + Thread.currentThread().getName() +"下班了");
                    countDownLatch.countDown();
                }
            }).start();
        }
    }
}
