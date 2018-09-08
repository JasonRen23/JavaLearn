package cn.jasonren.jedis;

import redis.clients.jedis.Jedis;

public class RedisTools {
    public static String ip = "127.0.0.1";
    public static int port = 6379;
    public static int arrLength = 100000;

    public static void initRedisData() {
        Jedis jedis = new Jedis();
    }
}