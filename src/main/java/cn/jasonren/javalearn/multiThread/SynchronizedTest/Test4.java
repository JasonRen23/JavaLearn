package cn.jasonren.javalearn.multiThread.SynchronizedTest;

public class Test4 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            new Operation_2();
        }, "Non-Static");
        Thread t2 = new Thread(Operation::subtraction, "Static");
        t1.start();
        t2.start();

        t1.join();
        t2.join();
    }


}

class Operation_2 {

    public Operation_2() {
        synchronized (this) {
            System.out.println("进入constructor方法");
        }
        System.out.println("离开constructor方法");
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
