package cn.jasonren.javalearn.ObjectTest;

/**
 * @author JasonRen
 * @since 2018/8/11 下午8:58
 */

interface Contents {
    int value();
}

class Pracel {
    public Contents contents() {
        return new Contents() {
            private int i = 42;
            @Override
            public int value() {
                return i;
            }
        };
    }
}
public class test2 {
    public static void main(String[] args) {
        Pracel p = new Pracel();
        Contents c = p.contents();
        System.out.println(p.getClass());
    }
}
