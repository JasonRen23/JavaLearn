package cn.jasonren.javalearn.dataType;

/**
 * @author JasonRen
 * @since 2018/8/10 下午4:36
 */
public class staticTest {
    static int a;
    int b;
    static int c;

    public int aMethod() {
        a++;
        return a;
    }

    public int bMethod() {
        b++;
        return b;
    }

    public int cMethod() {
        c++;
        return c;
    }

    public static void main(String[] args) {
        staticTest test1 = new staticTest();
        test1.aMethod();
        System.out.println(test1.aMethod());
        staticTest test2 = new staticTest();
        test2.bMethod();
        System.out.println(test2.bMethod());
        staticTest test3 = new staticTest();
        test3.cMethod();
        System.out.println(test3.cMethod());

        // String str = null;
        // str.concat("abc");
        // str.concat("123");
        // System.out.println(str);

        int[] a = new int[20 + 5];
        a[0] = 1;
        a[1] = 1;
        a[2] = 1;
        a[3] = 2;
        for (int i = 3; i <= 20; i++) {
            a[i] = a[i - 1] + a[i - 3];
        }
        System.out.println(a[20]);

    }

}
