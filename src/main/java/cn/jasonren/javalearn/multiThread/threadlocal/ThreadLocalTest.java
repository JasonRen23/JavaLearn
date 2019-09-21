package cn.jasonren.javalearn.multiThread.threadlocal;

/**
 * @author RenZhiCheng
 * @since 2019-09-15 23:32
 */
public class ThreadLocalTest {

    static ThreadLocal<String> localVariable = new ThreadLocal<>();

    // (1)print函数
    static void print(String str) {
        // 1.1 打印当前线程本地内存中localVariable变量的值
        System.out.println(str + ":" + localVariable.get());
        // 1.2 清除当前线程本地内存中的localVariable变量
        localVariable.remove();
    }

    public static void main(String[] args) {

        // （3）创建线程one
        Thread threadOne = new Thread(() -> {
            // 3.1 设置线程中本地变量的值
           localVariable.set("threadOne local variable");
           // 3.2 调用打印函数
           print("threadOne");
           // 3.3 打印本地变量值
           System.out.println("threadOne remove after" + ":" + localVariable.get());
        });

        // （4）创建线程two
        Thread threadTwo = new Thread(() -> {
            // 4.1 设置线程Two中本地变量localVariable的值
            localVariable.set("threadTwo local variable");
            // 4.2 调用打印函数
            print("threadTwo");
            // 4.3 打印本地变量值
            System.out.println("threadTwo remove after" + ":" + localVariable.get());
        });

        threadOne.start();
        threadTwo.start();
    }
}
