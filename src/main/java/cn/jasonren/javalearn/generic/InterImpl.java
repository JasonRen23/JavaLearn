package cn.jasonren.javalearn.generic;

/**
 * @author : JasonRen
 * @date : 2018-08-04 上午1:13
 * @email : zhicheng_ren@163.com
 */
public class InterImpl<T> implements Inter<T>{
    @Override
    public void show(final T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        Inter<String> i = new InterImpl<>();
        i.show("hello");
    }
}
