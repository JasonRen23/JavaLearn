package cn.jasonren.jedis;

import org.junit.Test;
import org.junit.rules.Stopwatch;
import redis.clients.jedis.BinaryJedisCluster;
import redis.clients.jedis.HostAndPort;

import java.util.HashSet;
import java.util.Set;

public class testBenchRedisSet {
    private static BinaryJedisCluster jc;

    static {
        //只给集群里的一个实例就好
        Set<HostAndPort> jedisClusterNodes = new HashSet<>();
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7000));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7001));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7002));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7003));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7004));
        jedisClusterNodes.add(new HostAndPort("127.0.0.1", 7005));
        jc = new BinaryJedisCluster(jedisClusterNodes);
    }


    // public static void main(String[] args) {
    //     final Stopwatch stopwatch = new Stopwatch();
    // }
}
