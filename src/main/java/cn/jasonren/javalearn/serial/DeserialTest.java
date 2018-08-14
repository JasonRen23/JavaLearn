package cn.jasonren.javalearn.serial;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * @author : JasonRen
 * @date : 2018-08-05 下午12:33
 * @email : zhicheng_ren@163.com
 */
public class DeserialTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person;

        FileInputStream fis = new FileInputStream("Person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        person = (Person) ois.readObject();
        ois.close();
        System.out.println("Person Deserial" + person);
    }
}
