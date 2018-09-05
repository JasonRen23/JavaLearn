package cn.jasonren.javalearn.multiThread.SynchronizedTest;

import java.util.concurrent.atomic.AtomicInteger;

import static cn.jasonren.javalearn.multiThread.SynchronizedTest.Test3.getLock;
import static cn.jasonren.javalearn.multiThread.SynchronizedTest.Test3.releaseLock;

public class Test3 {
    static AtomicInteger getLock = new AtomicInteger(1);
    static AtomicInteger releaseLock = new AtomicInteger(0);

    public static void main(String[] args) {
        Operation2.subtraction();
    }
}

class Operation2 {
    static synchronized void doSomething() {
        System.out.println(Thread.currentThread().getName() + " 第 " + getLock.intValue() +
            " 次获得锁");
        getLock.incrementAndGet();

        try {
            Thread.sleep(2 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        releaseLock.incrementAndGet();
        System.out.println(Thread.currentThread().getName() + " 第 " + releaseLock.intValue() +
            " 次释放锁");
    }

    static synchronized void subtraction() {
        System.out.println(Thread.currentThread().getName() + " 第 " + getLock.intValue() +
            " 次获得锁");
        getLock.incrementAndGet();

        doSomething();

        releaseLock.incrementAndGet();
        System.out.println(Thread.currentThread().getName() + " 第 " + releaseLock.intValue() +
            " 次释放锁");
    }
}
