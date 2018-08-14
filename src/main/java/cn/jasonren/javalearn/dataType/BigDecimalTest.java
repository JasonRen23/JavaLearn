package cn.jasonren.javalearn.dataType;

import java.math.BigDecimal;

/**
 * @author JasonRen
 * @since 2018/8/12 下午11:07
 */
public class BigDecimalTest {
    public static void main(String[] args) {

        float a = 57.3f;
        BigDecimal bigDecimalA = new BigDecimal(a);
        System.out.println(bigDecimalA);

        double b = 57.3;
        BigDecimal bigDecimalB = new BigDecimal(b);
        System.out.println(bigDecimalB);

        double c = 57.3;
        BigDecimal bigDecimalC = new BigDecimal(Double.toString(c));
        System.out.println(bigDecimalC);

        double d = 57.3;
        BigDecimal bigDecimalD = BigDecimal.valueOf(d);
        System.out.println(bigDecimalD);

    }
}
