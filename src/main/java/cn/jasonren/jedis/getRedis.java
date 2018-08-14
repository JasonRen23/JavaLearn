package cn.jasonren.jedis;

import redis.clients.jedis.Jedis;

import java.nio.charset.StandardCharsets;

/**
 * @author : JasonRen
 * @date : 2018-08-01 下午10:39
 * @email : zhicheng_ren@163.com
 */
public class getRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        String key = "seckill:" + "1003";
        // jedis.set("java", "java hello world");
        byte[] arr = jedis.get(key.getBytes());
        System.out.println(new String(arr, StandardCharsets.UTF_8));
    }
}
