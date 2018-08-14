package cn.jasonren.javalearn.threadExecutor;



import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * @author : JasonRen
 * @date : 2018-08-04 下午10:25
 * @email : zhicheng_ren@163.com
 */

@Slf4j
public class MyTask implements Runnable {

    /** logger */
    // private static final Logger LOGGER = LoggerFactory.getLogger(MyTask.class);

    @Override
    public void run() {
        System.out
            .println(System.currentTimeMillis() + ": Thread ID : " + Thread.currentThread().getId());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MyTask myTask = new MyTask();
        ExecutorService pool = new ThreadPoolExecutor(5, 20, 0L,
            TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>(1024),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10; i++) {
            pool.execute(myTask);
        }
        pool.shutdown();


        while (!pool.awaitTermination(1, TimeUnit.SECONDS)) {
            log.info("线程还在执行呢...");
        }

        long end = System.currentTimeMillis();
        log.info("一共处理了" + (end - start) + "秒");

    }
}
