package cn.jasonren.javalearn.multiThread;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

/**
 * @author JasonRen
 * @since 2018/8/13 上午1:10
 */
public class CyclicBarrierTest1 {
    public static void main(String[] args) {
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
            @Override
            public void run() {
                System.out.println("当前线程" + Thread.currentThread().getName());
            }
        });
        for (int i = 0; i < N; i++) {
            if (i < N - 1)
                new Writer(barrier).start();
            else {
                try{
                    Thread.sleep(5000);
                }catch(Exception e){
                    e.printStackTrace();
                }
                new Writer(barrier).start();
            }
        }

    }

    static class Writer extends Thread {
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据。。。");
            try{
                Thread.sleep(5000);
                System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
            }catch(Exception e){
                e.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务。。。");
        }
    }




}
