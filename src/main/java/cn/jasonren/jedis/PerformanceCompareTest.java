package cn.jasonren.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

public class PerformanceCompareTest {
    public void delByStu(String[] keys) {
        Jedis jedis = new Jedis(JasonJedis.ip, JasonJedis.port);
        for (String key : keys) {
            jedis.del(key);
        }
        jedis.close();
    }

    public static void delByPipe(String[] keys) {
        Jedis jedis = new Jedis(JasonJedis.ip, JasonJedis.port);

        Pipeline pipeline = jedis.pipelined();
        for (String key : keys) {
            pipeline.del(key);
        }
        pipeline.sync();
        jedis.close();
    }

    public static void main(String[] args) {

    }

}
