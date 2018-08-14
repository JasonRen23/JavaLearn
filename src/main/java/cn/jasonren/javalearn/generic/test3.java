package cn.jasonren.javalearn.generic;

/**
 * @author : JasonRen
 * @date : 2018-08-04 上午1:10
 * @email : zhicheng_ren@163.com
 */
public class test3 {
    public <T> void show(T t) {
        System.out.println(t);
    }
    public static void main(String[] args) {
        ObjectTool tool = new ObjectTool();

        tool.show("hello");
        tool.show(12);
        tool.show(12.5);
    }
}
