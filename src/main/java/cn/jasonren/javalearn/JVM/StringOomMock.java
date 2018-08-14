package cn.jasonren.javalearn.JVM;

import java.util.ArrayList;
import java.util.List;

/**
 * @author JasonRen
 * @since 2018/8/12 下午1:44
 */
public class StringOomMock {
    static String base = "string";

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String str = base + base;
            base = str;
            list.add(str.intern());
        }
    }
}
