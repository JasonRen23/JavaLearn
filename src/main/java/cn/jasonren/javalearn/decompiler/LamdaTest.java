package cn.jasonren.javalearn.decompiler;


import java.util.Arrays;
import java.util.List;

public class LamdaTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7);
        list.forEach(n -> System.out.println(n));
    }
}
