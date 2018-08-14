package cn.jasonren.javalearn.innerclass;

/**
 * @author zhicheng
 * @create 2018-07-06 下午1:20
 */


public class Outer1 {
    private static int shared = 100;
    public static class StaticInner{
        public void innerMethod(){
            System.out.println("inner " + shared);
        }
    }
    public void test(){
        StaticInner si = new StaticInner();
        si.innerMethod();
    }
}
