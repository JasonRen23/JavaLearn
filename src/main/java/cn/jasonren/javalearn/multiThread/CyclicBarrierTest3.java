package cn.jasonren.javalearn.multiThread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author JasonRen
 * @since 2018/8/13 上午1:59
 */
public class CyclicBarrierTest3 {
    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
        for (int i = 0; i < 2; i++) {
            new Thread(() -> {
               String name = Thread.currentThread().getName();
               if (name.equals("Thread-0")) {
                   name = "3y";
               } else {
                   name = "女朋友";
               }
                System.out.println(name + "到了体育西");
               try{
                   cyclicBarrier.await();
                   System.out.println("跟" + name + "去夜上海吃东西");

                   cyclicBarrier.await();
                   System.out.println(name + "洗澡");

                   cyclicBarrier.await();
                   System.out.println(name + "一起聊天");
               }catch(InterruptedException | BrokenBarrierException e){
                    e.printStackTrace();
               }
            }).start();
        }
    }
}
