package cn.jasonren.javalearn.threadExecutor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author : JasonRen
 * @date : 2018-08-05 下午2:36
 * @email : zhicheng_ren@163.com
 */
public class ScheduledTest {
    public static void main(String[] args) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);

        //如果前面的任务没完成，则调度也不会启动
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(10000);
                    System.out.println(System.currentTimeMillis() / 1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }, 0, 2, TimeUnit.SECONDS);

        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try{
                    Thread.sleep(5000);
                    System.out.println(System.currentTimeMillis() / 1000);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }, 0, 2, TimeUnit.SECONDS);

        service.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("5秒之后执行schedule");
            }
        }, 5, TimeUnit.SECONDS);

    }
}
