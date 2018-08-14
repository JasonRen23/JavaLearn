package cn.jasonren.javalearn.generic;

/**
 * @author : JasonRen
 * @date : 2018-08-04 上午2:05
 * @email : zhicheng_ren@163.com
 */
public class HumanSay<T extends Human> {
    private T t;

    public HumanSay(final T t) {
        this.t = t;
    }

    public void proxySay() {
        t.say();
    }

    public T get() {
        return t;
    }

}
