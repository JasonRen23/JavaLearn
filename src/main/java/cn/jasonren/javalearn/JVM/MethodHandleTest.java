package cn.jasonren.javalearn.JVM;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

public class MethodHandleTest {
    static class ClassA {
        public void println(String s) {
            System.out.println(s);
        }
    }

    public static void main(String[] args) throws Throwable {
        Object obj = System.currentTimeMillis() % 2 == 0 ? System.out : new ClassA();

        /**
         * 无论obj最终是哪个实现类，下面这句都能正确调用到println方法
         */
        getPrintlnMH(obj).invokeExact("icyfenix");
    }

    private static MethodHandle getPrintlnMH(Object receiver) throws Throwable {
        MethodType mt = MethodType.methodType(void.class, String.class);

        return lookup().findVirtual(receiver.getClass(), "println", mt).bindTo(receiver);
    }
}
