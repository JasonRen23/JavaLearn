package cn.jasonren.javalearn.ObjectTest;

import java.util.Objects;

/**
 * @author JasonRen
 * @since 2018/8/11 下午9:38
 */
public class ObjectsTest {
    static ObjectsTest obj;

    public static void main(String[] args) {
        System.out.println(Objects.hashCode(obj));
        System.out.println(Objects.toString(obj));
        System.out.println(Objects.requireNonNull(obj, "obj参数不能是null"));

    }
}
