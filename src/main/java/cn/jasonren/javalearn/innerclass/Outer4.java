package cn.jasonren.javalearn.innerclass;

/**
 * @author zhicheng
 * @create 2018-07-06 下午2:23
 */


public class Outer4 {
    public void test(){
        final String[] str = new String[]{"hello"};
        class Inner{
            public void innerMethod(){
                str[0] = "hello world";
            }
        }
        Inner inner = new Inner();
        inner.innerMethod();
        System.out.println(str[0]);
    }

    public static void main(String[] args) {
        new Outer4().test();
    }
}
