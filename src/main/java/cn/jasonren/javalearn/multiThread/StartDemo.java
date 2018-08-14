package cn.jasonren.javalearn.multiThread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.CountDownLatch;

/**
 * @author JasonRen
 * @since 2018/8/13 上午1:27
 */
public class StartDemo {

    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    final static String startTime = sdf.format(new Date());

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(5);
        Stats stats1 = new Stats("任务A", 1000, latch);
        Stats stats2 = new Stats("任务B", 2000, latch);
        Stats stats3 = new Stats("任务C", 2000, latch);
        Stats stats4 = new Stats("任务D", 2000, latch);
        Stats stats5 = new Stats("任务E", 2000, latch);
        stats1.start();//任务A开始执行
        stats2.start();//任务B开始执行
        stats3.start();//任务C开始执行
        stats4.start();//任务D开始执行
        stats5.start();//任务E开始执行
        latch.await();// 等待所有任务结束
        System.out.println("所有的统计任务执行完成:" + sdf.format(new Date()));
    }

    static class Stats extends Thread {
        String statsName;
        int runTime;
        CountDownLatch latch;

        public Stats (String statsName, int runTime, CountDownLatch latch) {
            this.statsName = statsName;
            this.runTime = runTime;
            this.latch = latch;
        }

        @Override
        public void run() {
            try{
                System.out.println(statsName + " do stats begin at " + statsName);
                Thread.sleep(runTime);
                System.out.println(statsName + " do stats complete at " + sdf.format(new Date()));
                latch.countDown();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

}
