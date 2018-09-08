package cn.jasonren.javalearn.construct;

/**
 * 携程笔试原题
 */
public class Test {
    public static Test t1 = new Test();

    {
        System.out.println("blockA");
    }

    static {
        System.out.println("blockB");
    }

    public static void main(String[] args) {
        Test t2 = new Test();
        Test t1 = new Test();
    }
}
