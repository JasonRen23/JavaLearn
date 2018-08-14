package cn.jasonren.javalearn.ObjectTest;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;

/**
 * @author JasonRen
 * @since 2018/8/11 下午10:02
 */
public class EqualsTest {
    static class Person{
        public String name;
        public long identity;

        public Person(final String name, final long identity) {
            this.name = name;
            this.identity = identity;
        }

        @Override
        public boolean equals(final Object obj) {
            if (obj instanceof Person) {
                if (((Person) obj).identity == this.identity) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int hashCode() {
            return (int) identity;
        }
    }

    @Test
    public void testEqual() throws Exception {
        Person x = new Person("aa", 1234);
        Person y = new Person("aa", 12345);
        Person z = new Person("bb", 1234);
        Assert.assertTrue(x.equals(x));
        Assert.assertTrue(x.equals(z));
        Assert.assertTrue(z.equals(x));
        Assert.assertFalse(x.equals(y));
        Assert.assertFalse(x.equals(null));

    }

    @Test
    public void testHash() throws Exception {
        HashSet<Person> hashSet = new HashSet<>();
        Person a = new Person("123", 123);
        Person b = new Person("123", 123);
        hashSet.add(a);
        hashSet.add(b);
        System.out.println("set size: " + hashSet.size());
        double f = 0.5;
        Double.doubleToLongBits(f);

    }
}
