package cn.jasonren.javalearn.threadExecutor;

import lombok.extern.slf4j.Slf4j;

import java.sql.Time;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author : JasonRen
 * @date : 2018-08-05 下午2:43
 * @email : zhicheng_ren@163.com
 */

/**
 *
 *
 *
 */
@Slf4j
public class ExtendThreadPoolDemo {
    static class MyTask implements Runnable{
        String name;

        public MyTask(final String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("正在执行: Thread ID:" + Thread.currentThread().getId() + ", Task Name = " + name);
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService es = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>()){
            @Override
            protected void beforeExecute(final Thread t, final Runnable r) {
                System.out.println("准备执行：" + ((MyTask) r).name);
            }

            @Override
            protected void afterExecute(final Runnable r, final Throwable t) {
                System.out.println("执行完成：" + ((MyTask) r).name);
            }

            @Override
            protected void terminated() {
                System.out.println("线程池退出");
            }
        };

        for (int i = 0; i < 5; i++) {
            MyTask myTask = new MyTask("TASK-GEYM-" + i);
            es.execute(myTask);
            Thread.sleep(10);
        }

        es.shutdown();
        while (!es.awaitTermination(1, TimeUnit.SECONDS)){
            log.info("线程还在执行呢...");
        }
        System.out.println("好，线程池关闭了！");
    }
}
