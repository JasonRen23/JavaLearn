package cn.jasonren.javalearn.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : JasonRen
 * @date : 2018-08-04 上午1:19
 * @email : zhicheng_ren@163.com
 */
public class test4 {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>();
        test(integers);

        // List<String> strings = new ArrayList<>();
        // test(strings);
    }

    public static void test(List<? extends Number> list){}
}
