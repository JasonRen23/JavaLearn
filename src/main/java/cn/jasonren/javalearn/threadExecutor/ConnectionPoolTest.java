package cn.jasonren.javalearn.threadExecutor;

import java.sql.Connection;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : JasonRen
 * @date : 2018-08-04 下午9:11
 * @email : zhicheng_ren@163.com
 */
public class ConnectionPoolTest {
    static ConnectionPool pool = new ConnectionPool(10);

    static CountDownLatch start = new CountDownLatch(1);

    static CountDownLatch end;

    public static void main(String[] args) throws Exception{
        int threadCount = 40;
        end = new CountDownLatch(threadCount);
        int count = 20;
        AtomicInteger got = new AtomicInteger();
        AtomicInteger notGot = new AtomicInteger();
        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ConnectionRunner(count, got, notGot),
                "ConnectionRunnerThread");
            thread.start();

        }
        start.countDown();
        end.await();
        System.out.println("total invoke: " + (threadCount * count));
        System.out.println("got connection: " + got);
        System.out.println("not got connection: " + notGot);
    }

    static class ConnectionRunner implements Runnable {
        int count;
        AtomicInteger got;
        AtomicInteger notGot;

        public ConnectionRunner(final int count, final AtomicInteger got, final AtomicInteger notGot) {
            this.count = count;
            this.got = got;
            this.notGot = notGot;
        }

        @Override
        public void run() {
            try{
                start.await();
            }catch(Exception e){
            }

            while (count > 0) {
                try{
                    //从线程池中获取连接，如果1000ms内无法获取到，将会返回null
                    //分别统计连接获取的数量got和未获取到的数量notGot
                    Connection connection = pool.fetchConnection(1000);
                    if (connection != null) {
                        try{
                            connection.createStatement();
                            connection.commit();
                        }finally {
                            pool.releaseConnection(connection);
                            got.incrementAndGet();
                        }
                    }
                }catch(Exception e){
                }finally {
                    count--;
                }
            }
            end.countDown();
        }
    }
}
