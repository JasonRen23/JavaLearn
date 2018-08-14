package cn.jasonren.javalearn.multiThread;

import java.util.concurrent.CountDownLatch;

/**
 * @author JasonRen
 * @since 2018/8/13 上午1:49
 */
public class CountDownLatchTest4 {
    public static void main(String[] args) {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(5);
                }catch(Exception e){
                    e.printStackTrace();
                }
                System.out.println("3y终于写完了");
                countDownLatch.countDown();
            }
        }).start();

        for (int i = 0; i < 5; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("其他员工需要等待3y");
                    try{
                        countDownLatch.await();
                    }catch(Exception e){
                        e.printStackTrace();
                    }
                    System.out.println("3y终于写完了，其他员工可以开始了！");
                }
            }).start();
        }
    }


}
