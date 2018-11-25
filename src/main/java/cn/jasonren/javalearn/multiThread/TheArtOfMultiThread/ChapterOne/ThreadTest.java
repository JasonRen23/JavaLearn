package cn.jasonren.javalearn.multiThread.TheArtOfMultiThread.ChapterOne;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author JasonRen
 * @since 2018/11/22 3:38 PM
 */
public class ThreadTest {
    //继承Thread类并重写run方法
    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    //实现Runnable接口的run方法
    public static class RunnableTask implements Runnable {
        @Override
        public void run() {
            System.out.println("I am a child thread");
        }
    }

    //创建任务类，类似Runnable
    public static class CallerTask implements Callable<String> {
        @Override
        public String call() {
            return "hello";
        }
    }

    public static void main(String[] args) throws InterruptedException{
        //创建线程
        MyThread myThread = new MyThread();

        //启动线程
        myThread.start();

        RunnableTask task = new RunnableTask();
        new Thread(task).start();
        new Thread(task).start();

        //创建异步任务
        FutureTask<String> futureTask = new FutureTask<>(new CallerTask());
        //启动线程
        new Thread(futureTask).start();
        try {
            //等待任务执行完成，并返回结果
            String result = futureTask.get();
            System.out.println(result);
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

}

