package cn.jasonren.javalearn.java8.lamda;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author RenZhiCheng
 * @since 2019-08-24 16:58
 */
public interface BufferedReaderProcessor {
    String process(BufferedReader b) throws IOException;
}
