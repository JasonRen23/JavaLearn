package cn.jasonren.javalearn.innerclass;

/**
 * @author zhicheng
 * @create 2018-07-06 下午1:24
 */


public class Outer2 {
    private int a = 100;
    public class Inner{
        public void innerMethod(){
            System.out.println("outer a " + a);
            Outer2.this.action();

        }
    }
    private void action(){
        System.out.println("action");
    }
    public void test(){
        Inner inner = new Inner();
        inner.innerMethod();
    }

    public static void main(String[] args) {
        Outer2 outer2 = new Outer2();
        Outer2.Inner inner = outer2.new Inner();
        inner.innerMethod();
    }

}
