package cn.jasonren.javalearn.serial;

import java.io.Serializable;

/**
 * @author : JasonRen
 * @date : 2018-08-05 下午12:29
 * @email : zhicheng_ren@163.com
 */
public class Person implements Serializable {
    private static final long serialVersionUID = 12345789L;
    public int id;
    public String name;

    public Person(final int id, final String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person: " + id + " " + name;
    }


}
