package cn.jasonren.jedis.watch;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RedisTest {
    public static void main(String[] args) {
        final String watchkeys = "watchkeys";
        ExecutorService executorService = Executors.newFixedThreadPool(20);

        final Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set(watchkeys, "0");              //重置watchkeys为0
        jedis.del("setsucc", "setfail"); //清空抢成功的，与没有成功的
        jedis.close();

        for (int i = 0; i < 10000; i++) {
            executorService.execute(new MyRunnble());
        }
    }

}

class MyRunnble implements Runnable {
    String watchkeys = "watchkeys";
    Jedis jedis = new Jedis("127.0.0.1", 6379);

    public MyRunnble() {}
    @Override
    public void run() {
        try {
            jedis.watch(watchkeys);

            String val = jedis.get(watchkeys);
            int valint = Integer.valueOf(val);
            String userInfo = UUID.randomUUID().toString();
            if (valint < 10) {
                Transaction tx = jedis.multi(); //开启事务

                tx.incr("watchkeys");

                List<Object> list = tx.exec(); //提交事务，如果此时watchkeys被改动了，则返回null
                if (list != null) {
                    System.out.println("用户: " + userInfo + "抢购成功，当前抢购成功人数："
                    + (valint + 1));
                    /* 抢购成功业务逻辑 */
                    jedis.sadd("setsucc", userInfo);
                } else {
                    System.out.println("用户：" +userInfo + "抢购失败");
                    /* 抢购失败业务逻辑 */
                    jedis.sadd("setfail", userInfo);
                }
            } else {
                System.out.println("用户：" + userInfo + "抢购失败");
                jedis.sadd("setfail", userInfo);
                return;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }
}
