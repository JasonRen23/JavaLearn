package cn.jasonren.javalearn.java8.streamapi;

import java.util.function.Function;
import java.util.stream.LongStream;

/**
 * @author RenZhiCheng
 * @since 2019-09-01 00:06
 */
class Accumlator{
    public long total = 0;
    public void add(long value) {
        total += value;
    }
}

public class ParallelTest {
    public static void main(String[] args) {
        //错误使用并行流
        System.out.println("SideEffect parallel sum done in :" + measureSumPerf(ParallelTest::sideEffectParallelSum, 1_000_000) + "mesecs");
        System.out.println("==============");
        //正确应该这样用
        System.out.println("SideEffect sum done in : " + measureSumPerf(ParallelTest::sideEffectSum, 1_000_000) + "mesecs");
    }
    //错误使用并行流
    public static long sideEffectParallelSum(long n) {
        Accumlator accumlator = new Accumlator();
        LongStream.rangeClosed(1, n).parallel().forEach(accumlator::add);
        return accumlator.total;
    }
    //正确使用流
    public static long sideEffectSum(long n) {
        Accumlator accumlator = new Accumlator();
        LongStream.rangeClosed(1, n).forEach(accumlator::add);
        return accumlator.total;
    }
    //定义测试函数
    public static long measureSumPerf(Function<Long, Long> adder, long n) {
        long fastest = Integer.MAX_VALUE;
        //迭代10次
        for (int i = 0; i < 2; i++) {
            long start = System.nanoTime();
            long sum = adder.apply(n);
            long duration = (System.nanoTime() - start)/ 1_000_000;
            System.out.println("Result: " + sum);
            //取最小值
            if (duration < fastest) {
                fastest = duration;
            }
        }
        return fastest;
    }

}
