package cn.jasonren.javalearn.generic;

/**
 * @author : JasonRen
 * @date : 2018-08-04 上午1:08
 * @email : zhicheng_ren@163.com
 */
public class ObjectTool<T> {
    private T obj;

    public T getObj() {
        return obj;
    }

    public void setObj(final T obj) {
        this.obj = obj;
    }

    public <T> void show(T t) {
        System.out.println(t);
    }
}
