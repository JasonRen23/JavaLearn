package cn.jasonren.javalearn.construct;

/**
 * 知乎解释 https://www.zhihu.com/question/49196023
 */

class Log {
    public static String baseFieldInit() {
        System.out.println("Base Normal Field");
        return "";
    }

    public static String baseStaticFieldInit() {
        System.out.println("Base Static Field");
        return "";
    }

    public static String fieldInit() {
        System.out.println("Normal Field");
        return "";
    }

    public static String staticFieldInit() {
        System.out.println("Static Field");
        return "";
    }

}


class Base {
    static {
        System.out.println("Base Static Block 1");
    }

    private static String staticValue = Log.baseStaticFieldInit();

    static {
        System.out.println("Base Static Block 2");
    }

    {
        System.out.println("Base Normal Block 1");
    }

    private String value = Log.baseFieldInit();

    {
        System.out.println("Base Normal Block 2");
    }

    Base() {
        System.out.println("Base Constructor");
    }
}

public class Derived extends Base{
    static {
        System.out.println("Static Block 1");
    }

    private static String staticValue = Log.staticFieldInit();

    static {
        System.out.println("Static Block 2");
    }

    {
        System.out.println("Normal Block 1");
    }

    private String value = Log.fieldInit();

    {
        System.out.println("Normal Block 2");
    }

    Derived() {
        System.out.println("Derived Constructor");
    }

    public static void main(String[] args) {
        Derived derived = new Derived();
    }
}
