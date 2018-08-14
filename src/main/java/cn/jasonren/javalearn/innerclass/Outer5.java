package cn.jasonren.javalearn.innerclass;

import cn.jasonren.javalearn.interfaces.Point;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author zhicheng
 * @create 2018-07-06 下午2:27
 */


public class Outer5 {
    public void test(final int x, final int y){
        Point point = new Point(2, 3) {
            @Override
            public double distance() {
                return distance(new Point(x, y));
            }
        };
        System.out.println(point.distance());


    }

    public static void sortIgnoreCase(String[] strs){
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
    }


    public static void main(String[] args) {
        String[] strings = new String[]{"renzhicheng", "waner", "luolin"};
        sortIgnoreCase(strings);
        System.out.println(Arrays.toString(strings));
    }
}
