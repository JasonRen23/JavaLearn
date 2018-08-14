package cn.jasonren.javalearn.ObjectTest;

/**
 * @author JasonRen
 * @since 2018/8/11 下午9:27
 */

class Address {
    String detail;

    public Address(final String detail) {
        this.detail = detail;
    }
}

class User implements Cloneable {
    int age;
    Address address;

    public User(final int age) {
        this.age = age;
        address = new Address("宜春");
    }

    public int getAge() {
        return age;
    }

    public void setAge(final int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(final Address address) {
        this.address = address;
    }
    //通过调用super.clone()来实现clone()方法

    @Override
    protected User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }
}
public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        User u1 = new User(29);
        User u2 = u1.clone();
        System.out.println(u1.getAge());
        System.out.println(u1.getAddress());
        System.out.println(u2.getAge());
        System.out.println(u2.getAddress());
        System.out.println("-------------------------");
        u2.setAge(18);
        u2.setAddress(new Address("南昌"));
        System.out.println(u1.getAge());
        System.out.println(u1.getAddress());
        System.out.println(u2.getAge());
        System.out.println(u2.getAddress());
        System.out.println(u1 == u2);
        System.out.println(u1.address == u2.address);
    }
}
