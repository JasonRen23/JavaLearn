package cn.jasonren.javalearn.multiThread;

import java.util.concurrent.CountDownLatch;

/**
 * @author JasonRen
 * @since 2018/8/13 上午1:03
 */
public class CountDownLatchTest2 {
    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(new Runnable() {
            @Override
            public void run() {
                 try{
                     System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                     Thread.sleep(3000);
                     System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                     latch.countDown();
                 }catch(Exception e){
                    e.printStackTrace();
                 }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                    latch.countDown();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();

        try{
            System.out.println("等待2个子线程执行完毕。。。");
            latch.await();
            System.out.println("两个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
