package cn.jasonren.javalearn.serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author : JasonRen
 * @date : 2018-08-05 下午12:31
 * @email : zhicheng_ren@163.com
 */
public class SerialTest {
    public static void main(String[] args) throws IOException {
        Person person = new Person(1234, "ren");
        System.out.println("Person Serial" + person);
        FileOutputStream fos = new FileOutputStream("Person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);
        oos.flush();
        oos.close();
    }
}
