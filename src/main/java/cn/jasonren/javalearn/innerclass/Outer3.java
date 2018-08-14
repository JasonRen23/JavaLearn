package cn.jasonren.javalearn.innerclass;

/**
 * @author zhicheng
 * @create 2018-07-06 下午2:09
 */


public class Outer3 {
    private int a = 100;
    public void test(final int param){
        final String str = "hello";
        String str1 = "world";
        class Inner{
            public void innerMethod(){
                System.out.println("outer a " + a);
                System.out.println("param " + param);
                System.out.println("local var " + str);
                System.out.println("local var " + str1);
            }
        }
        Inner inner = new Inner();
        inner.innerMethod();
    }

    public static void main(String[] args) {
        new Outer3().test(2);
    }
}
