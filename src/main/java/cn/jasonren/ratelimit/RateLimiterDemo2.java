package cn.jasonren.ratelimit;

import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.RateLimiter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;

public class RateLimiterDemo2 {
    public static void main(String[] args) {
        ListeningExecutorService executorService = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(100));
        //指定每秒释放一个令牌
        RateLimiter rateLimiter = RateLimiter.create(1);
        for (int i = 0; i < 50; i++) {
            //请求RateLimiter,超过permits会被阻塞
            //acquire(int permits)函数主要用于获取permits个令牌，并计算需要等待多长时间，进而挂起等待，并将该值返回
            Double acquire = null;
            if (i == 1) {
                acquire = rateLimiter.acquire(1);
            } else if (i == 2) {
                acquire = rateLimiter.acquire(10);
            } else if (i == 3) {
                acquire = rateLimiter.acquire(2);
            } else if (i == 4) {
                acquire = rateLimiter.acquire(20);
            } else {
                acquire = rateLimiter.acquire(2);
            }
            executorService.submit(new Task("获取令牌成功，获取耗时：" + acquire + " 第 " + i + " 个任务执行"));
        }
    }


}

class Task implements Runnable {
    String str;

    public Task(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        System.out.println(simpleDateFormat.format(new Date()) + " | " + Thread.currentThread().getName() + str);
    }
}
