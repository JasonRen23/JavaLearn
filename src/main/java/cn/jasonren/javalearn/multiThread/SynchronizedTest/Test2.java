package cn.jasonren.javalearn.multiThread.SynchronizedTest;

/**
 * 静态方法使用Class实例对象作为锁，而非静态方法使用对象实例作为锁
 */
public class Test2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            new Operation().add();
        }, "Non-Static");
        Thread t2 = new Thread(Operation::subtraction, "Static");
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }
}


class Operation {
    public synchronized void add() {
        System.out.println(Thread.currentThread().getName() + "进入add方法");
        try {
            Thread.sleep(2 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "离开add方法");
    }

    public static synchronized void subtraction() {
        System.out.println(Thread.currentThread().getName() + "进入subtraction方法");
        try {
            Thread.sleep(2 * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "离开subtraction方法");
    }
}

