package cn.jasonren.javalearn.java8.streamapi;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author RenZhiCheng
 * @since 2019-09-01 00:05
 */
public class StreamTest {
    public List<Integer> values = new ArrayList<>(1000000);
    @Test
    public void sequentialSort(){
        long t0 = System.nanoTime();

        long count = values.stream().sorted().count();
        System.err.println("count = " + count);

        long t1 = System.nanoTime();

        long millis  = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("sequential sort took: %d ms", millis));
        //sequential sort took: 1932 ms

    }

    //parallel Sort, 采用并行流进行排序
    @Test
    public void parallelSort(){
        long t0 = System.nanoTime();

        long count = values.parallelStream().sorted().count();
        System.err.println("count = " + count);

        long t1 = System.nanoTime();

        long millis  = TimeUnit.NANOSECONDS.toMillis(t1 - t0);
        System.out.println(String.format("parallel sort took: %d ms", millis));
        //parallel sort took: 1373 ms 并行排序所花费的时间大约是顺序排序的一半。
    }
}
